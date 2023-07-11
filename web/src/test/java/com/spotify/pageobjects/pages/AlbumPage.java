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

    public AlbumPage clickAlbumTypeSwitcher() {
        findAlbumTypeSwitcher().click();
        return this;
    }

    public AlbumPage selectAlbumTypeSwitcherOption(String optionName) {
        findAlbumTypeSwitcherOption(optionName).click();
        return this;
    }

    public AlbumPage verifyExplicitTracksAreAvailable() {
       Assertions.assertTrue(elementChecks.isElementVisible(findExplicitIcon()));
       return this;
    }

    public AlbumPage verifyExplicitTracksAreNotAvailable() {
        Assertions.assertFalse(elementChecks.isElementVisible(findExplicitIcon()));
        return this;
    }

    public AlbumPage verifyAlbumPageIsAvailable() {
        page.waitForSelector("[data-testid='album-page']");
        Assertions.assertTrue(elementChecks.isElementVisible(findAlbumPageSection()));
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

    private Locator findAlbumTypeSwitcher() {
        return elementActions.findElementBySelectorAndText("button span", "1 more release");
    }

    private Locator findAlbumTypeSwitcherOption(String optionName) {
        return elementActions.findElementBySelectorAndText("div[id='context-menu'] ul[tabindex] a", optionName);
    }

    private Locator findExplicitIcon() {
        return elementActions.findElementBySelectorAndText("span[aria-label='Explicit']", "E").locator("nth=0");
    }

    private Locator findAlbumPageSection() {
        return elementActions.findElementByTestId("album-page");
    }
}
