package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Locator;
import com.spotify.pageobjects.base.PlaywrightPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.PlaywrightDriverHandler.getPage;

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
        getPage().waitForSelector("[data-testid='playlist-page']");
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
