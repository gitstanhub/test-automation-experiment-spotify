package com.spotify.locators.pages;

public class LibraryPageLocators {

    public static final String ARTIST_ITEM_SUBTITLE_ID = "com.spotify.music:id/subtitle";
    public static final String ARTIST_ITEM_TITLE_ID = "com.spotify.music:id/title";
    public static final String SORT_BUTTON = "com.spotify.music:id/sort";
    public static final String PROFILE_BUTTON = "new UiSelector().resourceId(\"com.spotify.music:id/faceheader_image\").description(\"%s\")";
    public static final String LIBRARY_PAGE_TITLE = "new UiSelector().resourceId(\"com.spotify.music:id/faceheader_title\").description(\"%s\")";
    public static final String PLAYLISTS_BUTTON = "new UiSelector().className(\"android.widget.TextView\").text(\"%s\")";
    public static final String ALBUMS_BUTTON = "new UiSelector().className(\"android.widget.TextView\").text(\"%s\")";
    public static final String ARTISTS_BUTTON = "new UiSelector().className(\"android.widget.TextView\").text(\"%s\")";
    public static final String SEARCH_BUTTON = "com.spotify.music:id/icon_search";
    public static final String CREATE_PLAYLIST_BUTTON = "com.spotify.music:id/icon_create";
    public static final String CHANGE_LAYOUT_BUTTON = "com.spotify.music:id/icon_grid_list";
    public static final String CREATE_PLAYLIST_MENU_TITLE = "//android.widget.TextView[@resource-id='com.spotify.music:id/heading' and @text='%s']";
    public static final String CREATE_PLAYLIST_MENU_BUTTON = "com.spotify.music:id/create_playlist_row";
}
