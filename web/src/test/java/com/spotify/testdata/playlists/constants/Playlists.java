package com.spotify.testdata.playlists.constants;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.config.ConfigProviderWeb;
import com.spotify.config.entities.PlaylistConfig;

import java.io.IOException;

public enum Playlists {

    PLAYLIST_1(
            getPlaylistConfig("playlist_1").getPlaylistName(),
            getPlaylistConfig("playlist_1").getPlaylistDescription()
    ),
    PLAYLIST_2(
            getPlaylistConfig("playlist_2").getPlaylistName(),
            getPlaylistConfig("playlist_2").getPlaylistDescription()
    );

    private final String playlistName;
    private final String playlistDescription;

    Playlists(String playlistName, String playlistDescription) {
        this.playlistName = playlistName;
        this.playlistDescription = playlistDescription;
    }

    private static PlaylistConfig getPlaylistConfig(String configItemName) {
        CountryCode countryCode = CountryCode.getByCode(ConfigProviderWeb.getWebAppConfiguration().countryCode());

        try {
            return ConfigProviderWeb.getEntityConfig(countryCode, configItemName, PlaylistConfig.class);
        } catch (IOException e) {
            throw new IllegalArgumentException("Couldn't find a playlist config for the provided item name: " + configItemName
                    + " and country: " + countryCode);
        }
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public String getPlaylistDescription() {
        return playlistDescription;
    }
}
