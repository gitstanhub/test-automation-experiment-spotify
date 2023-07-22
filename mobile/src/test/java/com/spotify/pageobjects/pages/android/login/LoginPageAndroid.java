package com.spotify.pageobjects.pages.android.login;

import com.spotify.pageobjects.pages.interfaces.login.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageAndroid implements LoginPage {

    private final AndroidDriver driver;
    protected final WebDriverWait wait;

    public LoginPageAndroid(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public LoginPageAndroid tapLogInButton() {
        getLogInButton().click();
        return this;
    }

    public LoginPageAndroid fillInUsernameField(String username) {
        getUsernameField().sendKeys(username);
        return this;
    }

    public LoginPageAndroid fillInPasswordField(String password) {
        getPasswordField().sendKeys(password);
        return this;
    }

    public LoginPageAndroid tapLoginSubmitButton() {
        getLoginSubmitButton().click();
        return this;
    }

    public void handleLoginFor(String username, String password) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text,'Log in')]")));
            tapLogInButton();
            fillInUsernameField(username);
            fillInPasswordField(password);
            tapLoginSubmitButton();
        } catch (TimeoutException e) {
            System.out.println("No Login button is visible to handle. Proceeding further...");
        }
    }

    //ToDo: Replace xpath with UIAutomator
    private WebElement getLogInButton() {
        return driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Log in')]"));
    }

    private WebElement getUsernameField() {
        return driver.findElement(By.id("com.spotify.music:id/username_text"));
    }

    private WebElement getPasswordField() {
        return driver.findElement(By.id("com.spotify.music:id/password_text"));
    }

    private WebElement getLoginSubmitButton() {
        return driver.findElement(By.id("com.spotify.music:id/login_button"));
    }
}
