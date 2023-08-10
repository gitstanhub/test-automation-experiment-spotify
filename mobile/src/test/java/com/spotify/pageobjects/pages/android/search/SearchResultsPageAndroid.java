package com.spotify.pageobjects.pages.android.search;

import com.spotify.config.ConfigProviderMobile;
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
        androidElementChecks.assertElementIsVisible(getSearchResult(expectedSearchResult));
        return this;
    }

    private WebElement getGlobalSearchField() {
        return androidElementActions.getElementById("com.spotify.music:id/query");
    }

    private WebElement getSearchResultsPlaceholderTitle() {
        return androidElementActions.getElementByXpath("//android.widget.TextView[@resource-id='com.spotify.music:id/text1' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().searchResultsPlaceholderTitleText() + "']");
//        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/text1' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().searchResultsPlaceholderTitleText() + "']"));
    }

    private WebElement getSearchResultsPlaceholderSubtitle() {
        return androidElementActions.getElementByXpath("//android.widget.TextView[@resource-id='com.spotify.music:id/text2' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().searchResultsPlaceholderSubtitleText() + "']");
//        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/text2' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().searchResultsPlaceholderSubtitleText() + "']"));
    }

    private WebElement getTopFilterButton() {
        return androidElementActions.getElementByXpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().topFilterButtonText() + "']");
//        return getDriver().findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().topFilterButtonText() + "']"));
    }

    private WebElement getArtistFilterButton() {
        return androidElementActions.getElementByXpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().artistFilterButtonText() + "']");
//        return getDriver().findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().artistFilterButtonText() + "']"));
    }

    private WebElement getSongsFilterButton() {
        return androidElementActions.getElementByXpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().songsFilterButtonText() + "']");
//        return getDriver().findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().songsFilterButtonText() + "']"));
    }

    private WebElement getAlbumsFilterButton() {
        return androidElementActions.getElementByXpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().albumsFilterButtonText() + "']");
//        return getDriver().findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().albumsFilterButtonText() + "']"));
    }

    private WebElement getPlaylistsFilterButton() {
        return androidElementActions.getElementByXpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().playlistsFilterButtonText() + "']");
//        return getDriver().findElement(By.xpath("//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().playlistsFilterButtonText() + "']"));
    }

    private WebElement getSearchResult(String title) {
        androidPageNavigationActions.swipeToElementByText("com.spotify.music:id/title", title, 10);

        return androidElementActions.getElementByXpath("//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='" + title + "']");

//        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='" + title + "']"));
    }
}
