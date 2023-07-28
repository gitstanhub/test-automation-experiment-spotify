package com.spotify.pageobjects.commons.android.contextmenu;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.commons.interfaces.contextmenu.ContextMenu;
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
public class ContextMenuAndroid extends AppiumPageAndroid implements ContextMenu {

    public ContextMenuAndroid verifyContextMenuTitleIsAvailable(String expectedTitleText) {
        elementChecksMobile.assertElementIsVisible(getContextMenuTitle(expectedTitleText));
        return this;
    }

    public ContextMenuAndroid tapShowSpotifyCodeButton() {
        getShowSpotifyCodeButton().click();
        return this;
    }

    public ContextMenuAndroid tapDeletePlaylistButton() {
        getDeletePlaylistButton().click();
        return this;
    }

    private WebElement getContextMenuTitle(String titleText) {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='" + titleText + "']"));
    }

    private WebElement getContextMenuSubTitle(String subTitleText) {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/subtitle' and @text='" + subTitleText + "']"));
    }

    private WebElement getListenToMusicAdFreeButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Listen to music ad-free\"))"
        ));
    }

    private WebElement getFollowButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Follow\"))"
        ));
    }

    private WebElement getStopFollowingButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Stop Following\"))"
        ));
    }

    private WebElement getDoNotPlayThisArtistButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Don't play this artist\"))"
        ));
    }

    private WebElement getShareButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Share\"))"
        ));
    }

    private WebElement getShowSpotifyCodeButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Show Spotify Code\"))"
        ));
    }

    private WebElement getLikeButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Like\"))"
        ));
    }

    private WebElement getRemoveLikeButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Liked\"))"
        ));
    }

    private WebElement getAddToPlaylistButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Add to playlist\"))"
        ));
    }

    private WebElement getAddToQueueButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Add to queue\"))"
        ));
    }

    private WebElement getDownloadButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Download\"))"
        ));
    }

    private WebElement getViewArtistButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"View artist\"))"
        ));
    }

    private WebElement getViewAlbumButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"View album\"))"
        ));
    }

    private WebElement getViewArtistsButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"View artists\"))"
        ));
    }

    private WebElement getLikeAllSongsButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Like all songs\"))"
        ));
    }

    private WebElement getEditPlaylistButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Edit playlist\"))"
        ));
    }

    private WebElement getDeletePlaylistButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Delete Playlist\"))"
        ));
    }

    private WebElement getInviteCollaboratorsButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Delete Playlist\"))"
        ));
    }

    private WebElement getRemoveFromProfileButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Remove from profile\"))"
        ));
    }

    private WebElement getMakePrivateButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"Make private\"))"
        ));
    }
}
