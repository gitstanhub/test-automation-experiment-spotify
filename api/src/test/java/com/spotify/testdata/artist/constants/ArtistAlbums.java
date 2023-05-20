package com.spotify.testdata.artist.constants;

import java.util.Arrays;
import java.util.List;

public enum ArtistAlbums {

    BERLIN_LEBT("Berlin lebt", Arrays.asList("Capital Bra"), "2vdeSISq7TAWLDiEhFJ3nz", 40, "2018-07-06", "day");

    private final List<String> albumArtists;
    private final String albumName;
    private final String albumId;
    private final Integer albumTotalTracks;
    private final String albumReleaseDate;
    private final String albumReleaseDatePrecision;

    ArtistAlbums(String albumName, List<String> albumArtists, String albumId, Integer albumTotalTracks, String albumReleaseDate, String albumReleaseDatePrecision) {
        this.albumName = albumName;
        this.albumArtists = albumArtists;
        this.albumId = albumId;
        this.albumTotalTracks = albumTotalTracks;
        this.albumReleaseDate = albumReleaseDate;
        this.albumReleaseDatePrecision = albumReleaseDatePrecision;
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
}
