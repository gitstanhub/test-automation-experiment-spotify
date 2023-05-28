package com.spotify.testdata.artist.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ArtistEntities {

    CAPITAL_BRA("Capital Bra", "4WZGDpNwrC0vNQyl9QzF7d", Arrays.asList("german hip hop"), "artist"),
    AK_AUSSERKONTOLLE("AK AUSSERKONTROLLE", "07SFzTMeYf5P8Rd32a9Zzw", Arrays.asList("german hip hop"), "artist"),
    YEAT("Yeat", "3qiHUAX7zY4Qnjx8TNUzVx", Arrays.asList("pluggnb", "rage rap"), "artist");

    private final String artistName;
    private final List<String> artistGenres;
    private final String artistId;
    private final String artistType;

    ArtistEntities(String artistName, String artistId, List<String> artistGenres, String artistType) {
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

    public static List<String> getMultipleArtistIds(List<ArtistEntities> multipleArtists) {
        List<String> multipleArtistIds = new ArrayList<>();
        for (ArtistEntities artistEntity : multipleArtists) {
            multipleArtistIds.add(artistEntity.getArtistId());
        }
        return multipleArtistIds;
    }

    public static List<String> getMultipleArtistNames(List<ArtistEntities> multipleArtists) {
        List<String> multipleArtistNames = new ArrayList<>();
        for (ArtistEntities artistEntity : multipleArtists) {
            multipleArtistNames.add(artistEntity.getArtistName());
        }
        return multipleArtistNames;
    }

    public static List<String> getMultipleArtistGenres(List<ArtistEntities> multipleArtists) {
        List<String> multipleArtistGenres = new ArrayList<>();
        for (ArtistEntities artistEntity : multipleArtists) {
            multipleArtistGenres.add(String.join(",", artistEntity.getArtistGenres()));
        }
        return multipleArtistGenres;
    }
}
