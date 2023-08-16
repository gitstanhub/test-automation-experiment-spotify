package com.spotify.pageobjects.pages.android.library;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.library.LibraryPage;
import com.spotify.utils.android.navgiation.AndroidPageNavigationActions;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.locators.pages.LibraryPageLocators.*;

@Component
@Lazy
@Slf4j
public class LibraryPageAndroid extends AppiumPageAndroid implements LibraryPage {

    @Step
    public LibraryPageAndroid selectArtistItem(String artistName) {

        if (androidElementChecks.isElementExists(ARTIST_ITEM_SUBTITLE_ID)) {
            androidElementActions.getListItemByTitleAndSubtitle(artistName, ConfigProviderMobile.getMobileAppLocaleConfig().artistItemSubtitleText()).click();
        } else {
            androidElementActions.getListItemByTitleAndResourceId(artistName, ARTIST_ITEM_TITLE_ID).click();
        }
        return this;
    }

    @Step
    public LibraryPageAndroid selectAlbumItem(String albumName, String artistName) {

        if (androidElementChecks.isElementSelected(getAlbumsButton())) {
            androidElementActions.getListItemByTitleAndSubtitle(albumName, artistName).click();
        } else {
            androidElementActions.getListItemByTitleAndSubtitle(albumName, ConfigProviderMobile.getMobileAppLocaleConfig().albumItemSubtitleText() + " • " + artistName).click();
        }
        return this;
    }

    @Step
    public LibraryPageAndroid selectPlaylistItem(String playlistName, String playlistAuthorName) {

        if (androidElementChecks.isElementSelected(getPlaylistsButton())) {
            androidElementActions.getListItemByTitleAndSubtitle(playlistName, playlistAuthorName).click();
        } else {
            androidElementActions.getListItemByTitleAndSubtitle(playlistName, ConfigProviderMobile.getMobileAppLocaleConfig().playlistItemSubtitleText() + " • " + playlistAuthorName).click();
        }
        return this;
    }

    @Step
    public LibraryPageAndroid verifyLibraryPageIsOpened() {
        androidElementChecks.assertElementIsVisible(getLibraryPageTitle());
        return this;
    }

    @Step
    public LibraryPageAndroid verifyArtistButtonIsSelected() {
        androidElementChecks.assertElementSelected(getArtistsButton());
        return this;
    }

    @Step
    public LibraryPageAndroid verifyAlbumsButtonIsSelected() {
        androidElementChecks.assertElementSelected(getAlbumsButton());
        return this;
    }

    @Step
    public LibraryPageAndroid tapArtistsButton() {
        getArtistsButton().click();
        return this;
    }

    @Step
    public LibraryPageAndroid tapAlbumsButton() {
        getAlbumsButton().click();
        return this;
    }

    @Step
    public LibraryPageAndroid tapPlaylistsButton() {
        getPlaylistsButton().click();
        return this;
    }

    @Step
    public LibraryPageAndroid tapSortButton() {
        androidPageNavigationActions.swipeToElementById(SORT_BUTTON, AndroidPageNavigationActions.Direction.DIRECTION_UP, 10);
        getSortButton().click();

        return this;
    }

    @Step
    public LibraryPageAndroid tapSearchButton() {
        getSearchButton().click();
        return this;
    }

    @Step
    public LibraryPageAndroid tapCreatePlaylistButton() {
        getCreatePlaylistButton().click();
        return this;
    }

    @Step
    public LibraryPageAndroid choosePlaylistOption() {
        getCreatePlaylistMenuButton().click();
        return this;
    }

    private WebElement getProfileButton() {
        return androidElementActions.getElementByAndroidUiAutomator(String.format(PROFILE_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().profileButtonText()));
    }

    private WebElement getLibraryPageTitle() {
        return androidElementActions.getElementByAndroidUiAutomator(String.format(LIBRARY_PAGE_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().libraryPageTitleText()));
    }

    private WebElement getPlaylistsButton() {
        return androidElementActions.getElementByAndroidUiAutomator(String.format(PLAYLISTS_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().playlistsButtonText()));
    }

    private WebElement getAlbumsButton() {
        return androidElementActions.getElementByAndroidUiAutomator(String.format(ALBUMS_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().albumsButtonText()));
    }

    private WebElement getArtistsButton() {
        return androidElementActions.getElementByAndroidUiAutomator(String.format(ARTISTS_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().artistsButtonText()));
    }

    private WebElement getSearchButton() {
        return androidElementActions.getElementById(SEARCH_BUTTON);
    }

    private WebElement getCreatePlaylistButton() {
        return androidElementActions.getElementById(CREATE_PLAYLIST_BUTTON);
    }

    private WebElement getSortButton() {
        return androidElementActions.getElementById(SORT_BUTTON);
    }

    private WebElement getChangeLayoutButton() {
        return androidElementActions.getElementById(CHANGE_LAYOUT_BUTTON);
    }

    private WebElement getCreatePlaylistMenuTitle() {
        return androidElementActions.getElementByXpath(String.format(CREATE_PLAYLIST_MENU_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().createPlaylistMenuTitleText()));
    }

    private WebElement getCreatePlaylistMenuButton() {
        return androidElementActions.getElementById(CREATE_PLAYLIST_MENU_BUTTON);
    }
}
