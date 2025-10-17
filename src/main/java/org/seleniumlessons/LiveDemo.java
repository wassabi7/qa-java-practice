package org.seleniumlessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class LiveDemo {

    @Test
    public void getSortedProductNames() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> originalList = elements.stream().map(WebElement::getText).collect(Collectors.toList());

        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        Assert.assertEquals(sortedList, originalList);

        driver.close();
    }

    @Test
    public void findProductValue() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//tr/th[1]")).click();

        List<String> price;
        do {
            List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
            price = elements.stream().filter(s -> s.getText().contains("Rice"))
                    .map(LiveDemo::getPriceVeggie)
                    .toList();
            price.forEach(System.out::println);
            if (price.isEmpty()) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        } while (price.isEmpty());

        driver.close();
    }

    private static String getPriceVeggie(WebElement s) {
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

    @Test
    public void findProductValue123() {
        String productName = "Rice";
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(productName);
        List<WebElement> products = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> newList = products.stream().filter(product -> product.getText().contains(productName))
                .toList();

        Assert.assertEquals(newList.size(), products.size());
        driver.close();
    }
}
