package org.selenium_lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.xpath("//div/h4[text()='Hello World!']")).isDisplayed()) {
                    return driver.findElement(By.xpath("//div/h4[text()='Hello World!']"));
                }
                return null;
            }
        });

        boolean text = driver.findElement(By.xpath("//div/h4[text()='Hello World!']")).isDisplayed();
        System.out.println(text);
    }
}
