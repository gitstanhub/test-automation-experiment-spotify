package com.spotify.testdata.artist;

public enum AristTracks {

    CAPITAL_BRA_NEYMAR_TRACK("Neymar", "50mQStZYV5QFgyGK9GOVZg", 263646, "track", true);

    private final String trackName;
    private final String trackId;
    private final Integer trackDurationMs;
    private final String trackType;
    private final Boolean trackExplicit;

    AristTracks(String trackName, String trackId, Integer trackDurationMs, String trackType, Boolean trackExplicit) {
        this.trackName = trackName;
        this.trackId = trackId;
        this.trackDurationMs = trackDurationMs;
        this.trackType = trackType;
        this.trackExplicit = trackExplicit;
    }

    public String getTrackName() {
        return trackName;
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
