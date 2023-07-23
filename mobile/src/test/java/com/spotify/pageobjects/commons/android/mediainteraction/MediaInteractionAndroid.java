package com.spotify.pageobjects.commons.android.mediainteraction;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.commons.interfaces.mediainteraction.MediaInteraction;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getDriver;

@Component
@Lazy
@Slf4j
public class MediaInteractionAndroid extends AppiumPageAndroid implements MediaInteraction {

    public MediaInteractionAndroid tapContextMenuButton() {
        getContextMenuButton().click();
        return this;
    }

    public MediaInteractionAndroid verifyContextMenuButtonIsAvailable() {
        elementChecksMobile.assertElementIsVisible(getContextMenuButton());
        return this;
    }

    public MediaInteractionAndroid verifyShuffleButtonIsAvailable() {
        elementChecksMobile.assertElementIsVisible(getShuffleButton());
        return this;
    }

    public MediaInteractionAndroid verifyPlayButtonIsAvailable() {
        elementChecksMobile.assertElementIsVisible(getPlayPauseButton());
        return this;
    }

    private WebElement getContextMenuButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/context_menu_button"));
    }

    private WebElement getShuffleButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/shuffle_button"));
    }

    private WebElement getPlayPauseButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/button_play_and_pause"));
    }
}

//    private final AndroidDriver driver;
//    private final WebDriverWait wait;
//    private final ElementChecks elementChecks;

//    public MediaInteractionAndroid(AndroidDriver driver, WebDriverWait wait) {
//        this.driver = driver;
//        this.wait = wait;
//        this.elementChecks = new ElementChecks(driver, wait);
//    }