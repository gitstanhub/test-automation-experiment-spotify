package com.spotify.testdata.albums.constants;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.config.ConfigProviderWeb;
import com.spotify.config.entities.AlbumConfig;

import java.io.IOException;
import java.util.List;

public enum Albums {

    ARTIST_1_ALBUM_1(
            getAlbumConfig("artist_1_album_1").getAlbumArtists(),
            getAlbumConfig("artist_1_album_1").getAlbumName(),
            getAlbumConfig("artist_1_album_1").getAlbumId()
    );

    private final List<String> albumArtists;
    private final String albumName;
    private final String albumId;

    Albums(List<String> albumArtists, String albumName, String albumId) {
        this.albumArtists = albumArtists;
        this.albumName = albumName;
        this.albumId = albumId;
    }

    private static AlbumConfig getAlbumConfig(String configItemName) {
        CountryCode countryCode = CountryCode.getByCode(ConfigProviderWeb.getWebAppConfiguration().countryCode());

        try {
            return ConfigProviderWeb.getEntityConfig(countryCode, configItemName, AlbumConfig.class);
        } catch (IOException e) {
            throw new IllegalArgumentException("Couldn't find an album config for the provided item name: " + configItemName
                    + " and country: " + countryCode);
        }
    }

    public List<String> getAlbumArtists() {
        return albumArtists;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getAlbumId() {
        return albumId;
    }
}
