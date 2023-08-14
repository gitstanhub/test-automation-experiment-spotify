package com.spotify.pageobjects.commons.android.mediainteraction;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.commons.interfaces.mediainteraction.MediaInteraction;
import io.appium.java_client.AppiumBy;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
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
        androidElementChecks.assertElementIsVisible(getContextMenuButton());
        return this;
    }

    public MediaInteractionAndroid verifyShuffleButtonIsAvailable() {
        androidElementChecks.assertElementIsVisible(getShuffleButton());
        return this;
    }

    public MediaInteractionAndroid verifyPlayButtonIsAvailable() {
        androidElementChecks.assertElementIsVisible(getPlayPauseButton());
        return this;
    }

    private WebElement getContextMenuButton() {
        return androidElementActions.getElementById("com.spotify.music:id/context_menu_button");
    }

    private WebElement getShuffleButton() {

        String contentDesc = ConfigProviderMobile.getMobileAppLocaleConfig().shuffleButtonContentDescriptionText();

        try {
            return androidElementActions.getElementById("com.spotify.music:id/shuffle_button");
        } catch (NoSuchElementException e) {
            return androidElementActions.getElementByAndroidUiAutomator(
                    String.format(
                            "new UiSelector().descriptionContains(\"%s\")",
                            contentDesc));
        }
    }

    private WebElement getPlayPauseButton() {
        return androidElementActions.getElementById("com.spotify.music:id/button_play_and_pause");
    }
}
