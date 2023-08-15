package com.spotify.pageobjects.pages.android.artist;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.artist.ArtistProfilePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.locators.pages.ArtistProfilePageLocators.*;

@Component
@Lazy
@Slf4j
public class ArtistProfilePageAndroid extends AppiumPageAndroid implements ArtistProfilePage {

    public ArtistProfilePageAndroid verifyProfileTitleHasText(String artistName) {
        androidElementChecks.assertElementHasExactText(getTitle(), artistName);
        return this;
    }

    public ArtistProfilePageAndroid verifyFollowButtonIsAvailable() {
        androidElementChecks.assertElementIsVisible(getFollowButton());
        return this;
    }

    public ArtistProfilePageAndroid verifyMonthlyListenersCountIsAvailable() {
        androidElementChecks.assertElementIsVisible(getMetaData());
        return this;
    }

    public ArtistProfilePageAndroid verifyTrackCloudContainsArtist(String artistName) {
        androidElementChecks.assertElementContainsText(getTrackCloud(), artistName);
        return this;
    }

    public ArtistProfilePageAndroid verifyPopularReleasesSectionIsAvailable() {
        androidPageNavigationActions.swipeToElementByText(POPULAR_RELEASES_SECTION_ID, ConfigProviderMobile.getMobileAppLocaleConfig().popularReleasesTitleText(), 10);
        androidElementChecks.assertElementIsVisible(getPopularReleasesTitle());
        return this;
    }

    public ArtistProfilePageAndroid verifyArtistPlaylistsSectionIsAvailable() {
        androidPageNavigationActions.swipeToElementByText(ARTIST_PLAYLISTS_SECTION_ID, ConfigProviderMobile.getMobileAppLocaleConfig().artistPlaylistsTitleText(), 10);
        androidElementChecks.assertElementIsVisible(getArtistPlaylistTitle());
        return this;
    }

    public ArtistProfilePageAndroid verifyFansAlsoLikeSectionIsAvailable() {
        androidPageNavigationActions.swipeToElementByText(FANS_ALSO_LIKE_SECTION_ID, ConfigProviderMobile.getMobileAppLocaleConfig().fansAlsoLikeSectionText(), 10);
        androidElementChecks.assertElementIsVisible(getFansAlsoLikeTitle());
        return this;
    }

    public ArtistProfilePageAndroid tapSeeDiscographyButton() {
        androidPageNavigationActions.swipeToElementByText(ConfigProviderMobile.getMobileAppLocaleConfig().seeDiscographyButtonText(), 10);
        getSeeDiscographyButton().click();
        return this;
    }

    private WebElement getTitle() {
        return androidElementActions.getElementById(TITLE);
    }

    private WebElement getMetaData() {
        return androidElementActions.getElementById(META_DATA);
    }

    private WebElement getFollowButton() {
        return androidElementActions.getElementById(FOLLOW_BUTTON);
    }

    private WebElement getTrackCloud() {
        try {
            return androidElementActions.getElementById(TRACK_CLOUD_ID_FIRST);
        } catch (NoSuchElementException e) {
            return androidElementActions.getElementById(TRACK_CLOUD_ID_SECOND);
        }
    }

    private WebElement getArtistPickTitle() {
        return androidElementActions.getElementByXpath(String.format(ARTIST_PICK_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().artistPickTitleText()));
    }

    private WebElement getPopularReleasesTitle() {
        return androidElementActions.getElementByXpath(String.format(POPULAR_RELEASE_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().popularReleasesTitleText()));
    }

    private WebElement getSeeDiscographyButton() {
        return androidElementActions.getElementByXpath(String.format(SEE_DISCOGRAPHY_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().seeDiscographyButtonText()));
    }

    private WebElement getFeaturingArtistTitle(String artistName) {
        return androidElementActions.getElementByXpath(String.format(FEATURING_ARTIST_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().featuringArtistTitleText(), artistName));
    }

    private WebElement getLiveEventsTitle() {
        return androidElementActions.getElementByXpath(String.format(LIVE_EVENTS_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().liveEventsTitleText()));
    }

    private WebElement getMerchTitle() {
        return androidElementActions.getElementByXpath(String.format(MERCH_TILE, ConfigProviderMobile.getMobileAppLocaleConfig().merchTitleText()));
    }

    private WebElement getAboutTitle() {
        return androidElementActions.getElementByXpath(String.format(ABOUT_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().aboutTitleText()));
    }

    private WebElement getArtistPlaylistTitle() {
        return androidElementActions.getElementByXpath(String.format(ARTIST_PLAYLIST_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().artistPlaylistsTitleText()));
    }

    private WebElement getFansAlsoLikeTitle() {
        return androidElementActions.getElementByXpath(String.format(FANS_ALSO_LIKE_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().fansAlsoLikeTitleText()));
    }

    private WebElement getArtistBiography() {
        return androidElementActions.getElementById(ARTIST_BIOGRAPHY);
    }
}
