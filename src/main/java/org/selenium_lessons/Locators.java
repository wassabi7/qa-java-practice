package org.selenium_lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com");
        driver.findElement(By.cssSelector("div.login_logo")).getText();
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.login_logo")).getText(), "Swag Labs");
        Thread.sleep(2000);

        getPassword(driver);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.className("submit-button")).click();
        driver.close();*/

        /* driver.findElement(By.cssSelector("input.submit-button")).click();
         driver.findElement(By.linkText("Forgot your password?")).click();*/

        /* CSS Selector
         Tag name[attribute='value']
         <input type="text" placeholder="Username" value="">
         Input[placeholder]='Username'];
         ParentTagname ChildTagname
         driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("sergio@gmail.com");
         driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
         input[type*='pass']

         Xpath -
         Tag name[@attribute='value']
         input[@placeholder='Username']
         input[@placeholder='Username'][index]
         driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Serhii");
         Tagname[@attribute='value']:nth-child(index) - Child items
         driver.findElement(By.xpath("//form/input[3]")).sendKeys("0999554");
         ParentTagname/ChildTagname
         button[contains(@class,'submit')] - Regular Expression
         //div[@class='forgot-pwd-container']/button[1]*/

        // Sibling - Child parent traverse
        // Absolute XPath starts from the root (<html>)
        // /html/body/header/div/button[1]

        // Relative XPath
        // //header/div/button[1]

        // Дочірній елемент для button[1] з індексом [1]
        // //header/div/button[1]/following-sibling::button[1]

        driver.get("https://rahulshettyacademy.com/AutomationPractice");
        // From parent to child
        String text = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
        System.out.println(text);
        // From child to parent
        // //header/div/button[1]/parent::div
        // //header/div/button[1]/parent::div/parent::header
        // //header/div/button[1]/parent::div/parent::header/a
        String text2 = driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText();
        System.out.println(text2);
    }

    public static void getPassword(WebDriver driver) {
        driver.get("https://www.saucedemo.com");
        String passwordText = driver.findElement(By.cssSelector("div[class='login_password'] h4:nth-child(1)")).getText();
        System.out.println(passwordText);
        // passwordText.split("'");
    }
}
