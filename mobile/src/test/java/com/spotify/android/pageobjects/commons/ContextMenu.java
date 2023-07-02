package com.spotify.android.pageobjects.commons;

import com.spotify.android.utils.assertions.ElementChecks;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContextMenu {

    private final AndroidDriver driver;
    private final ElementChecks elementChecks;

    public ContextMenu(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.elementChecks = new ElementChecks(driver, wait);
    }

    public ContextMenu verifyContextMenuTitleIsAvailable(String expectedTitleText) {
        elementChecks.assertElementIsVisible(getContextMenuTitle(expectedTitleText));
        return this;
    }

    public ContextMenu tapShowSpotifyCodeButton() {
        getShowSpotifyCodeButton().click();
        return this;
    }

    public ContextMenu tapDeletePlaylistButton() {
        getDeletePlaylistButton().click();
        return this;
    }

    private WebElement getContextMenuTitle(String titleText) {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='" + titleText + "']"));
    }

    private WebElement getContextMenuSubTitle(String subTitleText) {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/subtitle' and @text='" + subTitleText + "']"));
    }

    private WebElement getListenToMusicAdFreeButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Listen to music ad-free\"))"
        ));
    }

    private WebElement getFollowButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Follow\"))"
        ));
    }

    private WebElement getStopFollowingButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Stop Following\"))"
        ));
    }

    private WebElement getDoNotPlayThisArtistButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Don't play this artist\"))"
        ));
    }

    private WebElement getShareButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Share\"))"
        ));
    }

    private WebElement getShowSpotifyCodeButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Show Spotify Code\"))"
        ));
    }

    private WebElement getLikeButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Like\"))"
        ));
    }

    private WebElement getRemoveLikeButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Liked\"))"
        ));
    }

    private WebElement getAddToPlaylistButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Add to playlist\"))"
        ));
    }

    private WebElement getAddToQueueButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Add to queue\"))"
        ));
    }

    private WebElement getDownloadButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Download\"))"
        ));
    }

    private WebElement getViewArtistButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"View artist\"))"
        ));
    }

    private WebElement getViewAlbumButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"View album\"))"
        ));
    }

    private WebElement getViewArtistsButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"View artists\"))"
        ));
    }

    private WebElement getLikeAllSongsButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Like all songs\"))"
        ));
    }

    private WebElement getEditPlaylistButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Edit playlist\"))"
        ));
    }

    private WebElement getDeletePlaylistButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Delete Playlist\"))"
        ));
    }

    private WebElement getInviteCollaboratorsButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Delete Playlist\"))"
        ));
    }

    private WebElement getRemoveFromProfileButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Remove from profile\"))"
        ));
    }

    private WebElement getMakePrivateButton() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Make private\"))"
        ));
    }
}
