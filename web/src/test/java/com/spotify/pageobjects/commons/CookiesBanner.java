package com.spotify.pageobjects.commons;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.PlaywrightException;
import com.spotify.pageobjects.base.PlaywrightPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.PlaywrightDriverHandler.getPage;

@Component
@Lazy
@Slf4j
public class CookiesBanner extends PlaywrightPage {

    public CookiesBanner handleCookiesBanner() {

        try {
           getPage().waitForSelector("#onetrust-banner-sdk");
            System.out.println("Found the banner");
            clickCookiesAcceptButton();
        } catch (PlaywrightException e) {
            System.out.println("Couldn't find a cookies banner. Proceeding further.");
        }
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
