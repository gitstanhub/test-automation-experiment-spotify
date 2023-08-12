package com.spotify.testdata.playlist.constants;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.config.ConfigProviderMobile;
import com.spotify.config.appium.entities.PlaylistConfig;

import java.io.IOException;

public enum PlaylistEntities {

    PLAYLIST_1(
            getPlaylistConfig("playlist_1").getPlaylistName(),
            getPlaylistConfig("playlist_1").getPlaylistAuthor(),
            getPlaylistConfig("playlist_1").getPlaylistType()
    );

    private final String playlistName;
    private final String playlistAuthor;
    private final String playlistType;

    PlaylistEntities(String playlistName, String playlistAuthor, String playlistType) {
        this.playlistName = playlistName;
        this.playlistAuthor = playlistAuthor;
        this.playlistType = playlistType;
    }

    private static PlaylistConfig getPlaylistConfig(String configItemName) {
        CountryCode countryCode = CountryCode.getByCode(ConfigProviderMobile.getMobileAppConfiguration().country());

        try {
            return ConfigProviderMobile.getEntityConfig(countryCode, configItemName, PlaylistConfig.class);
        } catch (IOException e) {
            throw new IllegalArgumentException("Couldn't find a playlist config for the provided item name: " + configItemName
                    + " and market: " + countryCode);
        }
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public String getPlaylistAuthor() {
        return playlistAuthor;
    }

    public String getPlaylistType() {
        return playlistType;
    }
}
