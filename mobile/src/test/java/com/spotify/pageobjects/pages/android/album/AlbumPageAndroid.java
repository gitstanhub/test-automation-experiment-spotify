package com.spotify.pageobjects.pages.android.album;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.album.AlbumPage;
import io.appium.java_client.AppiumBy;
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
        elementChecksMobile.assertElementHasExactText(getTitle(), albumTitle);
        return this;
    }

    public AlbumPageAndroid verifyArtistNamesRowContainsArtist(String artistName) {
        elementChecksMobile.assertElementContainsText(getCreatorNamesRow(), artistName);
        return this;
    }

    public AlbumPageAndroid verifyAlbumInfoHasText(String albumInfo) {
        elementChecksMobile.assertElementHasExactText(getMetaData(), albumInfo);
        return this;
    }

    public AlbumPageAndroid verifyFavouritesButtonIsAvailable() {
        elementChecksMobile.assertElementIsVisible(getHeartButton());
        return this;
    }

    public AlbumPageAndroid verifyDownloadButtonIsAvailable() {
        elementChecksMobile.assertElementIsVisible(getDownloadButton());
        return this;
    }

    public AlbumPageAndroid verifyTrackCloudIsAvailable() {
        elementChecksMobile.assertElementIsVisible(getTrackCloud());
        return this;
    }

    public AlbumPageAndroid verifyAlbumReleaseDateIs(String releaseDate) {
        androidPageNavigationActions.swipeToElementByText("android:id/text1", releaseDate, 10);
        elementChecksMobile.assertElementIsVisible(getReleaseDateRow(releaseDate));
        return this;
    }

    public AlbumPageAndroid verifyAlbumArtistListContainsItem(String artistName) {
        androidPageNavigationActions.swipeToElementByText("android:id/text1", artistName, 10);
        elementChecksMobile.assertElementIsVisible(getListItemByTitle(artistName));
        return this;
    }

    public AlbumPageAndroid verifyYouMightAlsoLikeIsAvailable() {
        androidPageNavigationActions.swipeToElementByText("com.spotify.music:id/section_heading2_title", "You might also like", 10);
        elementChecksMobile.assertElementIsVisible(getYouMightAlsoLikeTitle());
        return this;
    }

    public AlbumPageAndroid verifyCopyRightRowMatches(String copyrightText) {
        androidPageNavigationActions.swipeToElementByText("android:id/text1", copyrightText, 10);
        elementChecksMobile.assertElementIsVisible(getCopyrightRow(copyrightText));
        return this;
    }

    private WebElement getTitle() {
        return getDriver().findElement(By.id("com.spotify.music:id/title"));
    }

    //ToDo: move findElement pieces into separate methods as utility class
    private WebElement getCreatorNamesRow() {
        return getDriver().findElement(By.id("com.spotify.music:id/creator_names"));
    }

    private WebElement getMetaData() {
        return getDriver().findElement(By.id("com.spotify.music:id/metadata"));
    }

    private WebElement getHeartButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/heart_button"));
    }

    private WebElement getDownloadButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/download_button"));
    }

    private WebElement getTrackCloud() {
        try {
            return getDriver().findElement(By.id("com.spotify.music:id/track_cloud_content"));
        } catch (NoSuchElementException e) {
            return getDriver().findElement(By.id("com.spotify.music:id/track_cloud"));
        }
    }

    private WebElement getReleaseDateRow(String releaseDate) {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='" + releaseDate + "']"));
    }

    private WebElement getYouMightAlsoLikeTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='You might also like']"));
    }

    private WebElement getCopyrightRow(String copyrightText) {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='© ℗ 2002 Aftermath Records']"));
    }

    private WebElement getListItemByTitle(String title) {
        System.out.println("Getting item from the list by title");
        String targetResourceId = "android:id/text1";

        androidPageNavigationActions.swipeToElementByText(targetResourceId, title, 10);
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().resourceId(\"%s\").text(\"%s\")",
                        targetResourceId, title)));
    }
}
