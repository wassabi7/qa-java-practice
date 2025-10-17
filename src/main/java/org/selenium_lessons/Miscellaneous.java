package org.selenium_lessons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscellaneous {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // Full screen mode
        driver.manage().window().maximize();

        /*// Delete all cookies
        driver.manage().deleteAllCookies();*/

        /*// Delete one cookie by name
        driver.manage().deleteCookieNamed("Asifa");*/

        /*// Add the cookie
        driver.manage().addCookie(new Cookie());*/

        driver.get("https://google.com");
    }
}
