package org.selenium_lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//div[@id='nav-link-accountList']/a"));

        Actions action = new Actions(driver);
        // Moving mouse to element + Right click
        action.moveToElement(element).contextClick().build().perform();
        Thread.sleep(2000);

        // Moving to element + send text + highlight text
        WebElement element1 = driver.findElement(By.xpath("//div[@class='nav-search-field '] /input"));
        action.moveToElement(element1).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
    }
}
