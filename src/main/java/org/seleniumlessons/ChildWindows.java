package org.seleniumlessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class ChildWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        driver.findElement(By.xpath("//a[@class='blinkingText'][1]")).click();
        Thread.sleep(2000);

        Set<String> windows = driver.getWindowHandles(); // [parentId, childId, ...]
        Iterator<String> iterator = windows.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();

        driver.switchTo().window(childId);

        String email = driver.findElement(By.xpath("//p[@class='im-para red']/strong/a")).getText();
        System.out.println(email);

        driver.switchTo().window(parentId);

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);

        // String text = driver.findElement(By.xpath("//p[@class='im-para red']/strong/a")).getText().split("at")[1].trim().split(" ")[0];
    }
}
