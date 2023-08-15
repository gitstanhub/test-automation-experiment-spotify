package com.spotify.locators.pages;

public class PlaylistPageLocators {

    public static final String PLAYLIST_ARTWORK = "com.spotify.music:id/artwork";
    public static final String PLAYLIST_NAME = "//*[@resource-id='com.spotify.music:id/content_container']" +
            "//*[@resource-id='com.spotify.music:id/artwork']" +
            "/following-sibling::*[@resource-id='com.spotify.music:id/title']";
    public static final String DELETE_POPUP_TITLE = "//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='%s']";
    public static final String DELETE_POPUP_SUBTITLE = "//android.widget.TextView[@resource-id='com.spotify.music:id/body' and contains(@text, '%s') and contains(@text, '%s')]";
    public static final String DELETE_POPUP_CONFIRM_BUTTON = "//android.widget.Button[@resource-id='com.spotify.music:id/button_positive' and @text='%s']";
    public static final String DELETE_POPUP_CANCEL_BUTTON = "//android.widget.Button[@resource-id='com.spotify.music:id/button_positive' and @text='%s']";
}
