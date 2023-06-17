package com.spotify.android.pageobjects.commons;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreensaverAd {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public ScreensaverAd(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void handleScreensaverAd() {
        //TODO: instead of catching exceptions, try to write a method that would assert that element is not visible
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.spotify.music:id/screensaver_ad_banner")));
            clickOnScreensaverAdDismissButton();
        } catch (TimeoutException e) {
            System.out.println("No Screensaver Ad is visible to handle. Proceeding further...");
        }
    }

    public ScreensaverAd clickOnScreensaverAdDismissButton() {
        getScreensaverAdDismissButton().click();
        return this;
    }

    private WebElement getScreensaverAdHeader() {
        return driver.findElement(By.id("com.spotify.music:id/screensaver_ad_header"));
    }

    private WebElement getScreensaverAdBanner() {
        return driver.findElement(By.id("com.spotify.music:id/screensaver_ad_banner"));
    }

    private WebElement getScreensaverAdActionButton() {
        return driver.findElement(By.id("com.spotify.music:id/screensaver_ad_banner_cta"));
    }

    private WebElement getScreensaverAdDismissButton() {
        return driver.findElement(By.id("com.spotify.music:id/screensaver_ad_footer"));
    }
}
