package com.spotify.driver;

import com.microsoft.playwright.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlaywrightDriverHandler {
//TODO : move driver management into factory class, add SpringBoot @Lazy and @Autowired to the page object initialisation
    //TODO: Add ThreadLocal
    //ToDo: Add BrowserFactory
    //ToDo: Add contextFactory

    private static ThreadLocal<Playwright> playwright = new ThreadLocal<Playwright>();
    private static ThreadLocal<Browser> browser = new ThreadLocal<Browser>();
    private static ThreadLocal<BrowserContext> context = new ThreadLocal<BrowserContext>();
    private static ThreadLocal<Page> page = new ThreadLocal<Page>();
    // private static BrowserFactory browserFactory = new BrowserFactory();

    public static void setBrowser(String browserName, String testName, boolean enableVideo, boolean headless, boolean remote) {
        log.info("Creating new browser session for: '{}'", browserName);

        playwright.set(Playwright.create());

        Browser browserInstance =
    }





//    private void createDriver() {
//        playwright = Playwright.create();
//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        context = browser.newContext();
//        page = context.newPage();
//        page.setViewportSize(1280, 720);
//    }

//    public void closeDriver() {
//        //ToDo: expand
//        context.close();
//        playwright.close();
//    }

//    public Page getPage() {
//        if (page == null) {
//            new PlaywrightDriverHandler().createDriver();
//        }
//        return page;
//    }
}
