package com.spotify.locators.pages;

public class PlaylistCreationPageLocators {

    public static final String PLAYLIST_CREATION_PAGE_TITLE = "//android.widget.TextView[@resource-id='com.spotify.music:id/naming_title' and @text='%s']";
    public static final String PLAYLIST_NAME_FIELD = "new UiSelector().resourceId(\"com.spotify.music:id/edit_text\").description(\"%s\")";
    public static final String CREATE_BUTTON = "com.spotify.music:id/continue_button";
    public static final String CANCEL_BUTTON = "com.spotify.music:id/cancel_button";
}
