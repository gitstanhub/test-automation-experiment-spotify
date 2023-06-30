package com.spotify.android.pageobjects.pages;

import com.spotify.android.utils.assertions.ElementChecks;
import com.spotify.android.utils.navigation.PageNavigationActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

    private final AndroidDriver driver;
    private final PageNavigationActions pageNavigationActions;
    private final ElementChecks elementChecks;

    public SearchResultsPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.pageNavigationActions = new PageNavigationActions(driver, wait);
        this.elementChecks = new ElementChecks(driver, wait);
    }

    public SearchResultsPage searchGloballyFor(String searchQuery) {
        getGlobalSearchField().sendKeys(searchQuery);
        return this;
    }

    public SearchResultsPage tapArtistsFilterButton() {
        getArtistFilterButton().click();
        return this;
    }

    public SearchResultsPage verifySearchResultIsAvailable(String expectedSearchResult) {
        elementChecks.assertElementIsVisible(getSearchResult(expectedSearchResult));
        return this;
    }

    private WebElement getGlobalSearchField() {
        return driver.findElement(By.id("com.spotify.music:id/query"));
    }

    private WebElement getSearchResultsPlaceholderTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/text1' and @text='Play what you love']"));
    }

    private WebElement getSearchResultsPlaceholderSubtitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/text2' and @text='Search for artists, songs, podcasts, and more.']"));
    }

    private WebElement getTopFilterButton() {
        return driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='Top']"));
    }

    private WebElement getArtistFilterButton() {
        return driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='Artists']"));
    }

    private WebElement getSongsFilterButton() {
        return driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='Songs']"));
    }

    private WebElement getAlbumsFilterButton() {
        return driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='Albums']"));
    }

    private WebElement getPlaylistsFilterButton() {
        return driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='Playlists']"));
    }

    private WebElement getSearchResult(String title) {
        pageNavigationActions.swipeToElementByText("com.spotify.music:id/title", title, 10);
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='" + title + "']"));
    }
}
