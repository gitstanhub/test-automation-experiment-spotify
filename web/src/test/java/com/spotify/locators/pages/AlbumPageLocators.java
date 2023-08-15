package com.spotify.locators.pages;

public class AlbumPageLocators {

    public static final String EMBED_CODE_COPY_BUTTON = "label[for='ewg-showcode'] + button[data-encore-id='buttonPrimary'] span";
    public static final String ALBUM_PAGE_SELECTOR = "[data-testid='album-page']";
    public static final String EMBED_ALBUM_MODAL = "div[aria-label='%s']";
    public static final String SHOW_CODE_CHECKBOX = "div[data-encore-id='formCheckbox'] label[for='ewg-showcode']";
    public static final String IFRAME_CODE_FIELD = "iframe-code";
    public static final String ALBUM_TYPE_SWITCHER = "button span";
    public static final String ALBUM_TYPE_SWITCHER_OPTION = "div[id='context-menu'] ul[tabindex] a";
    public static final String EXPLICIT_ICON = "span[aria-label='%s']";
    public static final String ALBUM_PAGE_SECTION_ID = "album-page";
}
