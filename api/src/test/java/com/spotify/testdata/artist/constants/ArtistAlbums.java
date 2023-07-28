package com.spotify.testdata.artist.constants;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.config.ConfigProviderApi;
import com.spotify.config.restassured.entities.AlbumConfig;
import com.spotify.config.restassured.entities.TrackConfig;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public enum ArtistAlbums {
    ARTIST_1_ALBUM_1(
            getAlbumConfig("artist_1_album_1").getAlbumName(),
            getAlbumConfig("artist_1_album_1").getAlbumArtists(),
            getAlbumConfig("artist_1_album_1").getAlbumId(),
            getAlbumConfig("artist_1_album_1").getAlbumTotalTracks(),
            getAlbumConfig("artist_1_album_1").getAlbumReleaseDate(),
            getAlbumConfig("artist_1_album_1").getAlbumReleaseDatePrecision(),
            getAlbumConfig("artist_1_album_1").getAlbumType());

    private final List<String> albumArtists;
    private final String albumName;
    private final String albumId;
    private final Integer albumTotalTracks;
    private final String albumReleaseDate;
    private final String albumReleaseDatePrecision;
    private final String albumType;

    ArtistAlbums(String albumName, List<String> albumArtists, String albumId, Integer albumTotalTracks, String albumReleaseDate, String albumReleaseDatePrecision, String albumType) {
        this.albumName = albumName;
        this.albumArtists = albumArtists;
        this.albumId = albumId;
        this.albumTotalTracks = albumTotalTracks;
        this.albumReleaseDate = albumReleaseDate;
        this.albumReleaseDatePrecision = albumReleaseDatePrecision;
        this.albumType = albumType;
    }

    private static AlbumConfig getAlbumConfig(String configItemName) {
        CountryCode countryCode = CountryCode.getByCode(ConfigProviderApi.getRestAssuredApiConfiguration().market());

        try {
            return ConfigProviderApi.getEntityConfig(countryCode, configItemName, AlbumConfig.class);
        } catch (IOException e) {
            throw new IllegalArgumentException("Couldn't find an album config for the provided item name: " + configItemName
                    + " and market: " + countryCode);
        }
    }

    public String getAlbumName() {
        return albumName;
    }

    public List<String> getAlbumArtists() {
        return albumArtists;
    }

    public String getAlbumId() {
        return albumId;
    }

    public Integer getAlbumTotalTracks() {
        return albumTotalTracks;
    }

    public String getAlbumReleaseDate() {
        return albumReleaseDate;
    }

    public String getAlbumReleaseDatePrecision() {
        return albumReleaseDatePrecision;
    }

    public String getAlbumType() {
        return albumType;
    }
}
