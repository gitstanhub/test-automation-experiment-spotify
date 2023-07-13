package com.spotify.driver;

import java.util.Arrays;
import java.util.List;

public class PlaywrightConstants {

    /**
     * Timeout amount for the driver in milliseconds
     */
    public static final double CONNECTION_TIMEOUT = 600000;

    /**
     * Currently supported browsers that can be used for both local and remote runs
     */
    protected static final String BROWSER_NAME_CHROMIUM = "chromium";
    protected static final String BROWSER_NAME_FIREFOX = "firefox";
    protected static final String BROWSER_NAME_IPHONE_13_PRO = "iphone_13_pro";
    public static List<String> getAllSupportedBrowserNames() {
        return Arrays.asList(BROWSER_NAME_CHROMIUM, BROWSER_NAME_FIREFOX, BROWSER_NAME_IPHONE_13_PRO);
    }
}
