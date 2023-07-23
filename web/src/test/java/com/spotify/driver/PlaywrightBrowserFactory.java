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

        log.info("Preparing a new '{}' browser", requestedBrowser);
        PlaywrightBrowser playwrightBrowser = PlaywrightBrowser.getByName(requestedBrowser);

        if (remote) {
            return getRemoteBrowser(playwright, playwrightBrowser, testName, enableVideo, headless);
        } else {
            return getLocalBrowser(playwright, playwrightBrowser, headless);
        }
    }

    private static Browser getRemoteBrowser(Playwright playwright, PlaywrightBrowser playwrightBrowser, String testName,
                                            boolean enableVideo, boolean headless) throws ConfigurationException {

        String browserImageName = playwrightBrowser.getBrowserImage();

        log.info("Launching a new browser session remotely");

        String browserVersion = getPlaywrightBrowserVersion(playwrightBrowser);
        String moonHubUrl = ConfigProviderWeb.getPlaywrightBrowserConfiguration().moonUrl();

        String sessionName = String.format("%s-%s", LocalDateTime.now(), testName);
        String url = String.format("%s/%s/%s?headless=%s&enableVideo=%s&name=%s",
                moonHubUrl, playwrightBrowser.getBrowserImage(), browserVersion, headless, enableVideo, sessionName);

        log.info("Remote connection's URL is: {}", url);

        switch (browserImageName) {
            case "chromium" -> {
                log.info("A Chromium engine browser is expected to be started remotely now");
                return playwright.chromium().connect(url, new BrowserType.ConnectOptions().setTimeout(REMOTE_CONNECTION_TIMEOUT));
            }
            case "firefox" -> {
                log.info("A Firefox engine browser is expected to be started remotely now");
                return playwright.firefox().connect(url, new BrowserType.ConnectOptions().setTimeout(REMOTE_CONNECTION_TIMEOUT));
            }
            case "webkit" -> {
                log.info("A WebKit engine browser is expected to be started remotely now");
                return playwright.webkit().connect(url, new BrowserType.ConnectOptions().setTimeout(REMOTE_CONNECTION_TIMEOUT));
            }
        }
        return null;
    }

    private static String getPlaywrightBrowserVersion(PlaywrightBrowser playwrightBrowser) throws ConfigurationException {
        log.info("Trying to fetch a version info for the provided browser from the environment properties");

        String browserImageName = playwrightBrowser.getBrowserImage();

        switch (browserImageName) {
            case "chromium" -> {
                log.info("Getting browser version from the environment properties for Chromium");
                return ConfigProviderWeb.getPlaywrightBrowserConfiguration().chromiumBrowserVersion();
            }
            case "firefox" -> {
                log.info("Getting browser version from the environment properties for Firefox");
                return ConfigProviderWeb.getPlaywrightBrowserConfiguration().firefoxBrowserVersion();
            }
            case "webkit" -> {
                log.info("Getting browser version from the environment properties for WebKit");
                return ConfigProviderWeb.getPlaywrightBrowserConfiguration().webkitBrowserVersion();
            }
            default -> {
                String errorMessage = String.format("There's no data available for a browser with the image of type '%s' in the environment properties yet," +
                        " so the browser version cannot be fetched", browserImageName);
                throw new ConfigurationException(errorMessage);
            }
        }
    }

    private static Browser getLocalBrowser(Playwright playwright, PlaywrightBrowser playwrightBrowser, boolean headless) {

        String browserImageName = playwrightBrowser.getBrowserImage();

        log.info("Launching a new browser session locally");

        switch (browserImageName) {
            case "chromium" -> {
                log.info("A Chromium engine browser is expected to be started locally now");
                return playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
            }
            case "firefox" -> {
                log.info("A Firefox engine browser is expected to be started locally now");
                return playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
            }
            case "webkit" -> {
                log.info("A WebKit engine browser is expected to be started locally now");
                return playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
            }
        }
        return null;
    }
}
