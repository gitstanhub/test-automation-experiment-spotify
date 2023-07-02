package com.spotify.android.pageobjects.pages;

import com.spotify.android.pageobjects.commons.MediaInteraction;
import com.spotify.android.utils.assertions.ElementChecks;
import com.spotify.android.utils.navigation.PageNavigationActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlbumPage {

    private final AndroidDriver driver;
    private final ElementChecks elementChecks;
    private final PageNavigationActions pageNavigationActions;
    private final MediaInteraction mediaInteraction;

    public AlbumPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.elementChecks = new ElementChecks(driver, wait);
        this.pageNavigationActions = new PageNavigationActions(driver, wait);
        this.mediaInteraction = new MediaInteraction(driver, wait);
    }


    public AlbumPage verifyAlbumTitleHasText(String albumTitle) {
        elementChecks.assertElementHasExactText(getTitle(), albumTitle);
        return this;
    }

    public AlbumPage verifyArtistNamesRowContainsArtist(String artistName) {
        elementChecks.assertElementContainsText(getCreatorNamesRow(), artistName);
        return this;
    }

    public AlbumPage verifyAlbumInfoHasText(String albumInfo) {
        elementChecks.assertElementHasExactText(getMetaData(), albumInfo);
        return this;
    }

    public AlbumPage verifyFavouritesButtonIsAvailable() {
        elementChecks.assertElementIsVisible(getHeartButton());
        return this;
    }

    public AlbumPage verifyDownloadButtonIsAvailable() {
        elementChecks.assertElementIsVisible(getDownloadButton());
        return this;
    }

    public AlbumPage verifyTrackCloudIsAvailable() {
        elementChecks.assertElementIsVisible(getTrackCloud());
        return this;
    }

    public AlbumPage verifyAlbumReleaseDateIs(String releaseDate) {
        pageNavigationActions.swipeToElementByText("android:id/text1", releaseDate, 10);
        elementChecks.assertElementIsVisible(getReleaseDateRow(releaseDate));
        return this;
    }

    public AlbumPage verifyAlbumArtistListContainsItem(String artistName) {
        pageNavigationActions.swipeToElementByText("android:id/text1", artistName, 10);
        elementChecks.assertElementIsVisible(getListItemByTitle(artistName));
        return this;
    }

    public AlbumPage verifyYouMightAlsoLikeIsAvailable() {
        pageNavigationActions.swipeToElementByText("com.spotify.music:id/section_heading2_title", "You might also like", 10);
        elementChecks.assertElementIsVisible(getYouMightAlsoLikeTitle());
        return this;
    }

    public AlbumPage verifyCopyRightRowMatches(String copyrightText) {
        pageNavigationActions.swipeToElementByText("android:id/text1", copyrightText, 10);
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

        pageNavigationActions.swipeToElementByText(targetResourceId, title, 10);
        return driver.findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().resourceId(\"%s\").text(\"%s\")",
                        targetResourceId, title)));
    }
}
