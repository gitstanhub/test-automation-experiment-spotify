package com.spotify.locators.pages;

public class LibraryPageLocators {

    public static final String LIBRARY_BUTTON = "button[aria-label='%s']";
    public static final String CLEAR_FILTERS_BUTTON = "button[aria-label='%s']";
    public static final String LIBRARY_ITEMS_TOTAL = "div[role=presentation] li[aria-posinset] >> nth=1";
    public static final String LIBRARY_ITEMS_TOTAL_ATTRIBUTE = "aria-setsize";
    public static final String LIBRARY_ITEM_SELECTOR = "div[role=presentation] li[aria-posinset='%s'] div[data-encore-id='listRow'] p[id^='listrow-title-spotify'] span";
    public static final String CREATED_PLAYLIST_ITEM = "nth=0";
    public static final String SORT_BY_OPTION = "div[id = context-menu] li button span ";
    public static final String EXPAND_LIBRARY_BUTTON = "button[aria-label='%s']";
    public static final String SORT_BY_BUTTON = "button[aria-label='%s']";
    public static final String PLAYLISTS_FILTER_BUTTON = "button[role='checkbox']";
    public static final String LIBRARY_ITEM = "li[role='listitem'][aria-posinset]:nth-of-type(1)";
    public static final String LIBRARY_FILTER_BUTTON_PRESSED = "aria-checked";
    public static final String SEARCH_LIBRARY_BUTTON = "expand-button";
    public static final String SEARCH_LIBRARY_FIELD = "input[placeholder='%s']";
}
