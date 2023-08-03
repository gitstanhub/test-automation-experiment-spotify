package com.spotify.utils;

import com.microsoft.playwright.Locator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.spotify.driver.PlaywrightDriverHandler.getPage;

@Component
@Slf4j
public class BrowserActions {

    public void navigateToUrl(String url) {
        getPage().navigate(url);
    }

    public void fillInTextField(Locator locatorElement, String fillInText) {
        locatorElement.fill(fillInText);
    }
}
