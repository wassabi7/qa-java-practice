package org.seleniumlessons;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotTest {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // FileUtils.copyFile(screen, new File("D://Screens/screenshot.png"));
    }
}
