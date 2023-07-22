package com.spotify.pageobjects.commons.android;

import com.spotify.utils.assertions.ElementChecks;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpotifyCode {

    private final AndroidDriver driver;
    private final ElementChecks elementChecks;
    private final WebDriverWait wait;

    public SpotifyCode(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.elementChecks = new ElementChecks(driver, wait);
    }

    public SpotifyCode verifySpotifyCodeIsAvailable() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.spotify.music:id/scannable_imageview")));
        elementChecks.assertElementIsVisible(getSpotifyCodeImage());
        return this;
    }

    private WebElement getSpotifyCodeImage() {
        return driver.findElement(By.id("com.spotify.music:id/scannable_imageview"));
    }
}
