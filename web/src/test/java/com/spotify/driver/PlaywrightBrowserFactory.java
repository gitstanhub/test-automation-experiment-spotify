package com.spotify.driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.spotify.config.ConfigProviderWeb;
import lombok.extern.slf4j.Slf4j;

import javax.naming.ConfigurationException;
import java.time.LocalDateTime;

import static com.spotify.driver.PlaywrightConstants.REMOTE_CONNECTION_TIMEOUT;

@Slf4j
public class PlaywrightBrowserFactory {

    public static Browser getBrowser(Playwright playwright, String requestedBrowser, String testName, boolean enableVideo,
                                     boolean headless, boolean remote) throws ConfigurationException {

        log.info("Preparing a {} browser", requestedBrowser);
        PlaywrightBrowser playwrightBrowser = PlaywrightBrowser.getByName(requestedBrowser);

        if (remote) {
            return getRemoteBrowser(playwright, playwrightBrowser, testName, enableVideo, headless);
        } else {
            return getLocalBrowser(playwright, playwrightBrowser, headless);
        }
    }

    private static Browser getLocalBrowser(Playwright playwright, PlaywrightBrowser playwrightBrowser, boolean headless) {

        String browserImageName = playwrightBrowser.getBrowserImage();

        log.info("Launching a new browser locally...");

        switch (browserImageName) {
            case "chromium" -> {
                log.info("A Chromium browser is being started locally now");
                return playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
            }
            case "firefox" -> {
                log.info("A Firefox browser is being started locally now");
                return playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
            }
            case "webkit" -> {
                log.info("A WebKit browser is being started locally now");
                return playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
            }
        }
        return null;
    }

    private static Browser getRemoteBrowser(Playwright playwright, PlaywrightBrowser playwrightBrowser, String testName,
                                            boolean enableVideo, boolean headless) throws ConfigurationException {

        String browserImageName = playwrightBrowser.getBrowserImage();

        log.info("Launching a new browser remotely...");

        String browserVersion = getPlaywrightBrowserVersion(playwrightBrowser);
        String moonHubUrl = ConfigProviderWeb.getPlaywrightBrowserConfiguration().moonUrl();

        String sessionName = String.format("%s-%s", LocalDateTime.now(), testName);
        String url = String.format("%s/%s/%s?headless=%s&enableVideo=%s&name=%s",
                moonHubUrl, playwrightBrowser.getBrowserImage(), browserVersion, headless, enableVideo, sessionName);

        log.info("Remote connection's URL is: {}", url);

        switch (browserImageName) {
            case "chromium" -> {
                log.info("A Chromium browser is being started remotely now");
                return playwright.chromium().connect(url, new BrowserType.ConnectOptions().setTimeout(REMOTE_CONNECTION_TIMEOUT));
            }
            case "firefox" -> {
                log.info("A Firefox browser is being started remotely now");
                return playwright.firefox().connect(url, new BrowserType.ConnectOptions().setTimeout(REMOTE_CONNECTION_TIMEOUT));
            }
            case "webkit" -> {
                log.info("A WebKit browser is being started remotely now");
                return playwright.webkit().connect(url, new BrowserType.ConnectOptions().setTimeout(REMOTE_CONNECTION_TIMEOUT));
            }
        }
        return null;
    }

    private static String getPlaywrightBrowserVersion(PlaywrightBrowser playwrightBrowser) throws ConfigurationException {

        String browserImageName = playwrightBrowser.getBrowserImage();

        switch (browserImageName) {
            case "chromium" -> {
                log.info("Getting browser version for Chromium");
                return ConfigProviderWeb.getPlaywrightBrowserConfiguration().chromiumBrowserVersion();
            }
            case "firefox" -> {
                log.info("Getting browser version for Firefox");
                return ConfigProviderWeb.getPlaywrightBrowserConfiguration().firefoxBrowserVersion();
            }
            case "webkit" -> {
                log.info("Getting browser version for WebKit");
                return ConfigProviderWeb.getPlaywrightBrowserConfiguration().webkitBrowserVersion();
            }
            default -> {
                String errorMessage = String.format("Couldn't find a corresponding browser version for %s in the config", browserImageName);
                log.error(errorMessage);
                throw new ConfigurationException(errorMessage);
            }
        }
    }
}
