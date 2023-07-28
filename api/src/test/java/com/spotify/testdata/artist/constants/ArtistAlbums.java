package com.spotify.testdata.artist.constants;

import java.util.Arrays;
import java.util.List;

public enum ArtistAlbums {

    ARTIST_1_ALBUM_1("",Arrays.asList(""), "", 1, "", "", ""),
    BERLIN_LEBT("Berlin lebt", Arrays.asList("Capital Bra"), "2vdeSISq7TAWLDiEhFJ3nz", 40, "2018-07-06", "day", "album");

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
