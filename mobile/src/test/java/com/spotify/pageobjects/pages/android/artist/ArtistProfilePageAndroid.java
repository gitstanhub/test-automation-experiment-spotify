package com.spotify.pageobjects.pages.android.artist;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.artist.ArtistProfilePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
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
        androidPageNavigationActions.swipeToElementByText("com.spotify.music:id/section_heading2_title", "Popular releases", 10);
        elementChecksMobile.assertElementIsVisible(getPopularReleasesTitle());
        return this;
    }

    public ArtistProfilePageAndroid verifyArtistPlaylistsSectionIsAvailable() {
        androidPageNavigationActions.swipeToElementByText("com.spotify.music:id/section_heading2_title", "Artist Playlists", 10);
        elementChecksMobile.assertElementIsVisible(getArtistPlaylistTitle());
        return this;
    }

    public ArtistProfilePageAndroid verifyFansAlsoLikeSectionIsAvailable() {
        androidPageNavigationActions.swipeToElementByText("com.spotify.music:id/section_heading2_title", "Fans also like", 10);
        elementChecksMobile.assertElementIsVisible(getFansAlsoLikeTitle());
        return this;
    }

    public ArtistProfilePageAndroid tapSeeDiscographyButton() {
        androidPageNavigationActions.swipeToElementByText("See all events", 10);
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
        return getDriver().findElement(By.id("com.spotify.music:id/track_cloud_content"));
    }

    private WebElement getArtistPickTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='Artist Pick']"));
    }

    private WebElement getPopularReleasesTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='Popular releases']"));
    }

    private WebElement getSeeDiscographyButton() {
        return getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'See discography')]"));
    }

    private WebElement getFeaturingArtistTitle(String artistName) {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='Featuring " + artistName + "']"));
    }

    private WebElement getLiveEventsTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='Live Events']"));
    }

    private WebElement getMerchTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='Merch']"));
    }

    private WebElement getAboutTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='About']"));
    }

    private WebElement getArtistPlaylistTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='Artist Playlists']"));
    }

    private WebElement getFansAlsoLikeTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/section_heading2_title' and @text='Fans also like']"));
    }

    private WebElement getArtistBiography() {
        return getDriver().findElement(By.id("com.spotify.music:id/biography"));
    }
}

//    private final AndroidDriver driver;
//    private final ElementChecks elementChecks;
//    private final AndroidPageNavigationActions androidPageNavigationActions;
//
//    public ArtistProfilePageAndroid(AndroidDriver driver, WebDriverWait wait) {
//        this.driver = driver;
//        this.elementChecks = new ElementChecks(driver, wait);
//        this.androidPageNavigationActions = new AndroidPageNavigationActions(driver, wait);
//    }
