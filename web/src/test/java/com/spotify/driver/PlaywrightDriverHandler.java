package com.spotify.driver;

import com.microsoft.playwright.*;
import com.microsoft.playwright.impl.SharedSelectors;

public class PlaywrightDriverHandler {
//TODO : move driver management into factory class, add SpringBoot @Lazy and @Autowired to the page object initialisation

    private static Playwright playwright;
    private static BrowserContext context;
    private static Page page;

    private void createDriver() {
        playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1280, 720);
        new SharedSelectors().setTestIdAttribute("id99");
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
