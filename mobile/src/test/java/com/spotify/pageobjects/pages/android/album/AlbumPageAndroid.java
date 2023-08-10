package com.spotify.pageobjects.pages.android.album;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.album.AlbumPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getDriver;

@Component
@Lazy
@Slf4j
public class AlbumPageAndroid extends AppiumPageAndroid implements AlbumPage {

    public AlbumPageAndroid verifyAlbumTitleHasText(String albumTitle) {
        androidElementChecks.assertElementHasExactText(getTitle(), albumTitle);
        return this;
    }

    public AlbumPageAndroid verifyArtistNamesRowContainsArtist(String artistName) {
        androidElementChecks.assertElementContainsText(getCreatorNamesRow(), artistName);
        return this;
    }

    public AlbumPageAndroid verifyAlbumInfoHasText(String albumInfo) {
        androidElementChecks.assertElementHasExactText(getMetaData(), albumInfo);
        return this;
    }

    public AlbumPageAndroid verifyFavouritesButtonIsAvailable() {
        androidElementChecks.assertElementIsVisible(getHeartButton());
        return this;
    }

    public AlbumPageAndroid verifyDownloadButtonIsAvailable() {
        androidElementChecks.assertElementIsVisible(getDownloadButton());
        return this;
    }

    public AlbumPageAndroid verifyTrackCloudIsAvailable() {
        androidElementChecks.assertElementIsVisible(getTrackCloud());
        return this;
    }

    public AlbumPageAndroid verifyAlbumReleaseDateIs(String releaseDate) {
        androidPageNavigationActions.swipeToElementByText("android:id/text1", releaseDate, 10);
        androidElementChecks.assertElementIsVisible(getReleaseDateRow(releaseDate));
        return this;
    }

    public AlbumPageAndroid verifyAlbumArtistListContainsItem(String artistName) {
        androidPageNavigationActions.swipeToElementByText("android:id/text1", artistName, 10);
        androidElementChecks.assertElementIsVisible(getArtistItemFromList(artistName));
        return this;
    }

    public AlbumPageAndroid verifyYouMightAlsoLikeIsAvailable() {
        androidPageNavigationActions.swipeToElementByText("com.spotify.music:id/section_heading2_title", ConfigProviderMobile.getMobileAppLocaleConfig().youMightAlsoLikeTitleText(), 10);
        androidElementChecks.assertElementIsVisible(getYouMightAlsoLikeTitle());
        return this;
    }

    public AlbumPageAndroid verifyCopyRightRowMatches(String copyrightText) {
        androidPageNavigationActions.swipeToElementByText("android:id/text1", copyrightText, 10);
        androidElementChecks.assertElementIsVisible(getCopyrightRow(copyrightText));
        return this;
    }

    private WebElement getTitle() {
        return androidElementActions.getElementById("com.spotify.music:id/title");
    }

    private WebElement getCreatorNamesRow() {
        return androidElementActions.getElementById("com.spotify.music:id/creator_names");
    }

    private WebElement getMetaData() {
        return androidElementActions.getElementById("com.spotify.music:id/metadata");
    }

    private WebElement getHeartButton() {
        return androidElementActions.getElementById("com.spotify.music:id/heart_button");
    }

    private WebElement getDownloadButton() {
        return androidElementActions.getElementById("com.spotify.music:id/download_button");
    }

    private WebElement getTrackCloud() {
        try {
            return androidElementActions.getElementById("com.spotify.music:id/track_cloud_content");
        } catch (NoSuchElementException e) {
            return androidElementActions.getElementById("com.spotify.music:id/track_cloud");
        }
    }

    private WebElement getReleaseDateRow(String releaseDate) {
        return androidElementActions.getElementByXpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='" + releaseDate + "']");
    }

    private WebElement getYouMightAlsoLikeTitle() {
        return androidElementActions.getElementByXpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().youMightAlsoLikeTitleText() + "']");
    }

    private WebElement getCopyrightRow(String copyrightText) {
        return androidElementActions.getElementByXpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='" + copyrightText + "']");
    }

    private WebElement getArtistItemFromList(String artistName) {
        return androidElementActions.getListItemByTitleAndResourceId(artistName, "android:id/text1");
    }
}
