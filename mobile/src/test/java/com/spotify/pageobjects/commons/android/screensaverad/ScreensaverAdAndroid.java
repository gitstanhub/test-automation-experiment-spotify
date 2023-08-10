package com.spotify.pageobjects.commons.android.screensaverad;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.commons.interfaces.screensaverad.ScreensaverAd;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
@Slf4j
public class ScreensaverAdAndroid extends AppiumPageAndroid implements ScreensaverAd {

    public void handleScreensaverAd() {
        if (isScreensaverAdVisible()) {
            tapOnScreensaverAdDismissButton();
        } else {
            System.out.println("No Screensaver Ad is visible to handle. Proceeding further...");
        }
    }

    private boolean isScreensaverAdVisible() {
        List<WebElement> screensaverAds = androidElementActions.getAllElementsById("com.spotify.music:id/screensaver_ad_banner");
        return !screensaverAds.isEmpty();
    }

    private ScreensaverAdAndroid tapOnScreensaverAdDismissButton() {
        getScreensaverAdDismissButton().click();
        return this;
    }

    private WebElement getScreensaverAdHeader() {
        return androidElementActions.getElementById("com.spotify.music:id/screensaver_ad_header");
    }

    private WebElement getScreensaverAdBanner() {
        return androidElementActions.getElementById("com.spotify.music:id/screensaver_ad_banner");
    }

    private WebElement getScreensaverAdActionButton() {
        return androidElementActions.getElementById("com.spotify.music:id/screensaver_ad_banner_cta");
    }

    private WebElement getScreensaverAdDismissButton() {
        return androidElementActions.getElementById("com.spotify.music:id/screensaver_ad_footer");
    }
}
