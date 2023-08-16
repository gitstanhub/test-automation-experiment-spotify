package com.spotify.pageobjects.commons;

import com.microsoft.playwright.Locator;
import com.spotify.config.ConfigProviderWeb;
import com.spotify.pageobjects.base.PlaywrightPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.locators.commons.ContextMenuLocators.*;

@Component
@Lazy
@Slf4j
public class ContextMenu extends PlaywrightPage {

    @Step
    public ContextMenu clickContextMenuButton() {
        findContextMenuButton().click();
        return this;
    }

    @Step
    public ContextMenu selectShareOption() {
        findShareOption().hover();
        return this;
    }

    @Step
    public ContextMenu clickEmbedAlbumOption() {
        findEmbedAlbumOption().click();
        return this;
    }

    @Step
    public ContextMenu selectAddToPlaylistOption() {
        findAddToPlaylistOption().hover();
        return this;
    }

    @Step
    public ContextMenu clickCreatePlaylistButton() {
        findCreatePlaylistOption().click();
        return this;
    }

    private Locator findContextMenuButton() {
        return elementActions.findElementBySelector(CONTEXT_MENU_BUTTON);
    }

    private Locator findShareOption() {
        return elementActions.findElementBySelectorAndText(SHARE_OPTION, ConfigProviderWeb.getWebAppLocaleConfig().shareOptionText());
    }

    private Locator findEmbedAlbumOption() {
        return elementActions.findElementBySelectorAndText(EMBED_ALBUM, ConfigProviderWeb.getWebAppLocaleConfig().embedAlbumOptionText());
    }

    private Locator findAddToPlaylistOption() {
        return elementActions.findElementBySelectorAndText(ADD_TO_PLAYLIST_OPTION, ConfigProviderWeb.getWebAppLocaleConfig().addToPlaylistOptionText());
    }

    private Locator findCreatePlaylistOption() {
        return elementActions.findElementBySelectorAndText(CREATE_PLAYLIST_OPTION, ConfigProviderWeb.getWebAppLocaleConfig().createPlaylistOptionText());
    }
}
