package org.homework1.dz12;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy (xpath = "//input[@placeholder='Username']")
    private WebElement usernameField;

    @FindBy (xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy (xpath = "//input[@name='login-button']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage loginButtonClick() {
        loginButton.click();
        return this;
    }

    public void loginAssert(String expectedUrl) {
        Assertions.assertThat(driver.getCurrentUrl())
                .isEqualTo(expectedUrl);
    }

    /*public void login (String username, String password) {
        enterUsername(username);
        enterPassword(password);
        loginButtonClick();
    }*/
}
