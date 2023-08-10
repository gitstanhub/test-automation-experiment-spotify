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
        androidElementChecks.assertElementIsVisible(getContextMenuTitle(expectedTitleText));
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
        return androidElementActions.getElementByXpath("//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='" + titleText + "']");
//        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='" + titleText + "']"));
    }

    private WebElement getContextMenuSubTitle(String subTitleText) {
        return androidElementActions.getElementByXpath("//android.widget.TextView[@resource-id='com.spotify.music:id/subtitle' and @text='" + subTitleText + "']");
//        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/subtitle' and @text='" + subTitleText + "']"));
    }

    private WebElement getListenToMusicAdFreeButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().listenToMusicAdFreeButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().listenToMusicAdFreeButtonText() + "\"))"
//        ));
    }

    private WebElement getFollowButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().followButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().followButtonText() + "\"))"
//        ));
    }

    private WebElement getStopFollowingButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().stopFollowingButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().stopFollowingButtonText() + "\"))"
//        ));
    }

    private WebElement getDoNotPlayThisArtistButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().doNotPlayThisArtistButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().doNotPlayThisArtistButtonText() + "\"))"
//        ));
    }

    private WebElement getShareButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().shareButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().shareButtonText() + "\"))"
//        ));
    }

    private WebElement getShowSpotifyCodeButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().showSpotifyCodeButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().showSpotifyCodeButtonText() + "\"))"
//        ));
    }

    private WebElement getLikeButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().likeButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().likeButtonText() + "\"))"
//        ));
    }

    private WebElement getRemoveLikeButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().removeLikeButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().removeLikeButtonText() + "\"))"
//        ));
    }

    private WebElement getAddToPlaylistButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().addToPlaylistButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().addToPlaylistButtonText() + "\"))"
//        ));
    }

    private WebElement getAddToQueueButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().addToQueueButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().addToQueueButtonText() + "\"))"
//        ));
    }

    private WebElement getDownloadButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().downloadButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().downloadButtonText() + "\"))"
//        ));
    }

    private WebElement getViewArtistButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().viewArtistButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().viewArtistButtonText() + "\"))"
//        ));
    }

    private WebElement getViewAlbumButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().viewAlbumButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().viewAlbumButtonText() + "\"))"
//        ));
    }

    private WebElement getViewArtistsButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().viewArtistsButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().viewArtistsButtonText() + "\"))"
//        ));
    }

    private WebElement getLikeAllSongsButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().likeAllSongsButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().likeAllSongsButtonText() + "\"))"
//        ));
    }

    private WebElement getEditPlaylistButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().editPlaylistButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().editPlaylistButtonText() + "\"))"
//        ));
    }

    private WebElement getDeletePlaylistButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().deletePlaylistButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().deletePlaylistButtonText() + "\"))"
//        ));
    }

    private WebElement getInviteCollaboratorsButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().inviteCollaboratorsButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().inviteCollaboratorsButtonText() + "\"))"
//        ));
    }

    private WebElement getRemoveFromProfileButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().removeFromProfileButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().removeFromProfileButtonText() + "\"))"
//        ));
    }

    private WebElement getMakePrivateButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().makePrivateButtonText() + "\"))"
        );

//        return getDriver().findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().makePrivateButtonText() + "\"))"
//        ));
    }
}
