package com.spotify.locators.pages;

public class SearchPageLocators {

    public static final String SEARCH_PAGE_TITLE_ID_FIRST = "com.spotify.music:id/title";
    public static final String SEARCH_PAGE_TITLE_ID_SECOND = "com.spotify.music:id/header_title";
    public static final String SEARCH_PAGE_TITLE_UIAUTOMATOR = "new UiSelector().resourceId(\"%s\").text(\"%s\")";
    public static final String SCAN_SPOTIFY_CODE_BUTTON = "new UiSelector().resourceId(\"com.spotify.music:id/camera_button\").description(\"%s\")";
    public static final String SEARCH_FIELD = "com.spotify.music:id/find_search_field";
}
