package org.homework.dz11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task11 {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

//    @Test
//    public void titleTest () {
//        String actualTitleText = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
//
//        SoftAssert titleAssert = new SoftAssert();
//
//        titleAssert.assertEquals(actualTitleText, "Swag Labs", "Title does not match!");
//
//        titleAssert.assertAll();
//    }

    @Test (dataProvider = "getData")
    public void loginFormTest (String username, String password) {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
        System.out.println(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        System.out.println(password);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "username1";
        data[0][1] = "password1";

        data[1][0] = "username2";
        data[1][1] = "password2";

        data[2][0] = "username3";
        data[2][1] = "password3";

        return data;
    }


}
