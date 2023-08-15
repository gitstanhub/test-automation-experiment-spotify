package com.spotify.pageobjects.commons.android.contextmenu;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.commons.interfaces.contextmenu.ContextMenu;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.locators.commons.ContextMenuLocators.*;

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
        return androidElementActions.getElementByXpath(String.format(CONTEXT_MENU_TITLE, titleText));
    }

    private WebElement getContextMenuSubTitle(String subTitleText) {
        return androidElementActions.getElementByXpath(String.format(CONTEXT_MENU_SUBTITLE, subTitleText));
    }

    private WebElement getListenToMusicAdFreeButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(LISTEN_TO_MUSIC_AD_FREE_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().listenToMusicAdFreeButtonText())
        );
    }

    private WebElement getFollowButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(FOLLOW_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().followButtonText())
        );
    }

    private WebElement getStopFollowingButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(STOP_FOLLOWING_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().stopFollowingButtonText())
        );
    }

    private WebElement getDoNotPlayThisArtistButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(DO_NOT_PLAY_THIS_ARTIST_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().doNotPlayThisArtistButtonText())
        );
    }

    private WebElement getShareButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(SHARE_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().shareButtonText())
        );
    }

    private WebElement getShowSpotifyCodeButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(SHOW_SPOTIFY_CODE_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().showSpotifyCodeButtonText())
        );
    }

    private WebElement getLikeButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(LIKE_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().likeButtonText())
        );
    }

    private WebElement getRemoveLikeButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(REMOVE_LIKE_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().removeLikeButtonText())
        );
    }

    private WebElement getAddToPlaylistButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(ADD_TO_PLAYLIST_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().addToPlaylistButtonText())
        );
    }

    private WebElement getAddToQueueButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(ADD_TO_QUEUE_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().addToQueueButtonText())
        );
    }

    private WebElement getDownloadButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(DOWNLOAD_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().downloadButtonText())
        );
    }

    private WebElement getViewArtistButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(VIEW_ARTIST_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().viewArtistButtonText())
        );
    }

    private WebElement getViewAlbumButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(VIEW_ALBUM_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().viewAlbumButtonText())
        );
    }

    private WebElement getViewArtistsButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(VIEW_ARTISTS_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().viewArtistsButtonText())
        );
    }

    private WebElement getLikeAllSongsButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(LIKE_ALL_SONGS_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().likeAllSongsButtonText())
        );
    }

    private WebElement getEditPlaylistButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(EDIT_PLAYLIST_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().editPlaylistButtonText())
        );
    }

    private WebElement getDeletePlaylistButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(DELETE_PLAYLIST_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().deletePlaylistButtonText())
        );
    }

    private WebElement getInviteCollaboratorsButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(INVITE_COLLABORATORS_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().inviteCollaboratorsButtonText())
        );
    }

    private WebElement getRemoveFromProfileButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(REMOVE_FROM_PROFILE_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().removeFromProfileButtonText())
        );
    }

    private WebElement getMakePrivateButton() {
        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(MAKE_PRIVATE_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().makePrivateButtonText())
        );
    }
}
