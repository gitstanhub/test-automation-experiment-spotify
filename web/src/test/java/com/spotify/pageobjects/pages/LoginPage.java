package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.spotify.pageobjects.base.PlaywrightPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.PlaywrightDriverHandler.getPage;

@Component
@Lazy
@Slf4j
public class LoginPage extends PlaywrightPage {

    @Step
    public LoginPage openLoginPage() {
        browserActions.navigateToUrl("https://accounts.spotify.com/en-GB/login");
        return this;
    }

    private LoginPage fillInUsername(String username) {
        browserActions.fillInTextField(findLoginField(), username);
        return this;
    }

    private LoginPage fillInPassword(String password) {
        browserActions.fillInTextField(findPasswordField(), password);
        return this;
    }

    private LoginPage clickLoginButton() {
        findLoginButton().click();
        return this;
    }

    private LoginPage clickWebPlayerButton() {
        findWebPlayerButton().click();
        return this;
    }

    public LoginPage handleLoginFor(String username, String password) {
        openLoginPage();

        if (findSignedOutStateTitle().isVisible()) {
            fillInUsername(username);
            fillInPassword(password);
            clickLoginButton();
            getPage().waitForSelector("[data-testid = 'web-player-link']", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
            clickWebPlayerButton();
        } else if (findLoggedInStateTitle().isVisible()) {
            clickWebPlayerButton();
        }
        return this;
    }

    private Locator findLoginField() {
        return elementActions.findElementByTestId("login-username");
    }

    private Locator findPasswordField() {
        return elementActions.findElementByTestId("login-password");
    }

    private Locator findLoginButton() {
        return elementActions.findElementByTestId("login-button");
    }

    private Locator findSignedOutStateTitle() {
        return elementActions.findElementByExactText("Log in to Spotify");
    }

    private Locator findLoggedInStateTitle() {
        return elementActions.findElementByExactText("Logged in as");
    }

    private Locator findWebPlayerButton() {
        return elementActions.findElementByTestId("web-player-link");
    }
}
