package org.homework.dz15;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiTests {

    private final static String BASE_URL = "https://petstore.swagger.io/v2";
    private final static String ENDPOINT_PET = "/pet";
    private final static String ENDPOINT_FINDBYSTATUS = ENDPOINT_PET + "/findByStatus";


    @BeforeTest
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    @Epic("API Tests")
    @Feature("API Feature")
    @Story("Valid API GET Request")
    @Description("This test check status code of GET request to Swagger Pet Store API.")
    @Severity(SeverityLevel.NORMAL)
    public void checkStatusCode200() {
        Response response = given()
                .pathParam("id", 12)
                .when()
                .get(ENDPOINT_PET + "/{id}")
                .then().log().all()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void checkResponseTitleAfterPost() throws JsonProcessingException {
        Category kittens = new Category(1, "kittens");
        List<String> photos = List.of();
        List<Tag> tags = List.of();
        Pet cat = new Pet(1, kittens, "Catty", photos, tags, "available");

        ObjectMapper objectMapper = new ObjectMapper();
        String postJson = objectMapper.writeValueAsString(cat);

        Response response = given()
                .contentType("application/json")
                .body(postJson)
                .when()
                .post(ENDPOINT_PET)
                .then().log().all()
                .extract().response();

        Pet responsePost = objectMapper.readValue(response.asString(), Pet.class);
        Assert.assertEquals(responsePost.getName(), cat.getName());
    }

    @Test
    public void checkGetRequestFromSwaggerPetStore() {
        String searchStatus = "pending";

        Response response = given()
                .queryParam("status", searchStatus)
                .when()
                .get(ENDPOINT_FINDBYSTATUS)
                .then().log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        List<String> statuses = jsonPath.get("status");

        for (String status : statuses) {
            Assert.assertEquals(status, searchStatus);
        }
    }
}
