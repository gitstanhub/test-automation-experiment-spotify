package com.spotify.tests.base;

import com.microsoft.playwright.Page;
import com.spotify.driver.PlaywrightDriverHandler;
import com.spotify.pageobjects.pages.LoginPage;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class WebPlaywrightTestBase {

    private final PlaywrightDriverHandler playwrightDriverHandler = new PlaywrightDriverHandler();
    protected final Page page = PlaywrightDriverHandler.getPage();
    private final BrowserActions browserActions = new BrowserActions(page);
    private final ElementActions elementActions = new ElementActions(page);
    private final LoginPage loginPage = new LoginPage(page);

    @BeforeEach
    public void setUp() {
        loginPage.handleLoginFor("", "");
    }

//    @AfterEach
//    public void tearDown() {
//        playwrightDriverHandler.closeDriver();
//    }
}
