package com.spotify.driver;

import com.microsoft.playwright.*;

public class PlaywrightDriverHandler {

    private static Playwright playwright;
    private static BrowserContext context;
    private static Page page;

    public void createDriver() {
        playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1024, 1024);
    }

    public void closeDriver() {
        context.close();
        playwright.close();
    }

    public static Page getPage() {
        if (page == null) {
            new PlaywrightDriverHandler().createDriver();
        }
        return page;
    }
}
