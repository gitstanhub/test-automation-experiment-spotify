package com.spotify.testdata.tracks.constants;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.config.ConfigProviderWeb;
import com.spotify.config.entities.TrackConfig;

import java.io.IOException;
import java.util.List;

public enum Tracks {

    ARTIST2_TRACK_1(
            getTrackConfig("artist_2_track_1").getTrackArtists(),
            getTrackConfig("artist_2_track_1").getTrackName()
    );

    private final List<String> trackArtists;
    private final String trackName;

    Tracks(List<String> trackArtists, String trackName) {
        this.trackArtists = trackArtists;
        this.trackName = trackName;
    }

    private static TrackConfig getTrackConfig(String configItemName) {
        CountryCode countryCode = CountryCode.getByCode(ConfigProviderWeb.getWebAppConfiguration().countryCode());

        try {
            return ConfigProviderWeb.getEntityConfig(countryCode, configItemName, TrackConfig.class);
        } catch (IOException e) {
            throw new IllegalArgumentException("Couldn't find a track config for the provided item name: " + configItemName
                    + " and country: " + countryCode);
        }
    }

    public List<String> getTrackArtists() {
        return trackArtists;
    }

    public String getTrackName() {
        return trackName;
    }
}
