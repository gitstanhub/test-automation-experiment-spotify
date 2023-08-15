package com.spotify.pageobjects.commons.android.screensaverad;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.commons.interfaces.screensaverad.ScreensaverAd;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.spotify.locators.commons.ScreensaverAdLocators.*;

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
        List<WebElement> screensaverAds = androidElementActions.getAllElementsById(SCREENSAVER_AD_BANNER);
        return !screensaverAds.isEmpty();
    }

    private ScreensaverAdAndroid tapOnScreensaverAdDismissButton() {
        getScreensaverAdDismissButton().click();
        return this;
    }

    private WebElement getScreensaverAdHeader() {
        return androidElementActions.getElementById(SCREENSAVER_AD_HEADER);
    }

    private WebElement getScreensaverAdBanner() {
        return androidElementActions.getElementById(SCREENSAVER_AD_BANNER);
    }

    private WebElement getScreensaverAdActionButton() {
        return androidElementActions.getElementById(SCREENSAVER_AD_ACTION_BUTTON);
    }

    private WebElement getScreensaverAdDismissButton() {
        return androidElementActions.getElementById(SCREENSAVER_AD_DISMISS_BUTTON);
    }
}
