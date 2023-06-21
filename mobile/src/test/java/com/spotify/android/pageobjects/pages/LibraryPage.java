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

    public LibraryPage clickArtistsButton() {
        getArtistsButton().click();
        elementChecks.assertElementIsSelected(getArtistsButton());
        return this;
    }

    public LibraryPage clickAlbumsButton() {
        getAlbumsButton().click();
        return this;
    }

    public LibraryPage selectArtistItem(String artistName) {

        getListItemByTitle(artistName);

        String desiredXpath = "//android.view.ViewGroup[@resource-id='com.spotify.music:id/row_root' and @content-desc='" + artistName + ", ']";

        driver.findElement(AppiumBy.xpath(desiredXpath)).click();


//        driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"" + artistName + "\")"
//                )).click();

//        if (elementChecks.isElementExistWithResourceId("com.spotify.music:id/subtitle")) {
//            getListItemByTitleAndSubtitle(artistName, "Artist");
//        } else {
//            getListItemByTitle(artistName).click();
//        }
        return this;
    }

    public LibraryPage braaa (String artistName) {
        String desiredXpath = "//android.view.ViewGroup[@resource-id='com.spotify.music:id/row_root' and @content-desc='" + artistName + ", ']";

        driver.findElement(AppiumBy.xpath(desiredXpath)).click();

        return this;
    }

//    public LibraryPage swipeAndSelectArtistItem()


//    public LibraryPage selectArtistItem(String artistName) {
//        getListItemByTitleAndSubtitle(artistName, "Artist").click();
//        return this;
//    }

    public LibraryPage selectAlbumItem(String albumName, String artistName) {
        getListItemByTitleAndSubtitle(albumName, "Album • " + artistName);
        return this;
    }

    public LibraryPage clickAddArtistButton() {
        getListItemByTitle("Add artists");
        return this;
    }

    public LibraryPage clickAddPodcastsButton() {
        getListItemByTitle("Add podcasts & shows");
        return this;
    }

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

    private WebElement getAlbumsButton() {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Albums, show only albums.\")"));
    }

    //ToDo update getters for other buttons the same way
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
        return driver.findElement(By.id("com.spotify.music:id/icon_sort"));
    }

    private WebElement getChangeLayoutButton() {
        return driver.findElement(By.id("com.spotify.music:id/icon_grid_list"));
    }

//    private WebElement getListItemByTitleAndSubtitle(String title, String subtitle) {
//        return driver.findElement(AppiumBy.androidUIAutomator(
//                String.format(
//                        "new UiScrollable(new UiSelector().scrollable(true))"
//                                +".scrollIntoView(new UiSelector().resourceId(\"com.spotify.music:id/recycler_view\")"
//                                + ".childSelector(new UiSelector().resourceId(\"com.spotify.music:id/row_root\")"
//                                + ".childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))"
//                                + ".childSelector(new UiSelector().resourceId(\"com.spotify.music:id/subtitle\").text(\"%s\"))))",
//                        title, subtitle)
//        ));
//    }

//    private WebElement getListItemByTitleAndSubtitle(String title, String subtitle) {
//        By locator = AppiumBy.androidUIAutomator(
//                String.format(
//                        "new UiScrollable(new UiSelector().scrollable(true))"
//                                +".scrollIntoView(new UiSelector().resourceId(\"com.spotify.music:id/recycler_view\")"
//                                + ".childSelector(new UiSelector().resourceId(\"com.spotify.music:id/row_root\")"
//                                + ".childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))"
//                                + ".childSelector(new UiSelector().resourceId(\"com.spotify.music:id/subtitle\").text(\"%s\"))))",
//                        title, subtitle)
//        );
//
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }

//    private WebElement getListItemByTitleAndSubtitle(String title, String subtitle) {
//        System.out.println("Getting item from the list by title and subtitle");
//        String xpath = String.format(
//                        ".//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='%s'] and " +
//                        ".//android.widget.TextView[@resource-id='com.spotify.music:id/subtitle' and @text='%s']]",
//                title, subtitle
//        );
//
//        return wait.until(driver -> {
//            driver.findElement(AppiumBy.androidUIAutomator(
//                    "new UiScrollable(new UiSelector().resourceId(\"com.spotify.music:id/recycler_view\")).scrollForward()"
//            ));
//            return driver.findElement(By.xpath(xpath));
//        });
//    }

//    private WebElement getListItemByTitleAndSubtitle(String title, String subtitle) {
//        System.out.println("Getting item from the list by title and subtitle");
//        String contentDesc = String.format("%s, %s, ", title, subtitle);
//        String xpath = "//*[@content-desc='" + contentDesc + "']";
//
//        return wait.until(driver -> {
//            driver.findElement(AppiumBy.androidUIAutomator(
//                    "new UiScrollable(new UiSelector().resourceId(\"com.spotify.music:id/recycler_view\")).scrollForward()"
//            ));
//            return driver.findElement(By.xpath(xpath));
//        });
//    }

//    private WebElement getListItemByTitleAndSubtitle(String title, String subtitle) {
//        System.out.println("Getting item from the list by title and subtitle");
//        String contentDesc = String.format("%s, %s, ", title, subtitle);
////        String xpath = "//*[@content-desc='" + contentDesc + "']";
//
//        return driver.findElement(AppiumBy.androidUIAutomator(
//                String.format(
//                        "new UiScrollable(new UiSelector().resourceId(\"com.spotify.music:id/recycler_view\"))" +
//                                ".scrollIntoView(new UiSelector().description(\"%s\"))",
//                        contentDesc)));
//    }

    private void getListItemByTitleAndSubtitle(String title, String subtitle) {
        System.out.println("Getting item from the list by title and subtitle");
        String contentDesc = String.format("%s, %s, ", title, subtitle);
//        String xpath = "//*[@content-desc='" + contentDesc + "']";

        pageNavigationActions.scrollToElementWithDescriptionAttribute("com.spotify.music:id/recycler_view", contentDesc);
    }

//    public boolean isSubtitleExist(String subtitle) {
//        return driver.findElements(AppiumBy.androidUIAutomator(
//                String.format(
//                        "new UiSelector().resourceId(\"com.spotify.music:id/row_root\")"
//                                + ".childSelector(new UiSelector().resourceId(\"com.spotify.music:id/subtitle\").text(\"%s\"))",
//                        subtitle)
//        )).size() > 0;
//    }

//    public boolean isSubtitleExist(String subtitle) {
//        System.out.println("Checking if elements with subtitles exist");
//        return driver.findElements(AppiumBy.androidUIAutomator(
//                        "new UiSelector().resourceId(\"com.spotify.music:id/subtitle\")"
//        )).size() > 0;
//    }

//    private boolean isSubtitleExist() {
//        System.out.println("Checking if elements with subtitles exist");
//        try {
//            driver.findElement(AppiumBy.androidUIAutomator(
//                    "new UiSelector().resourceId(\"com.spotify.music:id/subtitle\")"
//            ));
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }

//    private WebElement getListItemByTitle(String title) {
//        return driver.findElement(AppiumBy.androidUIAutomator(
//                String.format(
//                        "new UiScrollable(new UiSelector().scrollable(true))"
//                                + ".scrollIntoView(new UiSelector().resourceId(\"com.spotify.music:id/row_root\")"
//                                + ".childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\")))",
//                        title)
//        ));
//    }

//    private WebElement getListItemByTitle(String title) {
//        return driver.findElement(AppiumBy.androidUIAutomator(
//                String.format(
//                        "new UiSelector().resourceId(\"com.spotify.music:id/row_root\")" +
//                                ".childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))",
//                        title)
//        ));
//    }

//    private WebElement getListItemByTitle(String title) {
//        System.out.println("Getting item from the list by title");
//        return wait.until(driver -> {
//            driver.findElement(AppiumBy.androidUIAutomator(
//                    "new UiScrollable(new UiSelector().resourceId(\"com.spotify.music:id/recycler_view\")).scrollForward()"
//            ));
//            driver.findElement(AppiumBy.androidUIAutomator(
//                    "new UiScrollable(new UiSelector().resourceId(\"com.spotify.music:id/recycler_view\")).scrollBackward()"
//            ));
//            return driver.findElement(AppiumBy.androidUIAutomator(
//                    String.format(
//                            "new UiSelector().resourceId(\"com.spotify.music:id/row_root\")" +
//                                    ".childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))",
//                            title)
//            ));
//        });
//    }

//    private WebElement getListItemByTitle(String title) {
//        System.out.println("Getting item from the list by title");
//        return wait.until(driver -> {
//            driver.findElement(AppiumBy.androidUIAutomator(
//                    String.format(
//                            "new UiScrollable(new UiSelector().resourceId(\"com.spotify.music:id/recycler_view\"))" +
//                                    ".scrollIntoView(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))",
//                            title)
//            ));
//            return driver.findElement(AppiumBy.androidUIAutomator(
//                    String.format(
//                            "new UiSelector().resourceId(\"com.spotify.music:id/row_root\")" +
//                                    ".childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))",
//                            title)
//            ));
//        });
//    }

//    private WebElement getListItemByTitle(String title) {
//        System.out.println("Getting item from the list by title");
//        return driver.findElement(AppiumBy.androidUIAutomator(
//                String.format(
//                        "new UiScrollable(new UiSelector().resourceId(\"com.spotify.music:id/recycler_view\"))" +
//                                ".scrollIntoView(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))",
//                        title)));
//    }

    private void getListItemByTitle(String title) {
        System.out.println("Getting item from the list by title");

//        String desiredXpath = "//android.view.ViewGroup[@resource-id='com.spotify.music:id/row_root' and @content-desc='" + title + ", ']";

        pageNavigationActions.swipeToElementWithInnerText("com.spotify.music:id/title", title, 10);
//        return driver.findElement(AppiumBy.xpath(desiredXpath));

//        return wait.until(
//                driver.findElement(AppiumBy.xpath(desiredXpath));
//        );
    }
}
