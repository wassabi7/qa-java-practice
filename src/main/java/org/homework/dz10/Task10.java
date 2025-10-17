package org.homework.dz10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Task10 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        /*WebElement elementById = driver.findElement(By.id("login_button_container"));
        System.out.println(elementById);

        WebElement elementByClassName = driver.findElement(By.className("login-box"));
        System.out.println(elementByClassName);

        WebElement elementByXPath = driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println(elementByXPath);

        WebElement elementByCssSelector = driver.findElement(By.cssSelector("input[type='password']"));
        System.out.println(elementByCssSelector);*/

        List<WebElement> elements = new ArrayList<>();

        elements.add(driver.findElement(By.id("login_button_container")));
        elements.add(driver.findElement(By.className("login-box")));
        elements.add(driver.findElement(By.xpath("//input[@type='text']")));
        elements.add(driver.findElement(By.cssSelector("input[type='password']")));

        for (WebElement element : elements) {
            System.out.println("Element found " + element);
        }

        driver.close();
    }
}
