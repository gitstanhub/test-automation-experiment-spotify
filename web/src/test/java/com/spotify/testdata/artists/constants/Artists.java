package com.spotify.testdata.artists.constants;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.config.ConfigProviderWeb;
import com.spotify.config.entities.ArtistConfig;

import java.io.IOException;

public enum Artists {
    ARTIST_1(
            getArtistConfig("artist_1").getArtistName()
    ),
    ARTIST_2(
            getArtistConfig("artist_2").getArtistName()
    );

    private final String artistName;

    Artists(String artistName) {
        this.artistName = artistName;
    }

    private static ArtistConfig getArtistConfig(String configItemName) {
        CountryCode countryCode = CountryCode.getByCode(ConfigProviderWeb.getWebAppConfiguration().countryCode());

        try {
            return ConfigProviderWeb.getEntityConfig(countryCode, configItemName, ArtistConfig.class);
        } catch (IOException e) {
            throw new IllegalArgumentException("Couldn't find an artist config for the provided item name: " + configItemName
                    + " and country: " + countryCode);
        }
    }

    public String getArtistName() {
        return artistName;
    }
}
