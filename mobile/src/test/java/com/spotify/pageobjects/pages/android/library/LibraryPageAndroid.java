package com.spotify.pageobjects.pages.android.library;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.library.LibraryPage;
import com.spotify.utils.navigation.android.AndroidPageNavigationActions;
import io.appium.java_client.AppiumBy;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getDriver;

@Component
@Lazy
@Slf4j
public class LibraryPageAndroid extends AppiumPageAndroid implements LibraryPage {

    public LibraryPageAndroid selectArtistItem(String artistName) {

        if (elementChecksMobile.isElementExists("com.spotify.music:id/subtitle")) {
            androidElementActions.getListItemByTitleAndSubtitle(artistName, ConfigProviderMobile.getMobileAppLocaleConfig().artistItemSubtitleText()).click();
        } else {
            androidElementActions.getListItemByTitleAndResourceId(artistName, "com.spotify.music:id/title").click();
        }
        return this;
    }

    public LibraryPageAndroid selectAlbumItem(String albumName, String artistName) {

        if (elementChecksMobile.isElementSelected(getAlbumsButton())) {
            androidElementActions.getListItemByTitleAndSubtitle(albumName, artistName).click();
        } else {
            androidElementActions.getListItemByTitleAndSubtitle(albumName, ConfigProviderMobile.getMobileAppLocaleConfig().albumItemSubtitleText() + " • " + artistName).click();
        }
        return this;
    }

    public LibraryPageAndroid selectPlaylistItem(String playlistName, String playlistAuthorName) {

        if (elementChecksMobile.isElementSelected(getPlaylistsButton())) {
            androidElementActions.getListItemByTitleAndSubtitle(playlistName, playlistAuthorName).click();
        } else {
            androidElementActions.getListItemByTitleAndSubtitle(playlistName, ConfigProviderMobile.getMobileAppLocaleConfig().playlistItemSubtitleText() + " • " + playlistAuthorName).click();
        }
        return this;
    }

    public LibraryPageAndroid verifyLibraryPageIsOpened() {
        elementChecksMobile.assertElementIsVisible(getLibraryPageTitle());
        return this;
    }

    public LibraryPageAndroid verifyArtistButtonIsSelected() {
        elementChecksMobile.assertElementSelected(getArtistsButton());
        return this;
    }

    public LibraryPageAndroid verifyAlbumsButtonIsSelected() {
        elementChecksMobile.assertElementSelected(getAlbumsButton());
        return this;
    }

    public LibraryPageAndroid tapArtistsButton() {
        getArtistsButton().click();
        return this;
    }

    public LibraryPageAndroid tapAlbumsButton() {
        getAlbumsButton().click();
        return this;
    }

    public LibraryPageAndroid tapPlaylistsButton() {
        getPlaylistsButton().click();
        return this;
    }

    public LibraryPageAndroid tapSortButton() {
        String resourceId = "com.spotify.music:id/sort";

        androidPageNavigationActions.swipeToElementById(resourceId, AndroidPageNavigationActions.Direction.DIRECTION_UP, 10);
        getSortButton().click();

        return this;
    }

    public LibraryPageAndroid tapSearchButton() {
        getSearchButton().click();
        return this;
    }

    public LibraryPageAndroid tapCreatePlaylistButton() {
        getCreatePlaylistButton().click();
        return this;
    }

    public LibraryPageAndroid choosePlaylistOption() {
        getCreatePlaylistMenuPlaylistButton().click();
        return this;
    }

    private WebElement getProfileButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.spotify.music:id/faceheader_image\").description(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().profileButtonText() + "\")"));
    }

    private WebElement getLibraryPageTitle() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.spotify.music:id/faceheader_title\").description(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().libraryPageTitleText() + "\")"));
    }

    private WebElement getPlaylistsButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().playlistsButtonText() + "\")"));
    }

    private WebElement getAlbumsButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().albumsButtonText() + "\")"));
    }

    private WebElement getArtistsButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().artistsButtonText() + "\")"));
    }

    private WebElement getSearchButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/icon_search"));
    }

    private WebElement getCreatePlaylistButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/icon_create"));
    }

    private WebElement getSortButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/sort"));
    }

    private WebElement getChangeLayoutButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/icon_grid_list"));
    }

    private WebElement getCreatePlaylistMenuTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/heading' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().createPlaylistMenuTitleText() + "']"));
    }

    private WebElement getCreatePlaylistMenuPlaylistButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/create_playlist_row"));
    }

    private WebElement getCreatePlaylistMenuBlendButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/title"));
    }
}
