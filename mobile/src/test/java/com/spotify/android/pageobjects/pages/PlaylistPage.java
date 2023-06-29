package com.spotify.android.pageobjects.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlaylistPage {

    private final AndroidDriver driver;

    public PlaylistPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private WebElement getPlaylistArtwork() {
       return driver.findElement(By.id("com.spotify.music:id/artwork"));
    }

    private WebElement getPlaylistName(String createdPlaylistName) {
        return driver.findElement(AppiumBy.androidUIAutomator("")
    }
}
