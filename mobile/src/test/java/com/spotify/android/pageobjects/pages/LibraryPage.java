package com.spotify.android.pageobjects.pages;

import com.spotify.android.utils.assertions.ElementChecks;
import com.spotify.android.utils.navigation.PageNavigationActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibraryPage {

    private final AndroidDriver driver;
    private final PageNavigationActions pageNavigationActions;
    private final ElementChecks elementChecks;
    private final WebDriverWait wait;

    public LibraryPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.pageNavigationActions = new PageNavigationActions(driver, wait);
        this.elementChecks = new ElementChecks(driver, wait);
    }

    public LibraryPage selectArtistItem(String artistName) {

        if (elementChecks.isElementExistWithResourceId("com.spotify.music:id/subtitle")) {
            getListItemByTitleAndSubtitle(artistName, "Artist").click();
        } else {
            getListItemByTitle(artistName).click();
        }

        return this;
    }

    //    public LibraryPage selectAlbumItem(String albumName, String artistName) {
//        getListItemByTitleAndSubtitle(albumName, "Album • " + artistName);
//        return this;
//    }

    public LibraryPage clickArtistsButton() {
        getArtistsButton().click();
        return this;
    }

    public LibraryPage clickAlbumsButton() {
        getAlbumsButton().click();
        return this;
    }

    public LibraryPage clickSortButton() {
        String resourceId = "com.spotify.music:id/sort";

        pageNavigationActions.swipeToElementWithId(resourceId, PageNavigationActions.Direction.DIRECTION_UP, 10);
        getSortButton().click();

        return this;
    }

    public LibraryPage verifyLibraryPageIsOpened() {
        elementChecks.assertElementIsVisible(getLibraryTitle());
        return this;
    }

    public LibraryPage verifyArtistButtonIsSelected() {
        elementChecks.assertElementIsSelected(getArtistsButton());
        return this;
    }

//    public LibraryPage clickAddArtistButton() {
//        getListItemByTitle("Add artists").click();
//        return this;
//    }

//    public LibraryPage clickAddPodcastsButton() {
//        getListItemByTitle("Add podcasts & shows").click();
//        return this;
//    }

    public LibraryPage clickSearchButton() {
        getSearchButton().click();
        return this;
    }

    public LibraryPage clickCreatePlaylistButton() {
        getCreatePlaylistButton().click();
        return this;
    }

    private WebElement getProfileButton() {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.spotify.music:id/faceheader_image\").description(\"Go to profile and settings\")"));
    }

    private WebElement getLibraryTitle() {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.spotify.music:id/faceheader_title\").description(\"Your Library Heading\")"));
    }

    private WebElement getPlaylistsButton() {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"Playlists\")"));
    }

    private WebElement getAlbumsButton() {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"Albums\")"));
    }

    private WebElement getArtistsButton() {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"Artists\")"));
    }

    private WebElement getSearchButton() {
        return driver.findElement(By.id("com.spotify.music:id/icon_search"));
    }

    private WebElement getCreatePlaylistButton() {
        return driver.findElement(By.id("com.spotify.music:id/icon_create"));
    }

    private WebElement getSortButton() {
        return driver.findElement(By.id("com.spotify.music:id/sort"));
    }

    private WebElement getChangeLayoutButton() {
        return driver.findElement(By.id("com.spotify.music:id/icon_grid_list"));
    }

    private WebElement getListItemByTitleAndSubtitle(String title, String subtitle) {
        System.out.println("Getting item from the list by title and subtitle");
        String contentDesc = String.format("%s, %s, ", title, subtitle);

        pageNavigationActions.swipeToElementWithDescription(contentDesc, 10);
        return driver.findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().description(\"%s\")",
                        contentDesc)));
    }

    private WebElement getListItemByTitle(String title) {
        System.out.println("Getting item from the list by title");
        String targetResourceId = "com.spotify.music:id/title";

        pageNavigationActions.swipeToElementWithText(targetResourceId, title, 10);
        return driver.findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().resourceId(\"%s\").text(\"%s\")",
                        targetResourceId, title)));
    }
}
