package com.spotify.testdata.artist.constants;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.config.ConfigProviderApi;
import com.spotify.config.restassured.entities.TrackConfig;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
public enum AristTracks {
    ARTIST1_TRACK_1(
            getTrackConfig("artist_1_track_1").getTrackName(),
            getTrackConfig("artist_1_track_1").getTrackArtists(),
            getTrackConfig("artist_1_track_1").getTrackId(),
            getTrackConfig("artist_1_track_1").getTrackDurationMs(),
            getTrackConfig("artist_1_track_1").getTrackType(),
            getTrackConfig("artist_1_track_1").getTrackExplicit()
    );

//    NEYMAR("Neymar", Arrays.asList("Capital Bra", "Ufo361"), "50mQStZYV5QFgyGK9GOVZg", 263646, "track", true);

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

    private static TrackConfig getTrackConfig(String configItemName) {
        try {
            CountryCode countryCode = CountryCode.getByCode(ConfigProviderApi.getRestAssuredApiConfiguration().market());

            return ConfigProviderApi.getEntityConfig(countryCode, configItemName, TrackConfig.class);
        } catch (IOException e) {
            throw new IllegalArgumentException("Couldn't find a track config for the provided item name: " + configItemName);
        }
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
