package com.spotify.testdata.artist;

public enum ArtistAlbums {

    CAPITAL_BRA_BERLIN_LEBT_ALBUM("Berlin lebt", "2vdeSISq7TAWLDiEhFJ3nz", 40, "2018-07-06", "day");

    private final String albumName;
    private final String albumId;
    private final Integer albumTotalTracks;
    private final String albumReleaseDate;
    private final String albumReleaseDatePrecision;

    ArtistAlbums(String albumName, String albumId, Integer albumTotalTracks, String albumReleaseDate, String albumReleaseDatePrecision) {
        this.albumName = albumName;
        this.albumId = albumId;
        this.albumTotalTracks = albumTotalTracks;
        this.albumReleaseDate = albumReleaseDate;
        this.albumReleaseDatePrecision = albumReleaseDatePrecision;
    }

    public String getAlbumName() {
        return albumName;
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
