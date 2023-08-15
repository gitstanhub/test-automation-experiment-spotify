package com.spotify.locators.commons;

public class ContextMenuLocators {

    public final static String CONTEXT_MENU_TITLE = "//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='%s']";
    public final static String CONTEXT_MENU_SUBTITLE = "//android.widget.TextView[@resource-id='com.spotify.music:id/subtitle' and @text='%s']";
    public final static String LISTEN_TO_MUSIC_AD_FREE_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String FOLLOW_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String STOP_FOLLOWING_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String DO_NOT_PLAY_THIS_ARTIST_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String SHARE_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String SHOW_SPOTIFY_CODE_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String LIKE_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String REMOVE_LIKE_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String ADD_TO_PLAYLIST_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String ADD_TO_QUEUE_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String DOWNLOAD_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String VIEW_ARTIST_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String VIEW_ALBUM_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String VIEW_ARTISTS_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String LIKE_ALL_SONGS_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String EDIT_PLAYLIST_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String DELETE_PLAYLIST_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String INVITE_COLLABORATORS_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String REMOVE_FROM_PROFILE_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
    public final static String MAKE_PRIVATE_BUTTON = "new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().resourceId(\"com.spotify.music:id/title\").text(\"%s\"))";
}
