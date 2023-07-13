package com.spotify.driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import lombok.extern.slf4j.Slf4j;

import javax.naming.ConfigurationException;
import java.time.LocalDateTime;

import static com.spotify.driver.PlaywrightConstants.CONNECTION_TIMEOUT;

@Slf4j
public class PlaywrightBrowserFactory {

    public static Browser getBrowser(Playwright playwright, String requestedBrowser, String testName, boolean enableVideo,
                                     boolean headless, boolean remote) throws ConfigurationException {

        log.info("Opening a new browser [{}]", requestedBrowser);
        PlaywrightBrowser browser = PlaywrightBrowser.getByName(requestedBrowser);

//        return remote ? getRemoteBrowser() : getLocalBrowser()
    }

    private static Browser getLocalBrowser(Playwright playwright, PlaywrightBrowser playwrightBrowser, boolean headless) {

        log.info("Launching a local browser...");

        switch (playwrightBrowser.getBrowserImage()) {
            case "chromium" -> {
                log.info("A Chromium browser is selected to start locally");
                return playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
            }
            case "firefox" -> {
                log.info("A Firefox browser is selected to start locally");
                return playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
            }
            case "webkit" -> {
                log.info("A WebKit browser is selected to start locally");
                return playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
            }
        }
        return null;
    }

    private static Browser getRemoteBrowser(Playwright playwright, PlaywrightBrowser playwrightBrowser, String testName,
                                            boolean enableVideo, boolean headless) throws ConfigurationException {

        log.info("Launching a remote browser...");

//        String browserVersion = getBrowserVersionFromConfig();
        String moonHubUrl = "https://moonhuburl.com"; // fetch from config

        String sessionName = String.format("%s-%s", LocalDateTime.now(), testName);
        String url = String.format("%s/%s?headless=%s&enableVideo=%s&name=%s",
                moonHubUrl, playwrightBrowser.getBrowserImage(), headless, enableVideo, sessionName);

        log.info("Remote connection's URL is: [{}]", url);

        switch (playwrightBrowser.getBrowserImage()) {
            case "chromium" -> {
                log.info("A Chromium browser is selected to start remotely");
                return playwright.chromium().connect(url, new BrowserType.ConnectOptions().setTimeout(CONNECTION_TIMEOUT));
            }
            case "firefox" -> {
                log.info("A Firefox browser is selected to start remotely");
                return playwright.firefox().connect(url, new BrowserType.ConnectOptions().setTimeout(CONNECTION_TIMEOUT));
            }
            case "webkit" -> {
                log.info("A WebKit browser is selected to start remotely");
                return playwright.webkit().connect(url, new BrowserType.ConnectOptions().setTimeout(CONNECTION_TIMEOUT));
            }
        }
        return null;
    }

//    private static String getBrowserVersion() throws ConfigurationException ;
//    private static String getURL() throws ConfigurationException;
}
