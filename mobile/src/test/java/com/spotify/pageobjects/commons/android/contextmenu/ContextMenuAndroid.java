package com.spotify.pageobjects.commons.android.contextmenu;

import com.spotify.config.ConfigProviderMobile;
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
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().listenToMusicAdFreeButtonText() + "\"))"
        ));
    }

    private WebElement getFollowButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().followButtonText() + "\"))"
        ));
    }

    private WebElement getStopFollowingButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().stopFollowingButtonText() + "\"))"
        ));
    }

    private WebElement getDoNotPlayThisArtistButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().doNotPlayThisArtistButtonText() + "\"))"
        ));
    }

    private WebElement getShareButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().shareButtonText() + "\"))"
        ));
    }

    private WebElement getShowSpotifyCodeButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().showSpotifyCodeButtonText() + "\"))"
        ));
    }

    private WebElement getLikeButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().likeButtonText() + "\"))"
        ));
    }

    private WebElement getRemoveLikeButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().removeLikeButtonText() + "\"))"
        ));
    }

    private WebElement getAddToPlaylistButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().addToPlaylistButtonText() + "\"))"
        ));
    }

    private WebElement getAddToQueueButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().addToQueueButtonText() + "\"))"
        ));
    }

    private WebElement getDownloadButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().downloadButtonText() + "\"))"
        ));
    }

    private WebElement getViewArtistButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().viewArtistButtonText() + "\"))"
        ));
    }

    private WebElement getViewAlbumButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().viewAlbumButtonText() + "\"))"
        ));
    }

    private WebElement getViewArtistsButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().viewArtistsButtonText() + "\"))"
        ));
    }

    private WebElement getLikeAllSongsButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().likeAllSongsButtonText() + "\"))"
        ));
    }

    private WebElement getEditPlaylistButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().editPlaylistButtonText() + "\"))"
        ));
    }

    private WebElement getDeletePlaylistButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().deletePlaylistButtonText() + "\"))"
        ));
    }

    private WebElement getInviteCollaboratorsButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().inviteCollaboratorsButtonText() + "\"))"
        ));
    }

    private WebElement getRemoveFromProfileButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().removeFromProfileButtonText() + "\"))"
        ));
    }

    private WebElement getMakePrivateButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().makePrivateButtonText() + "\"))"
        ));
    }
}
