package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.spotify.config.ConfigProviderWeb;
import com.spotify.pageobjects.base.PlaywrightPage;
import com.spotify.pageobjects.locators.LoginPageTexts;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.PlaywrightDriverHandler.getPage;

@Component
@Lazy
@Slf4j
public class LoginPage extends PlaywrightPage {

    @Autowired
    HomePage homePage;

    @Autowired
    LoginPageTexts loginPageTexts;

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
//        homePage.openHomePage();
        openLoginPage();

        if (findLoggedOutStateTitle().isVisible()) {
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

    private Locator findLoggedOutStateTitle() {
        return elementActions.findElementByExactText(loginPageTexts.getLoggedOutStateTitle());
    }

    private Locator findLoggedInStateTitle() {
        return elementActions.findElementByExactText(loginPageTexts.getLoggedInStateTitle());
    }

    private Locator findWebPlayerButton() {
        return elementActions.findElementByTestId("web-player-link");
    }
}
