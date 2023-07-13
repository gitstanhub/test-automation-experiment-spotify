package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Page;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import com.spotify.utils.ElementChecks;

public class HomePage {
//extends PlaywrightPage
    private final BrowserActions browserActions;
    private final ElementActions elementActions;
    private final ElementChecks elementChecks;
    private final Page page;

    public HomePage (Page page) {
        this.page = page;
        this.browserActions = new BrowserActions(page);
        this.elementActions = new ElementActions(page);
        this.elementChecks = new ElementChecks(page);
    }

    public HomePage openHomePage() {
        browserActions.navigateToUrl("https://open.spotify.com/");
        return this;
    }
}
