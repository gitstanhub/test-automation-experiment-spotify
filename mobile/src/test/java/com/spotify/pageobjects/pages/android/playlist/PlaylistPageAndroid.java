package com.spotify.pageobjects.pages.android.playlist;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.playlist.PlaylistPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getWait;
import static com.spotify.locators.pages.PlaylistPageLocators.*;

@Component
@Lazy
@Slf4j
public class PlaylistPageAndroid extends AppiumPageAndroid implements PlaylistPage {

    public PlaylistPageAndroid verifyPlaylistArtworkIsAvailable() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(PLAYLIST_ARTWORK)));
        androidElementChecks.assertElementIsVisible(getPlaylistArtwork());
        return this;
    }

    public PlaylistPageAndroid verifyPlaylistNameIsAvailable() {
        androidElementChecks.assertElementIsVisible(getPlaylistName());
        return this;
    }

    public PlaylistPageAndroid verifyPlaylistNameIsExact(String expectedPlaylistTitle) {
        androidElementChecks.assertElementHasExactText(getPlaylistName(), expectedPlaylistTitle);
        return this;
    }

    public PlaylistPageAndroid verifyDeletePopupTitleIsAvailable() {
        androidElementChecks.assertElementIsVisible(getDeletePopupTitle());
        return this;
    }

    public PlaylistPageAndroid verifyDeletePopupSubtitleIsAvailable(String playlistName) {
        androidElementChecks.assertElementIsVisible(getDeletePopupSubtitle(playlistName));
        return this;
    }

    public PlaylistPageAndroid tapPlaylistDeleteConfirmButton() {
        getDeletePopupConfirmButton().click();
        return this;
    }

    private WebElement getPlaylistArtwork() {
        return androidElementActions.getElementById(PLAYLIST_ARTWORK);
    }

    private WebElement getPlaylistName() {
        return androidElementActions.getElementByXpath(PLAYLIST_NAME);
    }

    private WebElement getDeletePopupTitle() {
        return androidElementActions.getElementByXpath(String.format(DELETE_POPUP_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().deletePopupTitleText()));
    }

    private WebElement getDeletePopupSubtitle(String playlistName) {
        return androidElementActions.getElementByXpath(String.format(DELETE_POPUP_SUBTITLE, ConfigProviderMobile.getMobileAppLocaleConfig().deletePopupSubtitleText(), playlistName));
    }

    private WebElement getDeletePopupConfirmButton() {
        return androidElementActions.getElementByXpath(String.format(DELETE_POPUP_CONFIRM_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().deletePopupConfirmButtonText()));
    }

    private WebElement getDeletePopupCancelButton() {
        return androidElementActions.getElementByXpath(String.format(DELETE_POPUP_CANCEL_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().deletePopupCancelButtonText()));
    }
}
