package com.spotify.pageobjects.pages.android.artist;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.artist.ArtistDiscographyPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.locators.pages.ArtistDiscographyPageLocators.*;

@Component
@Lazy
@Slf4j
public class ArtistDiscographyPageAndroid extends AppiumPageAndroid implements ArtistDiscographyPage {

    public ArtistDiscographyPageAndroid verifyDiscographyTitleIsAvailable() {
        androidElementChecks.assertElementIsVisible(getPageTitle());
        return this;
    }

    public ArtistDiscographyPageAndroid verifyLatestReleaseTitleIsAvailable() {
        androidElementChecks.assertElementIsVisible(getLatestReleaseTitle());
        return this;
    }

    public ArtistDiscographyPageAndroid verifyAlbumsTitleIsAvailable() {
        androidElementChecks.assertElementIsVisible(getAlbumsTitle());
        return this;
    }

    public ArtistDiscographyPageAndroid verifySinglesTitleIsAvailable() {
        androidPageNavigationActions.swipeToElementByText(SINGLES_TITLE_ID, ConfigProviderMobile.getMobileAppLocaleConfig().singlesTitleText(), 10);
        androidElementChecks.assertElementIsVisible(getSinglesTitle());
        return this;
    }

    public ArtistDiscographyPageAndroid verifyDiscographyItemIsAvailable(String itemTitle, Integer itemReleaseYear) {
        androidPageNavigationActions.swipeToElementWithSiblingByText(DISCOGRAPHY_ITEM_ID, itemTitle, itemReleaseYear.toString(), 10);
        androidElementChecks.assertElementIsVisible(androidElementActions.getItemByChildSiblings(DISCOGRAPHY_ITEM_ID, itemTitle, itemReleaseYear.toString()));
        return this;
    }

    private WebElement getPageTitle() {
        return androidElementActions.getElementByXpath(String.format(PAGE_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().artistDiscographyPageTitleText()));
    }

    private WebElement getLatestReleaseTitle() {
        return androidElementActions.getElementByXpath(String.format(LATEST_RELEASE_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().latestReleaseTitleText()));
    }

    private WebElement getAlbumsTitle() {
        return androidElementActions.getElementByXpath(String.format(ALBUMS_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().albumsTitleText()));
    }

    private WebElement getSinglesTitle() {
        return androidElementActions.getElementByXpath(String.format(SINGLES_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().singlesTitleText()));
    }
}
