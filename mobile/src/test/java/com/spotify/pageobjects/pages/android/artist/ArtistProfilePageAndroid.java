package com.spotify.pageobjects.pages.android.artist;

import com.spotify.pageobjects.pages.interfaces.artist.ArtistProfilePage;
import com.spotify.utils.assertions.ElementChecks;
import com.spotify.utils.navigation.android.AndroidPageNavigationActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArtistProfilePageAndroid implements ArtistProfilePage {

    private final AndroidDriver driver;
    private final ElementChecks elementChecks;
    private final AndroidPageNavigationActions androidPageNavigationActions;

    public ArtistProfilePageAndroid(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.elementChecks = new ElementChecks(driver, wait);
        this.androidPageNavigationActions = new AndroidPageNavigationActions(driver, wait);
    }

    public ArtistProfilePageAndroid verifyProfileTitleHasText(String artistName) {
        elementChecks.assertElementHasExactText(getTitle(), artistName);
        return this;
    }

    public ArtistProfilePageAndroid verifyFollowButtonIsAvailable() {
        elementChecks.assertElementIsVisible(getFollowButton());
        return this;
    }

    public ArtistProfilePageAndroid verifyMonthlyListenersCountIsAvailable() {
        elementChecks.assertElementIsVisible(getMetaData());
        return this;
    }

    public ArtistProfilePageAndroid verifyTrackCloudContainsArtist(String artistName) {
        elementChecks.assertElementContainsText(getTrackCloud(), artistName);
        return this;
    }

    public ArtistProfilePageAndroid verifyPopularReleasesSectionIsAvailable() {
        androidPageNavigationActions.swipeToElementByText("com.spotify.music:id/section_heading2_title", "Popular releases", 10);
        elementChecks.assertElementIsVisible(getPopularReleasesTitle());
        return this;
    }

    public ArtistProfilePageAndroid verifyArtistPlaylistsSectionIsAvailable() {
        androidPageNavigationActions.swipeToElementByText("com.spotify.music:id/section_heading2_title", "Artist Playlists", 10);
        elementChecks.assertElementIsVisible(getArtistPlaylistTitle());
        return this;
    }

    public ArtistProfilePageAndroid verifyFansAlsoLikeSectionIsAvailable() {
        androidPageNavigationActions.swipeToElementByText("com.spotify.music:id/section_heading2_title", "Fans also like", 10);
        elementChecks.assertElementIsVisible(getFansAlsoLikeTitle());
        return this;
    }

    public ArtistProfilePageAndroid tapSeeDiscographyButton() {
        androidPageNavigationActions.swipeToElementByText("See all events", 10);
        getSeeDiscographyButton().click();
        return this;
    }

    private WebElement getTitle() {
        return driver.findElement(By.id("com.spotify.music:id/title"));
    }

    private WebElement getMetaData() {
        return driver.findElement(By.id("com.spotify.music:id/metadata"));
    }

    private WebElement getFollowButton() {
        return driver.findElement(By.id("com.spotify.music:id/follow_button"));
    }

    private WebElement getTrackCloud() {
        return driver.findElement(By.id("com.spotify.music:id/track_cloud_content"));
    }

    private WebElement getArtistPickTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='Artist Pick']"));
    }

    private WebElement getPopularReleasesTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='Popular releases']"));
    }

    private WebElement getSeeDiscographyButton() {
        return driver.findElement(By.xpath("//android.widget.Button[contains(@text,'See discography')]"));
    }

    private WebElement getFeaturingArtistTitle(String artistName) {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='Featuring " + artistName + "']"));
    }

    private WebElement getLiveEventsTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='Live Events']"));
    }

    private WebElement getMerchTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='Merch']"));
    }

    private WebElement getAboutTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='About']"));
    }

    private WebElement getArtistPlaylistTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='Artist Playlists']"));
    }

    private WebElement getFansAlsoLikeTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='Fans also like']"));
    }

    private WebElement getArtistBiography() {
        return driver.findElement(By.id("com.spotify.music:id/biography"));
    }
}
