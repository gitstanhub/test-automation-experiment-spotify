package com.spotify.utils;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BrowserActions {

    private final Page page;

    public BrowserActions(Page page) {
        this.page = page;
    }

    public void navigateToUrl(String url) {
        page.navigate(url);
    }

    public void fillInTextField(Locator locatorElement, String fillInText) {
        locatorElement.fill(fillInText);
    }
}
