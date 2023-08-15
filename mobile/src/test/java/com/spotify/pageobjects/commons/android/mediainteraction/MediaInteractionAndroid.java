package com.spotify.pageobjects.commons.android.mediainteraction;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.commons.interfaces.mediainteraction.MediaInteraction;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.locators.commons.MediaInteractionLocators.*;

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
        return androidElementActions.getElementById(CONTEXT_MENU_BUTTON);
    }

    private WebElement getShuffleButton() {

        String contentDesc = ConfigProviderMobile.getMobileAppLocaleConfig().shuffleButtonContentDescriptionText();

        try {
            return androidElementActions.getElementById(SHUFFLE_BUTTON_ID);
        } catch (NoSuchElementException e) {
            return androidElementActions.getElementByAndroidUiAutomator(
                    String.format(
                            SHUFFLE_BUTTON_UIAUTOMATOR,
                            contentDesc));
        }
    }

    private WebElement getPlayPauseButton() {
        return androidElementActions.getElementById(PLAY_PAUSE_BUTTON);
    }
}
