package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Locator;
import com.spotify.config.ConfigProviderWeb;
import com.spotify.pageobjects.base.PlaywrightPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.PlaywrightDriverHandler.getPage;
import static com.spotify.locators.pages.AlbumPageLocators.*;

@Component
@Lazy
@Slf4j
public class AlbumPage extends PlaywrightPage {

    public AlbumPage openAlbumPage(String albumId) {
        browserActions.navigateToUrl(ConfigProviderWeb.getWebAppConfiguration().baseUrl() + "/album/" + albumId);
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
        elementChecks.assertElementContainsText(ConfigProviderWeb.getWebAppLocaleConfig().embedCodeCopyButtonClickedText(), elementActions.findElementBySelector(EMBED_CODE_COPY_BUTTON));
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
        getPage().waitForSelector(ALBUM_PAGE_SELECTOR);
        Assertions.assertTrue(elementChecks.isElementVisible(findAlbumPageSection()));
        return this;
    }

    private Locator findEmbedAlbumModal() {
        return elementActions.findElementBySelector(String.format(EMBED_ALBUM_MODAL, ConfigProviderWeb.getWebAppLocaleConfig().embedAlbumModalLabel()));
    }

    private Locator findShowCodeCheckbox() {
        return elementActions.findElementBySelector(SHOW_CODE_CHECKBOX);
    }

    private Locator findIframeCodeField() {
        return elementActions.findElementByTestId(IFRAME_CODE_FIELD);
    }

    private Locator findEmbedCodeCopyButton() {
        return elementActions.findElementBySelectorAndText(EMBED_CODE_COPY_BUTTON, ConfigProviderWeb.getWebAppLocaleConfig().embedCodeCopyButtonText());
    }

    private Locator findAlbumTypeSwitcher() {
        return elementActions.findElementBySelectorAndText(ALBUM_TYPE_SWITCHER, ConfigProviderWeb.getWebAppLocaleConfig().albumTypeSwitcherText());
    }

    private Locator findAlbumTypeSwitcherOption(String optionName) {
        return elementActions.findElementBySelectorAndText(ALBUM_TYPE_SWITCHER_OPTION, optionName);
    }

    private Locator findExplicitIcon() {
        return elementActions.findElementBySelectorAndText(String.format(EXPLICIT_ICON, ConfigProviderWeb.getWebAppLocaleConfig().explicitIconLabel()), ConfigProviderWeb.getWebAppLocaleConfig().explicitIconText()).locator("nth=0");
    }

    private Locator findAlbumPageSection() {
        return elementActions.findElementByTestId(ALBUM_PAGE_SECTION_ID);
    }
}
