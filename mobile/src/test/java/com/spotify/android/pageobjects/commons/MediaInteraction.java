package com.spotify.android.pageobjects.commons;

import com.spotify.android.utils.assertions.ElementChecks;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MediaInteraction {

    private final AndroidDriver driver;
    private final WebDriverWait wait;
    private final ElementChecks elementChecks;

    public MediaInteraction(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.elementChecks = new ElementChecks(driver, wait);
    }

    public MediaInteraction tapContextMenuButton() {
        getContextMenuButton().click();
        return this;
    }

    public MediaInteraction verifyContextMenuButtonIsAvailable() {
        elementChecks.assertElementIsVisible(getContextMenuButton());
        return this;
    }

    public MediaInteraction verifyShuffleButtonIsAvailable() {
        elementChecks.assertElementIsVisible(getShuffleButton());
        return this;
    }

    public MediaInteraction verifyPlayButtonIsAvailable() {
        elementChecks.assertElementIsVisible(getPlayPauseButton());
        return this;
    }

    private WebElement getContextMenuButton() {
        return driver.findElement(By.id("com.spotify.music:id/context_menu_button"));
    }

    private WebElement getShuffleButton() {
        return driver.findElement(By.id("com.spotify.music:id/shuffle_button"));
    }

    private WebElement getPlayPauseButton() {
        return driver.findElement(By.id("com.spotify.music:id/button_play_and_pause"));
    }
}
