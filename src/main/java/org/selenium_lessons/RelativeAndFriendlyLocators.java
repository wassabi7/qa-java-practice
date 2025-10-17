package org.selenium_lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeAndFriendlyLocators {
    // Syntax driver.findElement(withTagName("XX").above(WebElement))
    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice");

        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
        String label = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();

        System.out.println(label);
        driver.close();
    }


}
