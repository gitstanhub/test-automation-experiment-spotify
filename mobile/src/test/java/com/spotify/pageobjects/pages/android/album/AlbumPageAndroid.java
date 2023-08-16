package com.spotify.pageobjects.pages.android.album;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.album.AlbumPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getDriver;
import static com.spotify.locators.pages.AlbumPageLocators.*;

@Component
@Lazy
@Slf4j
public class AlbumPageAndroid extends AppiumPageAndroid implements AlbumPage {

    @Step
    public AlbumPageAndroid verifyAlbumTitleHasText(String albumTitle) {
        androidElementChecks.assertElementHasExactText(getTitle(), albumTitle);
        return this;
    }

    @Step
    public AlbumPageAndroid verifyArtistNamesRowContainsArtist(String artistName) {
        androidElementChecks.assertElementContainsText(getCreatorNamesRow(), artistName);
        return this;
    }

    @Step
    public AlbumPageAndroid verifyAlbumInfoHasText(String albumType, Integer albumReleaseYear) {
        androidElementChecks.assertElementContainsText(getMetaData(), albumType);
        androidElementChecks.assertElementContainsText(getMetaData(), albumReleaseYear.toString());
        return this;
    }

    @Step
    public AlbumPageAndroid verifyFavouritesButtonIsAvailable() {
        androidElementChecks.assertElementIsVisible(getHeartButton());
        return this;
    }

    @Step
    public AlbumPageAndroid verifyDownloadButtonIsAvailable() {
        androidElementChecks.assertElementIsVisible(getDownloadButton());
        return this;
    }

    @Step
    public AlbumPageAndroid verifyTrackCloudIsAvailable() {
        androidElementChecks.assertElementIsVisible(getTrackCloud());
        return this;
    }

    @Step
    public AlbumPageAndroid verifyAlbumReleaseDateIs(String releaseDate) {
        androidPageNavigationActions.swipeToElementByText(RELEASE_DATE_ROW_ID, releaseDate, 10);
        androidElementChecks.assertElementIsVisible(getReleaseDateRow(releaseDate));
        return this;
    }

    @Step
    public AlbumPageAndroid verifyAlbumArtistListContainsItem(String artistName) {
        androidPageNavigationActions.swipeToElementByText(ALBUM_ARTIST_LIST_ID, artistName, 10);
        androidElementChecks.assertElementIsVisible(getArtistItemFromList(artistName));
        return this;
    }

    @Step
    public AlbumPageAndroid verifyYouMightAlsoLikeIsAvailable() {
        androidPageNavigationActions.swipeToElementByText(YOU_MIGHT_ALSO_LIKE_TITLE_ID, ConfigProviderMobile.getMobileAppLocaleConfig().youMightAlsoLikeTitleText(), 10);
        androidElementChecks.assertElementIsVisible(getYouMightAlsoLikeTitle());
        return this;
    }

    @Step
    public AlbumPageAndroid verifyCopyRightRowMatches(String copyrightText) {
        androidPageNavigationActions.swipeToElementByText(COPYRIGHT_ROW_ID, copyrightText, 10);
        androidElementChecks.assertElementIsVisible(getCopyrightRow(copyrightText));
        return this;
    }

    private WebElement getTitle() {
        return androidElementActions.getElementById(TITLE);
    }

    private WebElement getCreatorNamesRow() {
        return androidElementActions.getElementById(CREATORS_NAME_ROW);
    }

    private WebElement getMetaData() {
        return androidElementActions.getElementById(META_DATA);
    }

    private WebElement getHeartButton() {
        return androidElementActions.getElementById(HEART_BUTTON);
    }

    private WebElement getDownloadButton() {
        return androidElementActions.getElementById(DOWNLOAD_BUTTON);
    }

    private WebElement getTrackCloud() {
        try {
            return androidElementActions.getElementById(TRACK_CLOUD_ID_FIRST);
        } catch (NoSuchElementException e) {
            return androidElementActions.getElementById(TRACK_CLOUD_ID_SECOND);
        }
    }

    private WebElement getReleaseDateRow(String releaseDate) {
        return androidElementActions.getElementByXpath(String.format(RELEASE_DATE_ROW, releaseDate));
    }

    private WebElement getYouMightAlsoLikeTitle() {
        return androidElementActions.getElementByXpath(String.format(YOU_MIGHT_ALSO_LIKE, ConfigProviderMobile.getMobileAppLocaleConfig().youMightAlsoLikeTitleText()));
    }

    private WebElement getCopyrightRow(String copyrightText) {
        return androidElementActions.getElementByXpath(String.format(COPYRIGHT_ROW, copyrightText));
    }

    private WebElement getArtistItemFromList(String artistName) {
        return androidElementActions.getListItemByTitleAndResourceId(artistName, ARTIST_LIST_ITEM_ID);
    }
}
