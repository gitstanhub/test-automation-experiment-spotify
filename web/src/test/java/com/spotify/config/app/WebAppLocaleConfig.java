package com.spotify.config.app;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:configuration/${market}_web_app_locale.properties",
        "classpath:configuration/uk_web_app_locale.properties"
})
public interface WebAppLocaleConfig extends Config {

    //LoginPage
    String loggedInStateTitle();
    String loggedOutStateTitle();

    //LibraryPage
    String libraryPageTitle();
    String expandLibraryButtonText();
    String sortByButtonText();
    String libraryPlaylistsFilterButtonText();
    String searchLibraryFieldText();
    String libraryButtonText();
    String clearFiltersButtonText();

    //SearchPage
    String allFilterButtonText();
    String songsFilterButtonText();
    String artistsFilterButtonText();
    String albumsFilterButtonText();
    String searchPlaylistsFilterButtonText();
    String profilesFilterButtonText();
    String podcastsFilterButtonText();

    //PlaylistPage
    String editDetailsModalText();

    //AlbumPage
    String embedCodeCopyButtonClickedText();
    String embedAlbumModalLabel();
    String embedCodeCopyButtonText();
    String albumTypeSwitcherText();
    String explicitIconLabel();
    String explicitIconText();
}
