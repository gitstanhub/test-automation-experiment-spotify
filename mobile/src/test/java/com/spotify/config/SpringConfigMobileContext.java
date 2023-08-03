package com.spotify.config;

import com.spotify.pageobjects.commons.android.accessprompt.BluetoothAccessPromptAndroid;
import com.spotify.pageobjects.commons.android.contextmenu.ContextMenuAndroid;
import com.spotify.pageobjects.commons.android.elementslist.ElementsListAndroid;
import com.spotify.pageobjects.commons.android.mediainteraction.MediaInteractionAndroid;
import com.spotify.pageobjects.commons.android.navigation.NavigationAndroid;
import com.spotify.pageobjects.commons.android.screensaverad.ScreensaverAdAndroid;
import com.spotify.pageobjects.commons.android.spotifycode.SpotifyCodeAndroid;
import com.spotify.pageobjects.pages.android.album.AlbumPageAndroid;
import com.spotify.pageobjects.pages.android.artist.ArtistDiscographyPageAndroid;
import com.spotify.pageobjects.pages.android.artist.ArtistProfilePageAndroid;
import com.spotify.pageobjects.pages.android.library.LibraryPageAndroid;
import com.spotify.pageobjects.pages.android.library.LibrarySearchPageAndroid;
import com.spotify.pageobjects.pages.android.login.LoginPageAndroid;
import com.spotify.pageobjects.pages.android.playlist.PlaylistCreationPageAndroid;
import com.spotify.pageobjects.pages.android.playlist.PlaylistPageAndroid;
import com.spotify.pageobjects.pages.android.search.SearchPageAndroid;
import com.spotify.pageobjects.pages.android.search.SearchResultsPageAndroid;
import com.spotify.utils.assertions.ElementChecksMobile;
import com.spotify.utils.navigation.android.AndroidDeviceActions;
import com.spotify.utils.navigation.android.AndroidElementActions;
import com.spotify.utils.navigation.android.AndroidPageNavigationActions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigMobileContext {

    public static AnnotationConfigApplicationContext setContextWithPages(String platformName) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        switch (platformName) {
            case "android" -> {
                setContextWithAndroidPages(applicationContext);
            }

            default -> {
                String errorMessage = String.format("Cannot set a config with page beans - the provided platform of type %s is not supported", platformName);
                throw new IllegalArgumentException(errorMessage);
            }
        }

        applicationContext.refresh();

        return applicationContext;
    }

    private static void setContextWithAndroidPages(AnnotationConfigApplicationContext applicationContext) {

        applicationContext.register(ElementChecksMobile.class);
        applicationContext.register(AndroidDeviceActions.class);
        applicationContext.register(AndroidElementActions.class);
        applicationContext.register(AndroidPageNavigationActions.class);

        applicationContext.register(BluetoothAccessPromptAndroid.class);
        applicationContext.register(ContextMenuAndroid.class);
        applicationContext.register(ElementsListAndroid.class);
        applicationContext.register(MediaInteractionAndroid.class);
        applicationContext.register(NavigationAndroid.class);
        applicationContext.register(ScreensaverAdAndroid.class);
        applicationContext.register(SpotifyCodeAndroid.class);

        applicationContext.register(AlbumPageAndroid.class);
        applicationContext.register(ArtistDiscographyPageAndroid.class);
        applicationContext.register(ArtistProfilePageAndroid.class);
        applicationContext.register(LibraryPageAndroid.class);
        applicationContext.register(LibrarySearchPageAndroid.class);
        applicationContext.register(LoginPageAndroid.class);
        applicationContext.register(PlaylistCreationPageAndroid.class);
        applicationContext.register(PlaylistPageAndroid.class);
        applicationContext.register(SearchPageAndroid.class);
        applicationContext.register(SearchResultsPageAndroid.class);
    }
}
