package com.spotify.locators.pages;

public class SearchResultsPageLocators {

    public static final String GLOBAL_SEARCH_FIELD = "com.spotify.music:id/query";
    public static final String SEARCH_RESULTS_PLACEHOLDER_TITLE = "//android.widget.TextView[@resource-id='com.spotify.music:id/text1' and @text='%s']";
    public static final String SEARCH_RESULTS_PLACEHOLDER_SUBTITLE = "//android.widget.TextView[@resource-id='com.spotify.music:id/text2' and @text='%s']";
    public static final String TOP_FILTER_BUTTON = "//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='%s']";
    public static final String ARTIST_FILTER_BUTTON = "//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='%s']";
    public static final String SONGS_FILTER_BUTTON = "//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='%s']";
    public static final String ALBUMS_FILTER_BUTTON = "//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='%s']";
    public static final String PLAYLISTS_FILTER_BUTTON = "//android.widget.Button[@resource-id='com.spotify.music:id/chip_button' and @text='%s']";
    public static final String SEARCH_RESULT_ID = "com.spotify.music:id/title";
    public static final String SEARCH_RESULT = "//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='%s']";
}
