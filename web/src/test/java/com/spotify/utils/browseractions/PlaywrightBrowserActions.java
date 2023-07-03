package com.spotify.utils.browseractions;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class PlaywrightBrowserActions {

    private final Page page;

    public PlaywrightBrowserActions (Page page) {
        this.page = page;
    }

    public void navigateToUrl(String url) {
        page.navigate(url);
    }

    public void fillInTextField(ElementHandle element, String fillInText) {
        element.fill(fillInText);
    }
}
