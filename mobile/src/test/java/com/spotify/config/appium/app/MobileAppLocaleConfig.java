package com.spotify.config.appium.app;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:configuration/${market}_mobile_app_locale.properties",
        "classpath:configuration/uk_mobile_app_locale.properties"
})
public interface MobileAppLocaleConfig extends Config {

    //LoginPage
    @Key("logInButtonText")
    String logInButtonText();

    //AlbumPage
    @Key("youMightAlsoLikeTitleText")
    String youMightAlsoLikeTitleText();

    //ArtistDiscographyPage
    @Key("artistDiscographyPageTitleText")
    String artistDiscographyPageTitleText();

    @Key("latestReleaseTitleText")
    String latestReleaseTitleText();

    @Key("albumsTitleText")
    String albumsTitleText();

    @Key("singlesTitleText")
    String singlesTitleText();

    //ArtistProfilePage
    @Key("popularReleasesTitleText")
    String popularReleasesTitleText();

    @Key("artistPlaylistsTitleText")
    String artistPlaylistsTitleText();

    @Key("fansAlsoLikeSectionText")
    String fansAlsoLikeSectionText();

    @Key("seeDiscographyButtonText")
    String seeDiscographyButtonText();

    @Key("artistPickTitleText")
    String artistPickTitleText();

    @Key("featuringArtistTitleText")
    String featuringArtistTitleText();

    @Key("liveEventsTitleText")
    String liveEventsTitleText();

    @Key("merchTitleText")
    String merchTitleText();

    @Key("aboutTitleText")
    String aboutTitleText();

    @Key("fansAlsoLikeTitleText")
    String fansAlsoLikeTitleText();

    //ContextMenu
    @Key("listenToMusicAdFreeButtonText")
    String listenToMusicAdFreeButtonText();

    @Key("followButtonText")
    String followButtonText();

    @Key("stopFollowingButtonText")
    String stopFollowingButtonText();

    @Key("doNotPlayThisArtistButtonText")
    String doNotPlayThisArtistButtonText();

    @Key("shareButtonText")
    String shareButtonText();

    @Key("showSpotifyCodeButtonText")
    String showSpotifyCodeButtonText();

    @Key("likeButtonText")
    String likeButtonText();

    @Key("removeLikeButtonText")
    String removeLikeButtonText();

    @Key("addToPlaylistButtonText")
    String addToPlaylistButtonText();

    @Key("addToQueueButtonText")
    String addToQueueButtonText();

    @Key("downloadButtonText")
    String downloadButtonText();

    @Key("viewArtistButtonText")
    String viewArtistButtonText();

    @Key("viewAlbumButtonText")
    String viewAlbumButtonText();

    @Key("viewArtistsButtonText")
    String viewArtistsButtonText();

    @Key("likeAllSongsButtonText")
    String likeAllSongsButtonText();

    @Key("editPlaylistButtonText")
    String editPlaylistButtonText();

    @Key("deletePlaylistButtonText")
    String deletePlaylistButtonText();

    @Key("inviteCollaboratorsButtonText")
    String inviteCollaboratorsButtonText();

    @Key("removeFromProfileButtonText")
    String removeFromProfileButtonText();

    @Key("makePrivateButtonText")
    String makePrivateButtonText();

    //MediaInteraction
    @Key("shuffleButtonContentDescriptionText")
    String shuffleButtonContentDescriptionText();

    //LibraryPage
    @Key("artistItemSubtitleText")
    String artistItemSubtitleText();

    @Key("albumItemSubtitleText")
    String albumItemSubtitleText();

    @Key("playlistItemSubtitleText")
    String playlistItemSubtitleText();

    @Key("profileButtonText")
    String profileButtonText();

    @Key("libraryPageTitleText")
    String libraryPageTitleText();

    @Key("playlistsButtonText")
    String playlistsButtonText();

    @Key("albumsButtonText")
    String albumsButtonText();

    @Key("artistsButtonText")
    String artistsButtonText();

    @Key("createPlaylistMenuTitleText")
    String createPlaylistMenuTitleText();

    //LibrarySearchPage
    @Key("emptyViewTitleText")
    String emptyViewTitleText();
    @Key("emptyViewSubtitleText")
    String emptyViewSubtitleText();

    //PlaylistCreationPage
    @Key("playListCreationPageTitleText")
    String playListCreationPageTitleText();

    @Key("playlistNameFieldText")
    String playlistNameFieldText();

    //PlaylistPage
    @Key("deletePopupTitleText")
    String deletePopupTitleText();

    @Key("deletePopupSubtitleText")
    String deletePopupSubtitleText();

    @Key("deletePopupConfirmButtonText")
    String deletePopupConfirmButtonText();

    @Key("deletePopupCancelButtonText")
    String deletePopupCancelButtonText();
}
