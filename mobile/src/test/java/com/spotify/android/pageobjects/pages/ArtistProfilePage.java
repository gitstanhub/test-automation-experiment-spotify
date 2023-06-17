package com.spotify.android.pageobjects.pages;

import com.spotify.android.utils.assertions.ElementChecks;
import com.spotify.android.utils.navigation.PageNavigationActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArtistProfilePage {

    private final AndroidDriver driver;
    private final ElementChecks elementChecks;
    private final PageNavigationActions pageNavigationActions;

    public ArtistProfilePage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.elementChecks = new ElementChecks(driver, wait);
        this.pageNavigationActions = new PageNavigationActions(driver, wait);
    }

    public ArtistProfilePage verifyProfileTitleAvailable(String artistName) {
        elementChecks.assertElementHasExactText(getTitle(), artistName);
        return this;
    }

    public ArtistProfilePage verifyMonthlyListenersCountAvailable() {
        elementChecks.assertElementIsVisible(getMetaData());
        return this;
    }

    public ArtistProfilePage verifyFollowButtonAvailable() {
        elementChecks.assertElementIsVisible(getFollowButton());
        return this;
    }

    public ArtistProfilePage verifyContextMenuButtonAvailable() {
        elementChecks.assertElementIsVisible(getContextMenuButton());
        return this;
    }

    public ArtistProfilePage verifyShuffleButtonAvailable() {
        elementChecks.assertElementIsVisible(getShuffleButton());
        return this;
    }

    public ArtistProfilePage verifyPlayButtonAvailable() {
        elementChecks.assertElementIsVisible(getPlayPauseButton());
        return this;
    }

    public ArtistProfilePage verifyTrackCloudContainsArtist(String artistName) {
        elementChecks.assertElementContainsText(getTrackCloud(), artistName);
        return this;
    }

    public ArtistProfilePage verifyPopularReleasesTitleIsAvailable() {
        pageNavigationActions.scrollToElementWithInnerTextTemp("com.spotify.music:id/section_heading2_title", "Artist Playlists");
        elementChecks.assertElementIsVisible(getArtistPlaylistTitle());
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

    private WebElement getContextMenuButton() {
        return driver.findElement(By.id("com.spotify.music:id/context_menu_button"));
    }

    private WebElement getShuffleButton() {
        return driver.findElement(By.id("com.spotify.music:id/shuffle_button"));
    }

    private WebElement getPlayPauseButton() {
        return driver.findElement(By.id("com.spotify.music:id/button_play_and_pause"));
    }

    private WebElement getTrackCloud() {
        return driver.findElement(By.id("com.spotify.music:id/track_cloud_content"));
    }

    private WebElement getArtistPickTitle() {
        return driver.findElement(By.id("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='Artist Pick']"));
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
