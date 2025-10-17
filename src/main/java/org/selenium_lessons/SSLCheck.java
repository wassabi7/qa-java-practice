package org.selenium_lessons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {
    public static void main(String[] args) {
        ChromeOptions op = new ChromeOptions();
        op.setAcceptInsecureCerts(true);

        /*// Add an extensions
        op.addExtensions( new File("path/to/extension.crx"));*/

        /*// Set proxy
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        op.setCapability("proxy", proxy);*/

        /*// Disabler popup message
        op.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));*/

        /*// Download directory
        Map<String, Objects> prefs = new HashMap<String, Object>();
        prefs.put("download.default.directory", "/directory/path");
        op.setExperimentalOption("prefs", prefs);*/

        WebDriver driver = new ChromeDriver(op);
        driver.get("https://expired.badssl.com");
    }
}
