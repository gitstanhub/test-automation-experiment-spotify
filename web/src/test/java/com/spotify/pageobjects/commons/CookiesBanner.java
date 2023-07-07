package com.spotify.pageobjects.commons;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;

import java.util.concurrent.TimeoutException;

public class CookiesBanner {

    private final BrowserActions browserActions;
    private final ElementActions elementActions;
    private final Page page;

    public CookiesBanner(Page page) {
        this.page = page;
        this.browserActions = new BrowserActions(page);
        this.elementActions = new ElementActions(page);
    }

    public CookiesBanner handleCookiesBanner() {

        try {
            page.waitForSelector("#onetrust-banner-sdk");
            System.out.println("Found the banner");
            clickCookiesAcceptButton();
        } catch (PlaywrightException e) {
            System.out.println("Couldn't find a cookies banner. Proceeding further.");
        }


//        if (findCookiesBanner().isVisible()) {
//            System.out.println("Banner found");
//            clickCookiesAcceptButton();
//        } else {
//            System.out.println("Banner not found");
//        }

        return this;
    }

    public CookiesBanner clickCookiesAcceptButton() {
        System.out.println("Trying to click on the accept button");
        findCookiesAcceptButton().click();
        return this;
    }

    private Locator findCookiesBanner() {
        return elementActions.findElementById("onetrust-banner-sdk");
    }

    private Locator findCookiesAcceptButton() {
        return elementActions.findElementById("onetrust-accept-btn-handler");
    }

    private Locator findCookiesSettingsButton() {
        return elementActions.findElementById("onetrust-pc-btn-handlerr");
    }
}
