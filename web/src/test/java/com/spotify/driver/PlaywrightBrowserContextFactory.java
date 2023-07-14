package com.spotify.driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.spotify.config.ConfigProviderWeb;

public class PlaywrightBrowserContextFactory {

    public static BrowserContext createBrowserContext(String browserName, Browser browser) {

        double playwrightTimeout = ConfigProviderWeb.getPlaywrightBrowserConfiguration().playwrightTimeout();

        PlaywrightBrowser playwrightBrowser = PlaywrightBrowser.getByName(browserName);

        Browser.NewContextOptions browserContextOptions = new Browser.NewContextOptions()
                .setViewportSize(playwrightBrowser.getWidth(), playwrightBrowser.getHeight())
                .setScreenSize(playwrightBrowser.getWidth(), playwrightBrowser.getHeight())
                .setTimezoneId("Europe/Berlin")
                .setUserAgent(playwrightBrowser.getUserAgent());

        BrowserContext browserContext = browser.newContext(browserContextOptions);
        browserContext.setDefaultTimeout(playwrightTimeout);
        return browserContext;
    }
}
