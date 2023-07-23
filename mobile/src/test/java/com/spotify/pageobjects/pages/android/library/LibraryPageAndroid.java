package com.spotify.pageobjects.pages.android.library;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.library.LibraryPage;
import com.spotify.utils.navigation.android.AndroidPageNavigationActions;
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
public class LibraryPageAndroid extends AppiumPageAndroid implements LibraryPage {

    public LibraryPageAndroid selectArtistItem(String artistName) {

        if (elementChecksMobile.isElementExists("com.spotify.music:id/subtitle")) {
            getListItemByTitleAndSubtitle(artistName, "Artist").click();
        } else {
            getListItemByTitle(artistName).click();
        }
        return this;
    }

    public LibraryPageAndroid selectAlbumItem(String albumName, String artistName) {

        if (elementChecksMobile.isElementSelected(getAlbumsButton())) {
            getListItemByTitleAndSubtitle(albumName, artistName).click();
        } else {
            getListItemByTitleAndSubtitle(albumName, "Album • " + artistName).click();
        }
        return this;
    }

    public LibraryPageAndroid selectPlaylistItem(String playlistName, String playlistAuthorName) {

        if (elementChecksMobile.isElementSelected(getPlaylistsButton())) {
            getListItemByTitleAndSubtitle(playlistName, playlistAuthorName).click();
        } else {
            getListItemByTitleAndSubtitle(playlistName, "Playlist • " + playlistAuthorName).click();
        }
        return this;
    }

    public LibraryPageAndroid verifyLibraryPageIsOpened() {
        elementChecksMobile.assertElementIsVisible(getLibraryPageTitle());
        return this;
    }

    public LibraryPageAndroid verifyArtistButtonIsSelected() {
        elementChecksMobile.assertElementSelected(getArtistsButton());
        return this;
    }

    public LibraryPageAndroid verifyAlbumsButtonIsSelected() {
        elementChecksMobile.assertElementSelected(getAlbumsButton());
        return this;
    }

    public LibraryPageAndroid tapArtistsButton() {
        getArtistsButton().click();
        return this;
    }

    public LibraryPageAndroid tapAlbumsButton() {
        getAlbumsButton().click();
        return this;
    }

    public LibraryPageAndroid tapPlaylistsButton() {
        getPlaylistsButton().click();
        return this;
    }

    public LibraryPageAndroid tapSortButton() {
        String resourceId = "com.spotify.music:id/sort";

        androidPageNavigationActions.swipeToElementById(resourceId, AndroidPageNavigationActions.Direction.DIRECTION_UP, 10);
        getSortButton().click();

        return this;
    }

    public LibraryPageAndroid tapSearchButton() {
        getSearchButton().click();
        return this;
    }

    public LibraryPageAndroid tapCreatePlaylistButton() {
        getCreatePlaylistButton().click();
        return this;
    }

    public LibraryPageAndroid choosePlaylistOption() {
        getCreatePlaylistMenuPlaylistButton().click();
        return this;
    }

    private WebElement getProfileButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.spotify.music:id/faceheader_image\").description(\"Go to profile and settings\")"));
    }

    private WebElement getLibraryPageTitle() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.spotify.music:id/faceheader_title\").description(\"Your Library Heading\")"));
    }

    private WebElement getPlaylistsButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"Playlists\")"));
    }

    private WebElement getAlbumsButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"Albums\")"));
    }

    private WebElement getArtistsButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"Artists\")"));
    }

    private WebElement getSearchButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/icon_search"));
    }

    private WebElement getCreatePlaylistButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/icon_create"));
    }

    private WebElement getSortButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/sort"));
    }

    private WebElement getChangeLayoutButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/icon_grid_list"));
    }

    private WebElement getCreatePlaylistMenuTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/heading' and @text='Create']"));
    }

    private WebElement getCreatePlaylistMenuPlaylistButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/create_playlist_row"));
    }

    private WebElement getCreatePlaylistMenuBlendButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/title"));
    }

    private WebElement getListItemByTitleAndSubtitle(String title, String subtitle) {
        System.out.println("Getting item from the list by title and subtitle");
        String contentDesc = String.format("%s, %s, ", title, subtitle);

        androidPageNavigationActions.swipeToElementByDescription(contentDesc, 10);
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().description(\"%s\")",
                        contentDesc)));
    }

    private WebElement getListItemByTitle(String title) {
        System.out.println("Getting item from the list by title");
        String targetResourceId = "com.spotify.music:id/title";

        androidPageNavigationActions.swipeToElementByText(targetResourceId, title, 10);
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().resourceId(\"%s\").text(\"%s\")",
                        targetResourceId, title)));
    }
}

//    private final AndroidDriver driver;
//    private final AndroidPageNavigationActions androidPageNavigationActions;
//    private final ElementChecks elementChecks;
//
//    public LibraryPageAndroid(AndroidDriver driver, WebDriverWait wait) {
//        this.driver = driver;
//        this.androidPageNavigationActions = new AndroidPageNavigationActions(driver, wait);
//        this.elementChecks = new ElementChecks(driver, wait);
//    }


//    public LibraryPage tapAddArtistButton() {
//        getListItemByTitle("Add artists").click();
//        return this;
//    }

//    public LibraryPage tapAddPodcastsButton() {
//        getListItemByTitle("Add podcasts & shows").click();
//        return this;
//    }
