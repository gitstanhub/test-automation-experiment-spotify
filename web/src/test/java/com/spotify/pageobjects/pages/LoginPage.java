package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.spotify.config.ConfigProviderWeb;
import com.spotify.pageobjects.base.PlaywrightPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.PlaywrightDriverHandler.getPage;
import static com.spotify.locators.pages.LoginPageLocators.*;

@Component
@Lazy
@Slf4j
public class LoginPage extends PlaywrightPage {

    @Step
    public LoginPage openLoginPage() {
        browserActions.navigateToUrl(ConfigProviderWeb.getWebAppConfiguration().accountsUrl() + "/login");
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

        if (findLoggedOutStateTitle().isVisible()) {
            fillInUsername(username);
            fillInPassword(password);
            clickLoginButton();
            getPage().waitForSelector(WEB_PLAYER_BUTTON, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
            clickWebPlayerButton();
        } else if (findLoggedInStateTitle().isVisible()) {
            clickWebPlayerButton();
        }
        return this;
    }

    private Locator findLoginField() {
        return elementActions.findElementByTestId(LOGIN_FIELD);
    }

    private Locator findPasswordField() {
        return elementActions.findElementByTestId(PASSWORD_FIELD);
    }

    private Locator findLoginButton() {
        return elementActions.findElementByTestId(LOGIN_BUTTON);
    }

    private Locator findLoggedOutStateTitle() {
        return elementActions.findElementByExactText(ConfigProviderWeb.getWebAppLocaleConfig().loggedOutStateTitle());
    }

    private Locator findLoggedInStateTitle() {
        return elementActions.findElementByExactText(ConfigProviderWeb.getWebAppLocaleConfig().loggedInStateTitle());
    }

    private Locator findWebPlayerButton() {
        return elementActions.findElementByTestId(WEB_PLAYER_BUTTON_ID);
    }
}
