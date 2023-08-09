package com.spotify.pageobjects.pages.android.artist;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.artist.ArtistProfilePage;
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
public class ArtistProfilePageAndroid extends AppiumPageAndroid implements ArtistProfilePage {

    public ArtistProfilePageAndroid verifyProfileTitleHasText(String artistName) {
        elementChecksMobile.assertElementHasExactText(getTitle(), artistName);
        return this;
    }

    public ArtistProfilePageAndroid verifyFollowButtonIsAvailable() {
        elementChecksMobile.assertElementIsVisible(getFollowButton());
        return this;
    }

    public ArtistProfilePageAndroid verifyMonthlyListenersCountIsAvailable() {
        elementChecksMobile.assertElementIsVisible(getMetaData());
        return this;
    }

    public ArtistProfilePageAndroid verifyTrackCloudContainsArtist(String artistName) {
        elementChecksMobile.assertElementContainsText(getTrackCloud(), artistName);
        return this;
    }

    public ArtistProfilePageAndroid verifyPopularReleasesSectionIsAvailable() {
        androidPageNavigationActions.swipeToElementByText("com.spotify.music:id/title", ConfigProviderMobile.getMobileAppLocaleConfig().popularReleasesTitleText(), 10);
        elementChecksMobile.assertElementIsVisible(getPopularReleasesTitle());
        return this;
    }

    public ArtistProfilePageAndroid verifyArtistPlaylistsSectionIsAvailable() {
        androidPageNavigationActions.swipeToElementByText("com.spotify.music:id/section_heading2_title", ConfigProviderMobile.getMobileAppLocaleConfig().artistPlaylistsTitleText(), 10);
        elementChecksMobile.assertElementIsVisible(getArtistPlaylistTitle());
        return this;
    }

    public ArtistProfilePageAndroid verifyFansAlsoLikeSectionIsAvailable() {
        androidPageNavigationActions.swipeToElementByText("com.spotify.music:id/section_heading2_title", ConfigProviderMobile.getMobileAppLocaleConfig().fansAlsoLikeSectionText(), 10);
        elementChecksMobile.assertElementIsVisible(getFansAlsoLikeTitle());
        return this;
    }

    public ArtistProfilePageAndroid tapSeeDiscographyButton() {
        androidPageNavigationActions.swipeToElementByText(ConfigProviderMobile.getMobileAppLocaleConfig().seeDiscographyButtonText(), 10);
        getSeeDiscographyButton().click();
        return this;
    }

    private WebElement getTitle() {
        return getDriver().findElement(By.id("com.spotify.music:id/title"));
    }

    private WebElement getMetaData() {
        return getDriver().findElement(By.id("com.spotify.music:id/metadata"));
    }

    private WebElement getFollowButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/follow_button"));
    }

    private WebElement getTrackCloud() {
        try {
            return getDriver().findElement(By.id("com.spotify.music:id/track_cloud_content"));
        } catch (NoSuchElementException e) {
            return getDriver().findElement(By.id("com.spotify.music:id/track_cloud"));
        }
    }

    private WebElement getArtistPickTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().artistPickTitleText() + "']"));
    }

    private WebElement getPopularReleasesTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().popularReleasesTitleText() + "']"));
    }

    private WebElement getSeeDiscographyButton() {
        return getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'" + ConfigProviderMobile.getMobileAppLocaleConfig().seeDiscographyButtonText() + "')]"));
    }

    private WebElement getFeaturingArtistTitle(String artistName) {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().featuringArtistTitleText() + " " + artistName + "']"));
    }

    private WebElement getLiveEventsTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().liveEventsTitleText() + "']"));
    }

    private WebElement getMerchTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().merchTitleText() + "']"));
    }

    private WebElement getAboutTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().aboutTitleText() + "']"));
    }

    private WebElement getArtistPlaylistTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().artistPlaylistsTitleText() + "']"));
    }

    private WebElement getFansAlsoLikeTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().fansAlsoLikeTitleText() + "']"));
    }

    private WebElement getArtistBiography() {
        return getDriver().findElement(By.id("com.spotify.music:id/biography"));
    }
}
