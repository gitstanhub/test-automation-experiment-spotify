package com.spotify.pageobjects.commons;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.PlaywrightException;
import com.spotify.pageobjects.base.PlaywrightPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.PlaywrightDriverHandler.getPage;
import static com.spotify.locators.commons.CookiesBanner.*;

@Component
@Lazy
@Slf4j
public class CookiesBanner extends PlaywrightPage {

    @Step
    public CookiesBanner handleCookiesBanner() {

        try {
            getPage().waitForSelector(COOKIES_BANNER);
            log.info("Found the banner");
            clickCookiesAcceptButton();
        } catch (PlaywrightException e) {
            log.info("Couldn't find a cookies banner. Proceeding further.");
        }
        return this;
    }

    @Step
    public CookiesBanner clickCookiesAcceptButton() {
        log.info("Trying to click on the accept button");
        findCookiesAcceptButton().click();
        return this;
    }

    private Locator findCookiesBanner() {
        return elementActions.findElementById(COOKIES_BANNER);
    }

    private Locator findCookiesAcceptButton() {
        return elementActions.findElementById(COOKIES_ACCEPT_BUTTON);
    }

    private Locator findCookiesSettingsButton() {
        return elementActions.findElementById(COOKIES_SETTINGS_BUTTON);
    }
}
