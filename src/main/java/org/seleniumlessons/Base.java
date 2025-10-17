package org.seleniumlessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Base {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        driver.get("https://rahulshettyacademy.com/seleniumPractise/#");
        addItem(driver, new String[]{"Cucumber", "Beetroot"});

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

        // Explicit wait
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));

        String text = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
        Assert.assertEquals(text, "Code applied ..!");

        /*// Якщо метод addItem не буде static
        // Створюємо обєкт базового класа "Base" і в нього викликаємо цей метод
        Base b = new Base();
        b.addItem(driver, new String[]{"Cucumber", "Beetroot"});*/

    }

    public static void addItem(WebDriver driver, String[] neededItems) {
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        // List<WebElement> buttons = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
        List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='product-action']/button"));

        // Масив продуктів які ми маємо додати в кошик
        List<String> listOfNeededItems = Arrays.asList(neededItems);

        int j = 0;

        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split(" - ");

            String trimName = name[0].trim();

            if (listOfNeededItems.contains(trimName)) {
                buttons.get(i).click();
                j++;
                if (j == listOfNeededItems.size()) {
                    break;
                }
            }
        }
    }
}
