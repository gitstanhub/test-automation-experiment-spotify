package com.spotify.pageobjects.pages.android.login;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.login.LoginPage;
import io.appium.java_client.AppiumBy;
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

    private WebElement getLogInButton() {
        return androidElementActions.getElementByAndroidUiAutomator("new UiSelector().className(\"android.widget.Button\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().logInButtonText() + "\")");
//        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().logInButtonText() + "\")"));
    }

    private WebElement getUsernameField() {
        return androidElementActions.getElementById("com.spotify.music:id/username_text");
    }

    private WebElement getPasswordField() {
        return androidElementActions.getElementById("com.spotify.music:id/password_text");
    }

    private WebElement getLoginSubmitButton() {
        return androidElementActions.getElementById("com.spotify.music:id/login_button");
    }
}
