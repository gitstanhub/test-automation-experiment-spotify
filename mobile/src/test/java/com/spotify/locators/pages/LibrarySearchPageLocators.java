package com.spotify.locators.pages;

public class LibrarySearchPageLocators {

    public static final String LIBRARY_SEARCH_FIELD = "com.spotify.music:id/edit_text";
    public static final String SEARCH_FIELD_CLEAR_BUTTON = "com.spotify.music:id/icon_clear_search";
    public static final String EMPTY_VIEW_TITLE = "//android.widget.TextView[@resource-id='com.spotify.music:id/search_empty_view_title' and @text='%s']";
    public static final String EMPTY_VIEW_SUBTITLE = "//android.widget.TextView[@resource-id='com.spotify.music:id/search_empty_view_subtitle' and @text='%s']";
    public static final String SEARCH_RESULT_UIAUTOMATOR = "new UiSelector().description(\"%s\")";
}
