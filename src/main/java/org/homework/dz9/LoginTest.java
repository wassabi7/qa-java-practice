package org.homework.dz9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginTest {


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        String passToWebsite = "https://www.saucedemo.com/";
        String xPathToTitle = "//div[@class='login_logo']";
        String expectedTitleText = "Swag Labs";

        driver.get(passToWebsite);
        String actualTitleText = driver.findElement(By.xpath(xPathToTitle)).getText();

        Assert.assertEquals(actualTitleText, expectedTitleText, "Wrong title");

        driver.close();
    }
}
