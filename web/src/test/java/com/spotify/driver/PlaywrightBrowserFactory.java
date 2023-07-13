package com.spotify.driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import lombok.extern.slf4j.Slf4j;

import javax.naming.ConfigurationException;

@Slf4j
public class PlaywrightBrowserFactory {

    public static Browser getBrowser(Playwright playwright,
                                     String requestedBrowser,
                                     String testName,
                                     boolean enableVideo,
                                     boolean headless,
                                     boolean remote) throws ConfigurationException {

        log.info("Opening a new browser [{}]", requestedBrowser);
        PlaywrightBrowser browser = PlaywrightBrowser.getByName(requestedBrowser);

//        return remote ? getRemoteBrowser() : getLocalBrowser()
    }
}
