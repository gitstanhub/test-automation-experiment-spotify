package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Locator;
import com.spotify.config.ConfigProviderWeb;
import com.spotify.pageobjects.base.PlaywrightPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.PlaywrightDriverHandler.getPage;
import static com.spotify.locators.pages.PlaylistPageLocators.*;

@Component
@Lazy
@Slf4j
public class PlaylistPage extends PlaywrightPage {

    public PlaylistPage verifyEditDetailsModalIsAvailable() {
        Assertions.assertTrue(elementChecks.isElementVisible(findEditDetailsModal()));
        return this;
    }

    public PlaylistPage clearEditDetailsModalDescriptionField() {
        findEditDetailsModalDescriptionField().clear();
        return this;
    }

    public PlaylistPage fillInEditDetailsModalDescriptionField(String inputText) {
        findEditDetailsModalDescriptionField().fill(inputText);
        return this;
    }

    public PlaylistPage clickEditDetailsModalSaveButton() {
        findEditDetailsModalSaveButton().click();
        return this;
    }

    public PlaylistPage verifyEditDetailsModalDescriptionFieldContainsText(String expectedText) {
        elementChecks.assertInputElementContainsText(expectedText, findEditDetailsModalDescriptionField());
        return this;
    }

    public PlaylistPage verifyPlaylistSectionIsAvailable() {
        getPage().waitForSelector(PLAYLIST_SECTION_SELECTOR);
        Assertions.assertTrue(elementChecks.isElementVisible(findPlaylistSection()));
        return this;
    }

    public PlaylistPage verifyPlaylistTitleIsAvailableWithText(String expectedPlaylistTitle) {
        Assertions.assertTrue(elementChecks.isElementVisible(elementActions.findElementBySelectorAndText(PLAYLIST_TITLE, expectedPlaylistTitle)));
        return this;
    }

    public PlaylistPage verifyPlaylistDescriptionIsAvailableWithText(String expectedPlaylistDescription) {
        Assertions.assertTrue(elementChecks.isElementVisible(elementActions.findElementBySelectorAndText(PLAYLIST_DESCRIPTION, expectedPlaylistDescription)));
        return this;
    }

    private Locator findPlaylistSection() {
        return elementActions.findElementByTestId(PLAYLIST_SECTION_ID);
    }

    private Locator findEditDetailsModal() {
        return elementActions.findElementBySelector(String.format(EDIT_DETAILS_MODAL, ConfigProviderWeb.getWebAppLocaleConfig().editDetailsModalText()));
    }

    private Locator findEditDetailsModalDescriptionField() {
        return elementActions.findElementByTestId(EDIT_DETAILS_MODAL_DESCRIPTION);
    }

    private Locator findEditDetailsModalSaveButton() {
        return elementActions.findElementByTestId(EDIT_DETAILS_MODAL_SAVE_BUTTON);
    }

    private Locator findPlaylistTitle() {
        return elementActions.findElementBySelector(PLAYLIST_TITLE);
    }

    private Locator findPlaylistDescription() {
        return elementActions.findElementBySelector(PLAYLIST_DESCRIPTION);
    }
}
