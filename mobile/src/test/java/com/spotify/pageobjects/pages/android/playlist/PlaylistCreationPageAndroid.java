package com.spotify.pageobjects.pages.android.playlist;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.playlist.PlaylistCreationPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.locators.pages.PlaylistCreationPageLocators.*;

@Component
@Lazy
@Slf4j
public class PlaylistCreationPageAndroid extends AppiumPageAndroid implements PlaylistCreationPage {

    @Step
    public PlaylistCreationPageAndroid verifyPlaylistCreationPageIsOpened() {
        androidElementChecks.assertElementIsVisible(getPlayListCreationPageTitle());
        return this;
    }

    @Step
    public PlaylistCreationPageAndroid enterPlaylistName(String playlistName) {
        getPlaylistNameField().clear();
        getPlaylistNameField().sendKeys(playlistName);
        return this;
    }

    @Step
    public PlaylistCreationPageAndroid tapCreateButton() {
        getCreateButton().click();
        return this;
    }

    @Step
    public PlaylistCreationPageAndroid tapCancelButton() {
        getCancelButton().click();
        return this;
    }

    private WebElement getPlayListCreationPageTitle() {
        return androidElementActions.getElementByXpath(String.format(PLAYLIST_CREATION_PAGE_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().playListCreationPageTitleText()));
    }

    private WebElement getPlaylistNameField() {
        return androidElementActions.getElementByAndroidUiAutomator(String.format(PLAYLIST_NAME_FIELD, ConfigProviderMobile.getMobileAppLocaleConfig().playlistNameFieldText()));
    }

    private WebElement getCreateButton() {
        return androidElementActions.getElementById(CREATE_BUTTON);
    }

    private WebElement getCancelButton() {
        return androidElementActions.getElementById(CANCEL_BUTTON);
    }
}
