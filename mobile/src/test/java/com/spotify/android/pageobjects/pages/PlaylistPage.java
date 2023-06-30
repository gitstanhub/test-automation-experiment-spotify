package com.spotify.android.pageobjects.pages;

import com.spotify.android.utils.assertions.ElementChecks;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaylistPage {

    private final AndroidDriver driver;
    private final ElementChecks elementChecks;
    private final WebDriverWait wait;

    public PlaylistPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.elementChecks = new ElementChecks(driver, wait);
    }

    public PlaylistPage verifyPlaylistArtworkIsAvailable() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.spotify.music:id/artwork")));
        elementChecks.assertElementIsVisible(getPlaylistArtwork());
        return this;
    }

    public PlaylistPage verifyPlaylistNameIsAvailable() {
        elementChecks.assertElementIsVisible(getPlaylistName());
        return this;
    }

    public PlaylistPage verifyPlaylistNameIsExact(String expectedPlaylistTitle) {
        elementChecks.assertElementHasExactText(getPlaylistName(), expectedPlaylistTitle);
        return this;
    }

    private WebElement getPlaylistArtwork() {
        return driver.findElement(By.id("com.spotify.music:id/artwork"));
    }

    private WebElement getPlaylistName() {
        return driver.findElement(By.xpath("//*[@resource-id='com.spotify.music:id/content_container']" +
                "//*[@resource-id='com.spotify.music:id/artwork']" +
                "/following-sibling::*[@resource-id='com.spotify.music:id/title']"
        ));
    }
}
