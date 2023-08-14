package com.spotify.testdata.albums.constants;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.config.ConfigProviderMobile;
import com.spotify.config.entities.AlbumConfig;

import java.io.IOException;
import java.util.List;

public enum Albums {

    ARTIST_1_ALBUM_1(
            getAlbumConfig("artist_1_album_1").getAlbumArtists(),
            getAlbumConfig("artist_1_album_1").getAlbumName(),
            getAlbumConfig("artist_1_album_1").getAlbumReleaseYear(),
            getAlbumConfig("artist_1_album_1").getAlbumFullReleaseDate(),
            getAlbumConfig("artist_1_album_1").getAlbumType(),
            getAlbumConfig("artist_1_album_1").getAlbumCopyrightText()
    ),
    ARTIST_2_ALBUM_1(
            getAlbumConfig("artist_2_album_1").getAlbumArtists(),
            getAlbumConfig("artist_2_album_1").getAlbumName(),
            getAlbumConfig("artist_2_album_1").getAlbumReleaseYear(),
            getAlbumConfig("artist_2_album_1").getAlbumFullReleaseDate(),
            getAlbumConfig("artist_2_album_1").getAlbumType(),
            getAlbumConfig("artist_2_album_1").getAlbumCopyrightText()
    ),
    ARTIST_2_ALBUM_2(
            getAlbumConfig("artist_2_album_2").getAlbumArtists(),
            getAlbumConfig("artist_2_album_2").getAlbumName(),
            getAlbumConfig("artist_2_album_2").getAlbumReleaseYear(),
            getAlbumConfig("artist_2_album_2").getAlbumFullReleaseDate(),
            getAlbumConfig("artist_2_album_2").getAlbumType(),
            getAlbumConfig("artist_2_album_2").getAlbumCopyrightText()
    );

    private final List<String> albumArtists;
    private final String albumName;
    private final Integer albumReleaseYear;
    private final String albumFullReleaseDate;
    private final String albumType;
    private final String albumCopyrightText;

    Albums(List<String> albumArtists, String albumName, Integer albumReleaseYear, String albumFullReleaseDate, String albumType, String albumCopyrightText) {
        this.albumArtists = albumArtists;
        this.albumName = albumName;
        this.albumReleaseYear = albumReleaseYear;
        this.albumFullReleaseDate = albumFullReleaseDate;
        this.albumType = albumType;
        this.albumCopyrightText = albumCopyrightText;
    }

    private static AlbumConfig getAlbumConfig(String configItemName) {
        CountryCode countryCode = CountryCode.getByCode(ConfigProviderMobile.getMobileAppConfiguration().countryCode());

        try {
            return ConfigProviderMobile.getEntityConfig(countryCode, configItemName, AlbumConfig.class);
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

    public Integer getAlbumReleaseYear() {
        return albumReleaseYear;
    }

    public String getAlbumFullReleaseDate() {
        return albumFullReleaseDate;
    }

    public String getAlbumType() {
        return albumType;
    }

    public String getAlbumCopyrightText() {
        return albumCopyrightText;
    }
}
