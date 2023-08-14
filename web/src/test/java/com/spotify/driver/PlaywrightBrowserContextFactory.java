package com.spotify.driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.spotify.config.ConfigProviderWeb;

public class PlaywrightBrowserContextFactory {

    public static BrowserContext getBrowserContext(String browserName, Browser browser) {

        double playwrightBrowserTimeout = ConfigProviderWeb.getPlaywrightBrowserConfiguration().playwrightBrowserTimeout();

        String locale = ConfigProviderWeb.getWebAppConfiguration().localeCode();

        PlaywrightBrowser playwrightBrowser = PlaywrightBrowser.getByName(browserName);

        Browser.NewContextOptions browserContextOptions = new Browser.NewContextOptions()
                .setViewportSize(playwrightBrowser.getWidth(), playwrightBrowser.getHeight())
                .setScreenSize(playwrightBrowser.getWidth(), playwrightBrowser.getHeight())
                .setTimezoneId("Europe/Berlin")
                .setUserAgent(playwrightBrowser.getUserAgent())
                .setLocale(locale);

        BrowserContext browserContext = browser.newContext(browserContextOptions);
        browserContext.setDefaultTimeout(playwrightBrowserTimeout);

        return browserContext;
    }
}
