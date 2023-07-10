package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import com.spotify.utils.ElementChecks;
import org.junit.jupiter.api.Assertions;

public class AlbumPage {

    private final BrowserActions browserActions;
    private final ElementActions elementActions;
    private final ElementChecks elementChecks;
    private final Page page;

    public AlbumPage(Page page) {
        this.page = page;
        this.browserActions = new BrowserActions(page);
        this.elementActions = new ElementActions(page);
        this.elementChecks = new ElementChecks(page);
    }

    public AlbumPage openAlbumPage(String albumId) {
        browserActions.navigateToUrl("https://open.spotify.com/album/" + albumId);
        return this;
    }

    public AlbumPage verifyEmbedAlbumModalIsAvailable() {
        Assertions.assertTrue(elementChecks.isElementVisible(findEmbedAlbumModal()));
        return this;
    }

    public AlbumPage clickShowCodeCheckbox() {
        findShowCodeCheckbox().click();
        return this;
    }

    public AlbumPage verifyIframeCodeFieldContainsAlbum(String albumId) {
        String expectedText = "<iframe style=\"border-radius:12px\"" +
                " src=\"https://open.spotify.com/embed/album/" + albumId + "?utm_source=generator\"" +
                " width=\"100%\" height=\"352\"" +
                " frameBorder=\"0\" allowfullscreen=\"\"" +
                " allow=\"autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture\"" +
                " loading=\"lazy\"></iframe>";

        elementChecks.assertElementContainsText(expectedText, findIframeCodeField());

        return this;
    }

    public AlbumPage verifyEmbedCodeCopyButtonIsClicked() {
        elementChecks.assertElementContainsText("COPIED!", elementActions.findElementBySelector("label[for='ewg-showcode'] + button[data-encore-id='buttonPrimary'] span"));
        return this;
    }

    public AlbumPage clickEmbedCodeCopyButton() {
        findEmbedCodeCopyButton().click();
        return this;
    }

    private Locator findEmbedAlbumModal() {
        return elementActions.findElementBySelector("div[aria-label='Embed album']");
    }

    private Locator findShowCodeCheckbox() {
        return elementActions.findElementBySelector("div[data-encore-id='formCheckbox'] label[for='ewg-showcode']");
    }

    private Locator findIframeCodeField() {
        return elementActions.findElementByTestId("iframe-code");
    }

    private Locator findEmbedCodeCopyButton() {
        return elementActions.findElementBySelectorAndText("label[for='ewg-showcode'] + button[data-encore-id='buttonPrimary'] span", "Copy");
    }
}
