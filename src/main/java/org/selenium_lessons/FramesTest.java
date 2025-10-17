package org.selenium_lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable");

         /*// Switch by Frame id
         driver.findElements(By.tagName("iframe")).size();
         driver.switchTo().frame(1);
         driver.switchTo().frame(2);
         driver.switchTo().frame(3);
         // etc.*/

        // Switch by Frame Web Element
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frame);

        /*// Switch by Frame index
        driver.findElements(By.tagName("iframe")).size();
        driver.switchTo().frame(0);
        driver.switchTo().frame(1);
        driver.switchTo().frame(2);
        // etc..*/

        boolean b = driver.findElement(By.xpath("//div[@id='draggable']")).isDisplayed();
        System.out.println(b);

        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions action = new Actions(driver);
        action.dragAndDrop(source, target).build().perform();

        // Move back from frame
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//a[text()='Accept']")).click();
    }
}
