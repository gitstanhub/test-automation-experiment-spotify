package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import com.spotify.utils.ElementChecks;
import org.junit.jupiter.api.Assertions;

public class PlaylistPage {

    private final BrowserActions browserActions;
    private final ElementActions elementActions;
    private final ElementChecks elementChecks;
    private final Page page;

    public PlaylistPage(Page page) {
        this.page = page;
        this.browserActions = new BrowserActions(page);
        this.elementActions = new ElementActions(page);
        this.elementChecks = new ElementChecks(page);
    }

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
        page.waitForSelector("[data-testid='playlist-page']");
        Assertions.assertTrue(elementChecks.isElementVisible(findPlaylistSection()));
        return this;
    }

    public PlaylistPage verifyPlaylistTitleIsAvailableWithText(String expectedPlaylistTitle) {
        Assertions.assertTrue(elementChecks.isElementVisible(elementActions.findElementBySelectorAndText("[data-testid='playlist-page'] [data-testid='entityTitle']", expectedPlaylistTitle)));
        return this;
    }

    public PlaylistPage verifyPlaylistDescriptionIsAvailableWithText(String expectedPlaylistDescription) {
        Assertions.assertTrue(elementChecks.isElementVisible(elementActions.findElementBySelectorAndText("[data-testid='playlist-page'] span[data-encore-id='type'] div", expectedPlaylistDescription)));
        return this;
    }

    private Locator findPlaylistSection() {
        return elementActions.findElementByTestId("playlist-page");
    }

    private Locator findEditDetailsModal() {
        return elementActions.findElementBySelector("div[aria-label='Edit details']:has-text(\"Edit details\")");
    }

    private Locator findEditDetailsModalDescriptionField() {
        return elementActions.findElementByTestId("playlist-edit-details-description-input");
    }

    private Locator findEditDetailsModalSaveButton() {
        return elementActions.findElementByTestId("playlist-edit-details-save-button");
    }

    private Locator findPlaylistTitle() {
        return elementActions.findElementBySelector("[data-testid='playlist-page'] [data-testid='entityTitle']");
    }

    private Locator findPlaylistDescription() {
        return elementActions.findElementBySelector("[data-testid='playlist-page'] span[data-encore-id='type'] div");
    }
}
