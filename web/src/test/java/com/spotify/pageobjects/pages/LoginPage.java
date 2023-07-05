package com.spotify.pageobjects.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import com.spotify.utils.ElementChecks;
import io.qameta.allure.Step;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Assertions;

public class LoginPage {

    private final BrowserActions browserActions;
    private final ElementActions elementActions;
    private final ElementChecks elementChecks;
    private final Page page;

    public LoginPage (Page page) {
        this.page = page;
        this.browserActions = new BrowserActions(page);
        this.elementActions = new ElementActions(page);
        this.elementChecks = new ElementChecks(page);
    }

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
            page.waitForSelector("[data-testid = 'web-player-link']", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
//            Assertions.assertTrue(findWebPlayerButton().isEnabled());
//            browserActions.navigateToUrl("https://open.spotify.com/search");
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
        return elementActions.findElementByText("Log in to Spotify");
    }

    private Locator findLoggedInStateTitle() {
        return elementActions.findElementByText("Logged in as");
    }

    private Locator findWebPlayerButton() {
        return elementActions.findElementByTestId("web-player-link");
    }
}
