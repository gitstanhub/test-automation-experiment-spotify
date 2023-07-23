package com.spotify.driver;

import com.microsoft.playwright.*;
import lombok.extern.slf4j.Slf4j;

import javax.naming.ConfigurationException;

@Slf4j
public class PlaywrightDriverHandler {

    private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> browserContext = new ThreadLocal<>();
    private static final ThreadLocal<Page> page = new ThreadLocal<>();

    public static synchronized void createDriver(String browserName, String testName, boolean enableVideo, boolean headless, boolean remote) throws ConfigurationException {
        log.info("New Playwright driver will be created for the given browser parameter '{}' now", browserName);

        playwright.set(Playwright.create());
        Browser browserInstance = PlaywrightBrowserFactory.getBrowser(playwright.get(), browserName, testName, enableVideo, headless, remote);
        browser.set(browserInstance);

        log.info(String.format("Browser with %s engine and version %s has been started", browser.get().browserType().name(), browser.get().version()));

        browserContext.set(PlaywrightBrowserContextFactory.getBrowserContext(browserName, browserInstance));
        page.set(browserContext.get().newPage());
        listenToConsoleMessages(page.get());
    }

    public static synchronized void closeDriver() {
        try {
            if (browserContext.get() != null) {
                browserContext.get().close();
                browserContext.set(null);
            }

            if (playwright.get() != null) {
                playwright.get().close();
                playwright.set(null);
            }

            log.info("Playwright driver has been closed");

        } catch (Exception e) {
            log.warn("Couldn't close the Playwright driver due to: ", e);
        }

        page.set(null);
        browser.set(null);
    }

    private static void listenToConsoleMessages(Page page) {
        page.onConsoleMessage(consoleMessage -> {
            log.debug("Console log level: {}", consoleMessage.type());
            log.debug("Console message: {}", consoleMessage.text());

            if (consoleMessage.location() != null) {
                log.debug("Console message location: {}", consoleMessage.location());
            }
        });
    }

    public static Page getPage() {
        return page.get();
    }
}
