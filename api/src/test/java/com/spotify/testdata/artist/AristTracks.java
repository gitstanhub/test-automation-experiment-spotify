package com.spotify.testdata.artist;

import java.util.Arrays;
import java.util.List;

public enum AristTracks {

    NEYMAR("Neymar", Arrays.asList("Capital Bra", "Ufo361"), "50mQStZYV5QFgyGK9GOVZg", 263646, "track", true);

    private final List<String> trackArtists;
    private final String trackName;
    private final String trackId;
    private final Integer trackDurationMs;
    private final String trackType;
    private final Boolean trackExplicit;

    AristTracks(String trackName, List<String> trackArtists, String trackId, Integer trackDurationMs, String trackType, Boolean trackExplicit) {
        this.trackName = trackName;
        this.trackArtists = trackArtists;
        this.trackId = trackId;
        this.trackDurationMs = trackDurationMs;
        this.trackType = trackType;
        this.trackExplicit = trackExplicit;
    }

    public String getTrackName() {
        return trackName;
    }
    public List<String> getTrackArtists() {
        return trackArtists;
    }

    public String getTrackId() {
        return trackId;
    }

    public Integer getTrackDurationMs() {
        return trackDurationMs;
    }

    public String getTrackType() {
        return trackType;
    }

    public Boolean getTrackExplicit() {
        return trackExplicit;
    }

}
