package org.selenium_lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class DriverScope {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice");

        // 1. Count of links on the page.
        // Use tagName "a" + size.
        int count = driver.findElements(By.tagName("a")).size();
        System.out.println(count);

        // 2. Count links in footer section
        // Need to limit driver scope only to footer
        // Create a mini driver for footer section
        WebElement footerDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
        int count2 = footerDriver.findElements(By.tagName("a")).size();
        System.out.println(count2);

        // 3. Count links in first column in footer
        // Create mini driver for first column
        // Find Elements and take size
        WebElement firstFooterColumn = footerDriver.findElement(By.xpath("//td[1]/ul"));
        int count3 = firstFooterColumn.findElements(By.tagName("a")).size();
        System.out.println(count3);

        // 4. Click on each link in teh column and check if the pages are opening
        for (int i = 1; i < firstFooterColumn.findElements(By.tagName("a")).size(); i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

            firstFooterColumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000);
        }
        
        Set<String> set = driver.getWindowHandles();
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            driver.switchTo().window(iterator.next());
            String title = driver.getTitle();
            System.out.println(title);
        }

    }
}
