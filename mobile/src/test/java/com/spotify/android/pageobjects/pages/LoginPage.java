package com.spotify.android.pageobjects.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final AndroidDriver driver;
    protected final WebDriverWait wait;

    public LoginPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public LoginPage clickLogInButton() {
        getLogInButton().click();
        return this;
    }

    public LoginPage fillInUsernameField(String username) {
        getUsernameField().sendKeys(username);
        return this;
    }

    public LoginPage fillInPasswordField(String password) {
        getPasswordField().sendKeys(password);
        return this;
    }

    public LoginPage clickLoginSubmitButton() {
        getLoginSubmitButton().click();
        return this;
    }

    public void handleLoginState(String username, String password) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text,'Log in')]")));
            if (getLogInButton().isDisplayed()) {
                clickLogInButton();
                fillInUsernameField(username);
                fillInPasswordField(password);
                clickLoginSubmitButton();
            }
        } catch (NoSuchElementException e) {
            System.out.println("User is already logged in. Proceeding further...");
        }
    }

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
