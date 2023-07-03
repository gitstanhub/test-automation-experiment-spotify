package com.spotify.pageobjects.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.spotify.utils.browseractions.PlaywrightBrowserActions;

public class LoginPage {

    private final Page page;
    private final PlaywrightBrowserActions playwrightBrowserActions;

    public LoginPage(Page page) {
        this.page = page;
        this.playwrightBrowserActions = new PlaywrightBrowserActions(page);
    }

    public LoginPage open() {
        playwrightBrowserActions.navigateToUrl("https://accounts.spotify.com/en-GB/login");
        return this;
    }

    public LoginPage fillInUsername(String username) {
        playwrightBrowserActions.fillInTextField(getLoginField(), username);
        return this;
    }

    private ElementHandle getLoginField() {
        return page.querySelector("#login-username");
    }
}
