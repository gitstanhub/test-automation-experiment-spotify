package com.spotify.driver;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

import static com.spotify.driver.PlaywrightConstants.getAllSupportedBrowserNames;

@AllArgsConstructor
@Getter
public enum PlaywrightBrowser {

    CHROMIUM(
            "chromium",
            "chromium",
            1280, 720,
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.5790.75 Safari/537.36"
    ),
    FIREFOX(
            "firefox",
            "firefox",
            1280,
            720,
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:115.0) Gecko/20100101 Firefox/115.0"
    ),
    IPHONE_13_PRO(
            "iphone_13_pro",
            "webkit",
            390,
            844,
            "Mozilla/5.0 (iPhone; CPU iPhone OS 15_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Mobile/15E148 Safari/604.1"
    );

    private final String name;
    private final String browserImage;
    private final int width;
    private final int height;
    private final String userAgent;

    public static PlaywrightBrowser getByName(String browserName) {
        return Arrays.stream(PlaywrightBrowser.values())
                .filter(browser -> browser.getName().equals(browserName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Couldn't find a browser by the provided parameter vale: %s, " +
                                "please use one of the following: %s", browserName, getAllSupportedBrowserNames())
                ));
    }
}
