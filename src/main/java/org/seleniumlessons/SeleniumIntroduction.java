package org.seleniumlessons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntroduction {
    public static void main(String[] args) {

        // Invoking Browser
        // Chrome - ChromeDriver -> Methods
        // ChromeDriver driver = new ChromeDriver();

        // ChromeDriver.exe -> Chrome Browser
        WebDriver driver = new ChromeDriver();
        // Step to invoke chrome driver
        // Selenium manager
        //System.setProperty("webdriver.chrome.driver", "C:/Users/Wassa/Documents/chromedriver.exe");
        driver.get("http://www.rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        // driver.close(); // закриває поточне вікно
        // driver.quit(); // закриває всі пов'язані вікна відкриті Selenium

        // WebDriver driver1 = new FirefoxDriver();
        // driver1.get("http://www.rahulshettyacademy.com");
    }
}
