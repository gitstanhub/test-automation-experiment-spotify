package com.spotify.config.app;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:configuration/${country}_web_app_locale.properties",
        "classpath:configuration/uk_web_app_locale.properties"
})
public interface WebAppLocaleConfig extends Config {

    //LoginPage
    @Key("loggedInStateTitle")
    String loggedInStateTitle();

    @Key("loggedOutStateTitle")
    String loggedOutStateTitle();

    //LibraryPage
    @Key("libraryPageTitle")
    String libraryPageTitle();

    @Key("expandLibraryButtonText")
    String expandLibraryButtonText();

    @Key("sortByButtonText")
    String sortByButtonText();

    @Key("libraryPlaylistsFilterButtonText")
    String libraryPlaylistsFilterButtonText();

    @Key("searchLibraryFieldText")
    String searchLibraryFieldText();

    @Key("libraryButtonText")
    String libraryButtonText();

    @Key("clearFiltersButtonText")
    String clearFiltersButtonText();

    //SearchPage
    @Key("allFilterButtonText")
    String allFilterButtonText();

    @Key("songsFilterButtonText")
    String songsFilterButtonText();

    @Key("artistsFilterButtonText")
    String artistsFilterButtonText();

    @Key("albumsFilterButtonText")
    String albumsFilterButtonText();

    @Key("searchPlaylistsFilterButtonText")
    String searchPlaylistsFilterButtonText();

    @Key("profilesFilterButtonText")
    String profilesFilterButtonText();

    @Key("podcastsFilterButtonText")
    String podcastsFilterButtonText();

    //PlaylistPage
    @Key("editDetailsModalText")
    String editDetailsModalText();

    //AlbumPage
    @Key("embedCodeCopyButtonClickedText")
    String embedCodeCopyButtonClickedText();

    @Key("embedAlbumModalLabel")
    String embedAlbumModalLabel();

    @Key("embedCodeCopyButtonText")
    String embedCodeCopyButtonText();

    @Key("albumTypeSwitcherText")
    String albumTypeSwitcherText();

    @Key("explicitIconLabel")
    String explicitIconLabel();

    @Key("explicitIconText")
    String explicitIconText();

    //ContextMenu
    @Key("shareOptionText")
    String shareOptionText();

    @Key("embedAlbumOptionText")
    String embedAlbumOptionText();

    @Key("addToPlaylistOptionText")
    String addToPlaylistOptionText();

    @Key("createPlaylistOptionText")
    String createPlaylistOptionText();

    //OptionsMenu
    @Key("editDetailsOptionText")
    String editDetailsOptionText();
}
