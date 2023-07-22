package com.spotify.pageobjects.pages.android.album;

import com.spotify.pageobjects.commons.android.MediaInteraction;
import com.spotify.pageobjects.pages.interfaces.album.AlbumPage;
import com.spotify.utils.assertions.ElementChecks;
import com.spotify.utils.navigation.android.AndroidPageNavigationActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlbumPageAndroid implements AlbumPage {
    private final AndroidDriver driver;
    private final ElementChecks elementChecks;
    private final AndroidPageNavigationActions androidPageNavigationActions;
    private final MediaInteraction mediaInteraction;

    public AlbumPageAndroid(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.elementChecks = new ElementChecks(driver, wait);
        this.androidPageNavigationActions = new AndroidPageNavigationActions(driver, wait);
        this.mediaInteraction = new MediaInteraction(driver, wait);
    }

    public AlbumPageAndroid verifyAlbumTitleHasText(String albumTitle) {
        elementChecks.assertElementHasExactText(getTitle(), albumTitle);
        return this;
    }

    public AlbumPageAndroid verifyArtistNamesRowContainsArtist(String artistName) {
        elementChecks.assertElementContainsText(getCreatorNamesRow(), artistName);
        return this;
    }

    public AlbumPageAndroid verifyAlbumInfoHasText(String albumInfo) {
        elementChecks.assertElementHasExactText(getMetaData(), albumInfo);
        return this;
    }

    public AlbumPageAndroid verifyFavouritesButtonIsAvailable() {
        elementChecks.assertElementIsVisible(getHeartButton());
        return this;
    }

    public AlbumPageAndroid verifyDownloadButtonIsAvailable() {
        elementChecks.assertElementIsVisible(getDownloadButton());
        return this;
    }

    public AlbumPageAndroid verifyTrackCloudIsAvailable() {
        elementChecks.assertElementIsVisible(getTrackCloud());
        return this;
    }

    public AlbumPageAndroid verifyAlbumReleaseDateIs(String releaseDate) {
        androidPageNavigationActions.swipeToElementByText("android:id/text1", releaseDate, 10);
        elementChecks.assertElementIsVisible(getReleaseDateRow(releaseDate));
        return this;
    }

    public AlbumPageAndroid verifyAlbumArtistListContainsItem(String artistName) {
        androidPageNavigationActions.swipeToElementByText("android:id/text1", artistName, 10);
        elementChecks.assertElementIsVisible(getListItemByTitle(artistName));
        return this;
    }

    public AlbumPageAndroid verifyYouMightAlsoLikeIsAvailable() {
        androidPageNavigationActions.swipeToElementByText("com.spotify.music:id/section_heading2_title", "You might also like", 10);
        elementChecks.assertElementIsVisible(getYouMightAlsoLikeTitle());
        return this;
    }

    public AlbumPageAndroid verifyCopyRightRowMatches(String copyrightText) {
        androidPageNavigationActions.swipeToElementByText("android:id/text1", copyrightText, 10);
        elementChecks.assertElementIsVisible(getCopyrightRow(copyrightText));
        return this;
    }

    private WebElement getTitle() {
        return driver.findElement(By.id("com.spotify.music:id/title"));
    }

    //ToDo: move findElement pieces into separate methods as utility class
    private WebElement getCreatorNamesRow() {
        return driver.findElement(By.id("com.spotify.music:id/creator_names"));
    }

    private WebElement getMetaData() {
        return driver.findElement(By.id("com.spotify.music:id/metadata"));
    }

    private WebElement getHeartButton() {
        return driver.findElement(By.id("com.spotify.music:id/heart_button"));
    }

    private WebElement getDownloadButton() {
        return driver.findElement(By.id("com.spotify.music:id/download_button"));
    }

    private WebElement getTrackCloud() {
        return driver.findElement(By.id("com.spotify.music:id/track_cloud_content"));
    }

    private WebElement getReleaseDateRow(String releaseDate) {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='" + releaseDate + "']"));
    }

    private WebElement getYouMightAlsoLikeTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='You might also like']"));
    }

    private WebElement getCopyrightRow(String copyrightText) {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='© ℗ 2002 Aftermath Records']"));
    }

    private WebElement getListItemByTitle(String title) {
        System.out.println("Getting item from the list by title");
        String targetResourceId = "android:id/text1";

        androidPageNavigationActions.swipeToElementByText(targetResourceId, title, 10);
        return driver.findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().resourceId(\"%s\").text(\"%s\")",
                        targetResourceId, title)));
    }
}
