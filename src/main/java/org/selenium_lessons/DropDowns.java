package org.selenium_lessons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDowns {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise");

        /*
        // Drop down with select tag
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);

        dropdown.selectByIndex(3);
        String text = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(text, "USD");

        dropdown.selectByVisibleText("AED");
        String text2 = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(text2, "AED");

        dropdown.selectByValue("INR");
        String text3 = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(text2, "INR");*/

        /*// Passengers info
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        for (int i = 1; i < 9; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        String res = driver.findElement(By.id("divpaxinfo")).getText();
        Assert.assertEquals(res, "9 Adult");*/

        /*// From - to dynamic dropdown
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1")).click();
        WebElement dynamicDropdownFrom = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1"));
        Select dropdown = new Select(dynamicDropdownFrom);
        dropdown.selectByValue("IXG");
        String text = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(text, "Belagavi (IXG)");
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1")).click();
        WebElement dynamicDropdownTo = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1"));
        Select dropdown1 = new Select(dynamicDropdownTo);
        dropdown1.selectByValue("BKK");
        String text2 = dropdown1.getFirstSelectedOption().getText();
        Assert.assertEquals(text2, "Bangkok (BKK)");


        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1")).click();
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//option[@value='ATQ']")).click();
        driver.findElement(By.xpath("(//option[@value='AMD'])[2]")).click();*/

        /*// AutoSuggestive dropdown
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase("India")) {
                element.click();
                break;
            }
        }*/

        /*// Handling checkbox
        boolean text = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        boolean text1 = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
        System.out.println(text1);

        // Count checkboxes
        int number = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        System.out.println(number);

        Assert.assertFalse(text);
        Assert.assertTrue(text1);*/

        /*// Handling calendar
        driver.findElement(By.xpath("//option[@value='ATQ']")).click();
        driver.findElement(By.xpath("(//option[@value='AMD'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();*/

        /*// Enable or not
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled();

        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
            System.out.println("Enable");
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }*/

        /*// End to end
        // driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        driver.findElement(By.xpath("//option[@value='ATQ']")).click();
        driver.findElement(By.xpath("(//option[@value='AMD'])[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
            System.out.println("Disable");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        for (int i = 1; i < 4; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);

        dropdown.selectByIndex(3);
        String text = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(text, "USD");

        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();*/

        /*// Handling Java Alerts
        String text = "Serhii";
        driver.get("https://rahulshettyacademy.com/AutomationPractice");
        driver.findElement(By.id("name")).sendKeys(text);
        // driver.findElement(By.id("alertbtn")).click();
        // driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().dismiss();*/
    }


}
