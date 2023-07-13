package com.spotify.tests.base;

import com.microsoft.playwright.Page;
import com.spotify.driver.PlaywrightDriverHandler;
import com.spotify.pageobjects.commons.CookiesBanner;
import com.spotify.pageobjects.pages.LoginPage;
import com.spotify.pageobjects.pages.SearchPage;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class WebPlaywrightTestBase {

    private final PlaywrightDriverHandler playwrightDriverHandler = new PlaywrightDriverHandler();
    protected final Page page = playwrightDriverHandler.getPage();
    private final LoginPage loginPage = new LoginPage(page);
    private final SearchPage searchPage = new SearchPage(page);
    private final CookiesBanner cookiesBanner = new CookiesBanner(page);


    @BeforeEach
    public void setUp() {
//        boolean RemoteRun = Boolean.parseBoolean((browserConfig.getProperty("remoteRun"))).toString();
//        boolean headlessMode = Boolean.parseBoolean((browserConfig.getProperty("headlessMode"))).toString();
//        boolean enableVideo = Boolean.parseBoolean((browserConfig.getProperty("enableVideo"))).toString();

        loginPage.handleLoginFor("", "");
        cookiesBanner.handleCookiesBanner();

        // PlaywrightDriverHandler.setupDriver(abc, abc, abc);
    }

    @AfterEach
    public void tearDown() {
        playwrightDriverHandler.closeDriver();
    }
}
