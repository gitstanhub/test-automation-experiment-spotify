package com.spotify.tests.base;

import com.microsoft.playwright.Page;
import com.spotify.driver.PlaywrightDriverHandler;
import org.junit.jupiter.api.AfterEach;

public class WebPlaywrightTestBase {

    private final PlaywrightDriverHandler playwrightDriverHandler = new PlaywrightDriverHandler();
    protected final Page page = PlaywrightDriverHandler.getPage();

    @AfterEach
    public void tearDown() {
        playwrightDriverHandler.closeDriver();
    }
}
