package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Page;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import io.qameta.allure.Step;

public class SearchPage {

    private final BrowserActions browserActions;
    private final ElementActions elementActions;

    public SearchPage (Page page) {
        this.browserActions = new BrowserActions(page);
        this.elementActions = new ElementActions(page);
    }

    @Step
    public SearchPage openSearchPage() {
        browserActions.navigateToUrl("https://open.spotify.com/search");
        return this;
    }
}
