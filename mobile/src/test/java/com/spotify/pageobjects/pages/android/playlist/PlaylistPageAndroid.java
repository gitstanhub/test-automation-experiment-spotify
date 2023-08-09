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
        elementChecksMobile.assertElementIsVisible(getPlaylistArtwork());
        return this;
    }

    public PlaylistPageAndroid verifyPlaylistNameIsAvailable() {
        elementChecksMobile.assertElementIsVisible(getPlaylistName());
        return this;
    }

    public PlaylistPageAndroid verifyPlaylistNameIsExact(String expectedPlaylistTitle) {
        elementChecksMobile.assertElementHasExactText(getPlaylistName(), expectedPlaylistTitle);
        return this;
    }

    public PlaylistPageAndroid verifyDeletePopupTitleIsAvailable() {
        elementChecksMobile.assertElementIsVisible(getDeletePopupTitle());
        return this;
    }

    public PlaylistPageAndroid verifyDeletePopupSubtitleIsAvailable(String playlistName) {
        elementChecksMobile.assertElementIsVisible(getDeletePopupSubtitle(playlistName));
        return this;
    }

    public PlaylistPageAndroid tapPlaylistDeleteConfirmButton() {
        getDeletePopupConfirmButton().click();
        return this;
    }

    private WebElement getPlaylistArtwork() {
        return getDriver().findElement(By.id("com.spotify.music:id/artwork"));
    }

    private WebElement getPlaylistName() {
        return getDriver().findElement(By.xpath("//*[@resource-id='com.spotify.music:id/content_container']" +
                "//*[@resource-id='com.spotify.music:id/artwork']" +
                "/following-sibling::*[@resource-id='com.spotify.music:id/title']"
        ));
    }

    private WebElement getDeletePopupTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().deletePopupTitleText() + "']"));
    }

    private WebElement getDeletePopupSubtitle(String playlistName) {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/body' and contains(@text, '" + ConfigProviderMobile.getMobileAppLocaleConfig().deletePopupSubtitleText() + "') and contains(@text, '" + playlistName + "')]"));
    }

    private WebElement getDeletePopupConfirmButton() {
        return getDriver().findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/button_positive' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().deletePopupConfirmButtonText() + "']"));
    }

    private WebElement getDeletePopupCancelButton() {
        return getDriver().findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/button_positive' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().deletePopupCancelButtonText() + "']"));
    }
}
