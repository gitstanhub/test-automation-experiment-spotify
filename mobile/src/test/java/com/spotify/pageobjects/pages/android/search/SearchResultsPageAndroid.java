package com.spotify.pageobjects.pages.android.search;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.search.SearchResultsPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getDriver;

@Component
@Lazy
@Slf4j
public class SearchResultsPageAndroid extends AppiumPageAndroid implements SearchResultsPage {

    public SearchResultsPageAndroid searchGloballyFor(String searchQuery) {
        getGlobalSearchField().sendKeys(searchQuery);
        return this;
    }

    public SearchResultsPageAndroid tapArtistsFilterButton() {
        getArtistFilterButton().click();
        return this;
    }

    public SearchResultsPageAndroid tapAlbumFilterButton() {
        getAlbumsFilterButton().click();
        return this;
    }

    public SearchResultsPageAndroid verifySearchResultIsAvailable(String expectedSearchResult) {
        elementChecksMobile.assertElementIsVisible(getSearchResult(expectedSearchResult));
        return this;
    }

    private WebElement getGlobalSearchField() {
        return getDriver().findElement(By.id("com.spotify.music:id/query"));
    }

    private WebElement getSearchResultsPlaceholderTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/text1' and @text='Play what you love']"));
    }

    private WebElement getSearchResultsPlaceholderSubtitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/text2' and @text='Search for artists, songs, podcasts, and more.']"));
    }

    private WebElement getTopFilterButton() {
        return getDriver().findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='Top']"));
    }

    private WebElement getArtistFilterButton() {
        return getDriver().findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='Artists']"));
    }

    private WebElement getSongsFilterButton() {
        return getDriver().findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='Songs']"));
    }

    private WebElement getAlbumsFilterButton() {
        return getDriver().findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='Albums']"));
    }

    private WebElement getPlaylistsFilterButton() {
        return getDriver().findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='Playlists']"));
    }

    private WebElement getSearchResult(String title) {
        androidPageNavigationActions.swipeToElementByText("com.spotify.music:id/title", title, 10);
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='" + title + "']"));
    }
}
