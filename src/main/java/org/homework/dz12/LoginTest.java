package org.homework.dz12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    String url = "https://www.saucedemo.com";
    String expectedUrl = "https://www.saucedemo.com/inventory.html";

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test
    public void loginTest() {
        LoginPage page = new LoginPage(driver);

        page.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .loginButtonClick()
                .loginAssert(expectedUrl);

    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }

}
