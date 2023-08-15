package com.spotify.locators.pages;

public class PlaylistPageLocators {

    public static final String PLAYLIST_SECTION_SELECTOR = "[data-testid='playlist-page']";
    public static final String PLAYLIST_TITLE = "[data-testid='playlist-page'] [data-testid='entityTitle']";
    public static final String PLAYLIST_DESCRIPTION = "[data-testid='playlist-page'] span[data-encore-id='type'] div";
    public static final String PLAYLIST_SECTION_ID = "playlist-page";
    public static final String EDIT_DETAILS_MODAL = "div[aria-label='%s']";
    public static final String EDIT_DETAILS_MODAL_DESCRIPTION = "playlist-edit-details-description-input";
    public static final String EDIT_DETAILS_MODAL_SAVE_BUTTON = "playlist-edit-details-save-button";
}
