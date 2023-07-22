package com.spotify.pageobjects.pages.android.library;

import com.spotify.pageobjects.pages.interfaces.library.LibrarySearchPage;
import com.spotify.utils.assertions.ElementChecks;
import com.spotify.utils.navigation.android.AndroidDeviceActions;
import com.spotify.utils.navigation.android.AndroidPageNavigationActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibrarySearchPageAndroid implements LibrarySearchPage {

    private final AndroidDriver driver;
    private final AndroidPageNavigationActions androidPageNavigationActions;
    private final ElementChecks elementChecks;
    private final AndroidDeviceActions androidDeviceActions;

    public LibrarySearchPageAndroid(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.androidPageNavigationActions = new AndroidPageNavigationActions(driver, wait);
        this.elementChecks = new ElementChecks(driver, wait);
        this.androidDeviceActions = new AndroidDeviceActions(driver);
    }

    public LibrarySearchPageAndroid searchLibraryFor(String searchQuery) {
        getLibrarySearchField().sendKeys(searchQuery);
        return this;
    }

    public LibrarySearchPageAndroid verifySearchResultIsAvailable(String expectedSearchResult, String searchResultType) {
        elementChecks.assertElementIsVisible(getSearchResult(expectedSearchResult, searchResultType));
        return this;
    }

    private WebElement getLibrarySearchField() {
        return driver.findElement(By.id("com.spotify.music:id/edit_text"));
    }

    private WebElement getSearchFieldClearButton() {
        return driver.findElement(By.id("com.spotify.music:id/icon_clear_search"));
    }

    private WebElement getEmptyViewTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/search_empty_view_title' and @text='Find your favorites']"));
    }

    private WebElement getEmptyViewSubtitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/search_empty_view_subtitle' and @text='Search everything you've liked, followed, or created.']"));
    }

    private WebElement getSearchResult(String title, String subtitle) {
        String contentDesc = String.format("%s, %s, ", title, subtitle);

        androidPageNavigationActions.swipeToElementByDescription(contentDesc, 10);
        return driver.findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().description(\"%s\")",
                        contentDesc)));
    }
}
