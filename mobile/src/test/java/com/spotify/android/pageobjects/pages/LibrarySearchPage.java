package com.spotify.android.pageobjects.pages;

import com.beust.ah.A;
import com.spotify.android.utils.assertions.ElementChecks;
import com.spotify.android.utils.navigation.AndroidDeviceActions;
import com.spotify.android.utils.navigation.PageNavigationActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibrarySearchPage {

    private final AndroidDriver driver;
    private final PageNavigationActions pageNavigationActions;
    private final ElementChecks elementChecks;
    private final AndroidDeviceActions androidDeviceActions;

    public LibrarySearchPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.pageNavigationActions = new PageNavigationActions(driver, wait);
        this.elementChecks = new ElementChecks(driver, wait);
        this.androidDeviceActions = new AndroidDeviceActions(driver);
    }

    public LibrarySearchPage searchLibraryFor(String searchQuery) {
        getLibrarySearchField().sendKeys(searchQuery);
        return this;
    }

    public LibrarySearchPage verifySearchResultIsAvailable(String expectedSearchResult, String searchResultType) {
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

        pageNavigationActions.swipeToElementByDescription(contentDesc, 10);
        return driver.findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().description(\"%s\")",
                        contentDesc)));
    }
}
