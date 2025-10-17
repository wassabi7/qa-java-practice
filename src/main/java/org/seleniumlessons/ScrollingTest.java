package org.seleniumlessons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class ScrollingTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]"));
        int sum = 0;
        for (WebElement el : list) {
            sum += Integer.parseInt(el.getText());
        }
        System.out.println(sum);

        int totalAmount = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
        System.out.println(totalAmount);
        Assert.assertEquals(sum, totalAmount);

    }
}
