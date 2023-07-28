package com.spotify.pageobjects.commons.android.screensaverad;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.commons.interfaces.screensaverad.ScreensaverAd;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getDriver;
import static com.spotify.driver.AppiumDriverHandler.getWait;

@Component
@Lazy
@Slf4j
public class ScreensaverAdAndroid extends AppiumPageAndroid implements ScreensaverAd {

    public void handleScreensaverAd() {
        //TODO: instead of catching exceptions, try to write a method that would assert that element is not visible
        try {
            getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("com.spotify.music:id/screensaver_ad_banner")));
            tapOnScreensaverAdDismissButton();
        } catch (TimeoutException e) {
            System.out.println("No Screensaver Ad is visible to handle. Proceeding further...");
        }
    }

    private ScreensaverAdAndroid tapOnScreensaverAdDismissButton() {
        getScreensaverAdDismissButton().click();
        return this;
    }

    private WebElement getScreensaverAdHeader() {
        return getDriver().findElement(By.id("com.spotify.music:id/screensaver_ad_header"));
    }

    private WebElement getScreensaverAdBanner() {
        return getDriver().findElement(By.id("com.spotify.music:id/screensaver_ad_banner"));
    }

    private WebElement getScreensaverAdActionButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/screensaver_ad_banner_cta"));
    }

    private WebElement getScreensaverAdDismissButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/screensaver_ad_footer"));
    }
}
