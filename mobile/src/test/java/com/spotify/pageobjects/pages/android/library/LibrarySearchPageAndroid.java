package com.spotify.pageobjects.pages.android.library;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.library.LibrarySearchPage;
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
public class LibrarySearchPageAndroid extends AppiumPageAndroid implements LibrarySearchPage {

    public LibrarySearchPageAndroid searchLibraryFor(String searchQuery) {
        getLibrarySearchField().sendKeys(searchQuery);
        return this;
    }

    public LibrarySearchPageAndroid verifySearchResultIsAvailable(String expectedSearchResult, String searchResultType) {
        elementChecksMobile.assertElementIsVisible(getSearchResult(expectedSearchResult, searchResultType));
        return this;
    }

    private WebElement getLibrarySearchField() {
        return getDriver().findElement(By.id("com.spotify.music:id/edit_text"));
    }

    private WebElement getSearchFieldClearButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/icon_clear_search"));
    }

    private WebElement getEmptyViewTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/search_empty_view_title' and @text='Find your favorites']"));
    }

    private WebElement getEmptyViewSubtitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/search_empty_view_subtitle' and @text='Search everything you've liked, followed, or created.']"));
    }

    private WebElement getSearchResult(String title, String subtitle) {
        String contentDesc = String.format("%s, %s, ", title, subtitle);

        androidPageNavigationActions.swipeToElementByDescription(contentDesc, 10);
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().description(\"%s\")",
                        contentDesc)));
    }
}

//    private final AndroidDriver driver;
//    private final AndroidPageNavigationActions androidPageNavigationActions;
//    private final ElementChecks elementChecks;
//    private final AndroidDeviceActions androidDeviceActions;
//
//    public LibrarySearchPageAndroid(AndroidDriver driver, WebDriverWait wait) {
//        this.driver = driver;
//        this.androidPageNavigationActions = new AndroidPageNavigationActions(driver, wait);
//        this.elementChecks = new ElementChecks(driver, wait);
//        this.androidDeviceActions = new AndroidDeviceActions(driver);
//    }
