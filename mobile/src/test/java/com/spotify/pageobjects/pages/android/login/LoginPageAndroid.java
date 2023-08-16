package com.spotify.pageobjects.pages.android.login;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.login.LoginPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getWait;
import static com.spotify.locators.pages.LoginPageLocators.*;

@Component
@Lazy
@Slf4j
public class LoginPageAndroid extends AppiumPageAndroid implements LoginPage {

    @Step
    public LoginPageAndroid tapLogInButton() {
        getLogInButton().click();
        return this;
    }

    @Step
    public LoginPageAndroid fillInUsernameField(String username) {
        getUsernameField().sendKeys(username);
        return this;
    }

    @Step
    public LoginPageAndroid fillInPasswordField(String password) {
        getPasswordField().sendKeys(password);
        return this;
    }

    @Step
    public LoginPageAndroid tapLoginSubmitButton() {
        getLoginSubmitButton().click();
        return this;
    }

    @Step
    public void handleLoginFor(String username, String password) {
        try {
            getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(LOGIN_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().logInButtonText()))));
            tapLogInButton();
            fillInUsernameField(username);
            fillInPasswordField(password);
            tapLoginSubmitButton();
        } catch (TimeoutException e) {
            log.info("No Login button is visible to handle. Proceeding further...");
        }
    }

    private WebElement getLogInButton() {
        return androidElementActions.getElementByAndroidUiAutomator(String.format(LOGIN_BUTTON_UIAUTOMATOR, ConfigProviderMobile.getMobileAppLocaleConfig().logInButtonText()));
    }

    private WebElement getUsernameField() {
        return androidElementActions.getElementById(USERNAME_FIELD);
    }

    private WebElement getPasswordField() {
        return androidElementActions.getElementById(PASSWORD_FIELD);
    }

    private WebElement getLoginSubmitButton() {
        return androidElementActions.getElementById(LOGIN_SUBMIT_BUTTON);
    }
}
