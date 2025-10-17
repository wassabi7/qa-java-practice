package org.selenium_lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CalendarTest {
    public static void main(String[] args) {

        String year = "2027";
        String day = "15";
        String month = "6";
        String[] expectedList = {month, day, year};

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/cart");

        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)).click();
        driver.findElement(By.xpath("//abbr[text()='" + day + "']")).click();

        List<WebElement> list = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for (WebElement element : list) {
            System.out.println(element.getAttribute("value"));
            Assert.assertEquals(element.getAttribute("value"), expectedList);
        }
        driver.close();
    }
}
