package com.spotify.pageobjects.pages.android.login;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.login.LoginPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getDriver;
import static com.spotify.driver.AppiumDriverHandler.getWait;

@Component
@Lazy
@Slf4j
public class LoginPageAndroid extends AppiumPageAndroid implements LoginPage {

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
            getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text,'" + ConfigProviderMobile.getMobileAppLocaleConfig().logInButtonText() + "')]")));
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
        return getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'" + ConfigProviderMobile.getMobileAppLocaleConfig().logInButtonText() + "')]"));
    }

    private WebElement getUsernameField() {
        return getDriver().findElement(By.id("com.spotify.music:id/username_text"));
    }

    private WebElement getPasswordField() {
        return getDriver().findElement(By.id("com.spotify.music:id/password_text"));
    }

    private WebElement getLoginSubmitButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/login_button"));
    }
}
