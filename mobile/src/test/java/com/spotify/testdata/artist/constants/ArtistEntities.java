package com.spotify.testdata.artist.constants;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.config.ConfigProviderMobile;
import com.spotify.config.appium.entities.ArtistConfig;

import java.io.IOException;

public enum ArtistEntities {
    ARTIST_1(
            getArtistConfig("artist_1").getArtistName(),
            getArtistConfig("artist_1").getArtistType()
    ),
    ARTIST_2(
            getArtistConfig("artist_2").getArtistName(),
            getArtistConfig("artist_2").getArtistType()
    );

    private final String artistName;
    private final String artistType;

    ArtistEntities(String artistName, String artistType) {
        this.artistName = artistName;
        this.artistType = artistType;
    }

    private static ArtistConfig getArtistConfig(String configItemName) {
        CountryCode countryCode = CountryCode.getByCode(ConfigProviderMobile.getMobileAppConfiguration().country());

        try {
            return ConfigProviderMobile.getEntityConfig(countryCode, configItemName, ArtistConfig.class);
        } catch (IOException e) {
            throw new IllegalArgumentException("Couldn't find an artist config for the provided item name: " + configItemName
                    + " and market: " + countryCode);
        }
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistType() {
        return artistType;
    }
}
