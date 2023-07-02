package com.spotify.tests.base;

import com.microsoft.playwright.Page;
import com.spotify.driver.PlaywrightDriverHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class WebPlaywrightTestBase {

    private final PlaywrightDriverHandler playwrightDriverHandler = new PlaywrightDriverHandler();
    protected final Page page = PlaywrightDriverHandler.getPage();

    @BeforeEach
    public void setUp() {
        playwrightDriverHandler.createDriver();
    }

    @AfterEach
    public void tearDown() {
        playwrightDriverHandler.closeDriver();
    }

}
