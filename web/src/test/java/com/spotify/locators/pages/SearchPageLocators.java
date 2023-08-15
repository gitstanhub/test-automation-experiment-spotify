package com.spotify.locators.pages;

public class SearchPageLocators {

    public static final String FILTER_ALL_BUTTON_SELECTOR = "[data-testid='grid-search-results']";
    public static final String SEARCH_RESULT_TRACK_ROW = "[data-testid = 'tracklist-row']";
    public static final String SONG_TITLE_SELECTOR = "div[aria-rowindex='%s'] [data-testid = 'tracklist-row'] a div";
    public static final String SONG_ARTIST_SELECTOR = "div[aria-rowindex='%s'] [data-testid = 'tracklist-row'] span a[href*='/artist']";
    public static final String SEARCH_RESULTS_LIST = "[data-testid='infinite-scroll-list']";
    public static final String PLAYLIST_TITLE_SELECTOR = "[data-testid='search-category-card-%s'] a div";
    public static final String SEARCH_FIELD = "search-input";
}
