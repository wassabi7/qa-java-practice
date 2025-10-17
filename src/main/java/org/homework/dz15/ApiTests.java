package org.homework.dz15;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiTests {

    private final static String URL = "https://petstore.swagger.io/";

    @Test
    public void checkStatusCode200() {
        Response response = given()
                .when()
                .get(URL + "#/pet/addPet")
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
                .post(URL + "v2/pet")
                .then().log().all()
                .extract().response();

        Pet responsePost = objectMapper.readValue(response.asString(), Pet.class);
        Assert.assertEquals(responsePost.getName(), cat.getName());
    }

    @Test
    public void checkGetRequestFromSwaggerPetStore() {
        Response response = given()
                .when()
                .get(URL + "v2/pet/findByStatus?status=pending")
                .then().log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        List<String> statuses = jsonPath.get("status");

        for (String status : statuses) {
            Assert.assertEquals(status, "pending");
        }
    }
}
