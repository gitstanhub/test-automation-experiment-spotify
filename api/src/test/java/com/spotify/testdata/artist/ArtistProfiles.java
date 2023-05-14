package com.spotify.testdata.artist;

import java.util.Arrays;
import java.util.List;

public enum ArtistProfiles {

    CAPITAL_BRA_PROFILE("Capital Bra", "4WZGDpNwrC0vNQyl9QzF7d", Arrays.asList("german hip hop"), "artist");

    private final String artistName;
    private final List<String> artistGenres;
    private final String artistId;
    private final String artistType;


    ArtistProfiles(String artistName, String artistId,  List<String> artistGenres, String artistType) {
        this.artistName = artistName;
        this.artistGenres = artistGenres;
        this.artistId = artistId;
        this.artistType = artistType;
    }

    public String getArtistName() {
        return artistName;
    }

    public List<String> getArtistGenres() {
        return artistGenres;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getArtistType() {
        return artistType;
    }



    public String getArtistUri() {
        return "spotify:" + this.artistType + ":" + this.artistId;
    }



//    public static final String ARTIST_ID = "4WZGDpNwrC0vNQyl9QzF7d";
//
//    public static final String ARTIST_NAME_MULTIPLE_PROFILES = "Yeat";
//    public static final String ARTIST_TOP_TRACK_TITLE = "Discokugel";
//    public static final String ARTIST_ALBUM_TITLE = "DEUTSCHRAP BRANDNEU";
//    public static final String ARTIST_RELATED_NAME = "AK AUSSERKONTROLLE";
//    public static final String ARTIST_TYPE = "artist";
//
//
//    public static List<String> artistGenresList = Arrays.asList("german hip hop");

}
