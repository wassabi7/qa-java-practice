package org.selenium_lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice");

        // Step 1 get all URLs tied to the links
        // Java methods will call URLs and gets the status code
        // If status code > 400 - URl not working - link is broken

        List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
        SoftAssert softAssert = new SoftAssert();

        for (WebElement link : links) {
            String url = link.getAttribute("href");

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);

            softAssert.assertTrue(responseCode < 400, "The link with Text " + link.getText() + " is broken with code " + responseCode);

        }

        softAssert.assertAll();




    }
}
