package com.spotify.pageobjects.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import lombok.extern.java.Log;

public class LoginPage {

    private final Page page;
    private final BrowserActions playwrightBrowserActions;
    private final ElementActions elementActions;

    public LoginPage(Page page) {
        this.page = page;
        this.playwrightBrowserActions = new BrowserActions(page);
        this.elementActions = new ElementActions(page);
    }

    public LoginPage openLoginPage() {
        playwrightBrowserActions.navigateToUrl("https://accounts.spotify.com/en-GB/login");
        return this;
    }

    public LoginPage fillInUsername(String username) {
        playwrightBrowserActions.fillInTextField(findLoginField(), username);
        return this;
    }

    public LoginPage fillInPassword(String password) {
        playwrightBrowserActions.fillInTextField(findPasswordField(), password);
        return this;
    }

    public LoginPage clickLoginButton() {
        findLoginButton().click();
        return this;
    }

    public Locator verifyBlaba() {
       return elementActions.findElementByText("Good evening");
    }

    public LoginPage clickBla() {
        verifyBlaba().click();
        return this;
    }



    public LoginPage handleLoginFor(String username, String password) {
        openLoginPage();

        if (findSignedOutStateTitle().isVisible()) {
            fillInUsername(username);
            fillInPassword(password);
            clickLoginButton();
            verifyBlaba();
            clickBla();
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
        return elementActions.findElementByIdAttribute("login-button");
    }

    private Locator findSignedOutStateTitle() {
        return page.getByText("Log in to Spotify");
    }


}
