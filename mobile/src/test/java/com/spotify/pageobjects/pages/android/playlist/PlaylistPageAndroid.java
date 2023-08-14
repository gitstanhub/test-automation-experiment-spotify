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

import static com.spotify.driver.AppiumDriverHandler.getDriver;
import static com.spotify.driver.AppiumDriverHandler.getWait;

@Component
@Lazy
@Slf4j
public class PlaylistPageAndroid extends AppiumPageAndroid implements PlaylistPage {

    public PlaylistPageAndroid verifyPlaylistArtworkIsAvailable() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("com.spotify.music:id/artwork")));
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
        return androidElementActions.getElementById("com.spotify.music:id/artwork");
    }

    private WebElement getPlaylistName() {
        return androidElementActions.getElementByXpath("//*[@resource-id='com.spotify.music:id/content_container']" +
                "//*[@resource-id='com.spotify.music:id/artwork']" +
                "/following-sibling::*[@resource-id='com.spotify.music:id/title']");
    }

    private WebElement getDeletePopupTitle() {
        return androidElementActions.getElementByXpath("//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().deletePopupTitleText() + "']");
    }

    private WebElement getDeletePopupSubtitle(String playlistName) {
        return androidElementActions.getElementByXpath("//android.widget.TextView[@resource-id='com.spotify.music:id/body' and contains(@text, '" + ConfigProviderMobile.getMobileAppLocaleConfig().deletePopupSubtitleText() + "') and contains(@text, '" + playlistName + "')]");
    }

    private WebElement getDeletePopupConfirmButton() {
        return androidElementActions.getElementByXpath("//android.widget.Button[@resource-id='com.spotify.music:id/button_positive' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().deletePopupConfirmButtonText() + "']");
    }

    private WebElement getDeletePopupCancelButton() {
        return androidElementActions.getElementByXpath("//android.widget.Button[@resource-id='com.spotify.music:id/button_positive' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().deletePopupCancelButtonText() + "']");
    }
}
