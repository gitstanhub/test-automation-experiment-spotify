package com.spotify.testdata.artists.constants;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.config.ConfigProviderApi;
import com.spotify.config.entities.ArtistConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public enum Artists {
    ARTIST_1(
            getArtistConfig("artist_1").getArtistName(),
            getArtistConfig("artist_1").getArtistId(),
            getArtistConfig("artist_1").getArtistGenres(),
            getArtistConfig("artist_1").getArtistType()
    ),
    ARTIST_2(
            getArtistConfig("artist_2").getArtistName(),
            getArtistConfig("artist_2").getArtistId(),
            getArtistConfig("artist_2").getArtistGenres(),
            getArtistConfig("artist_2").getArtistType()
    ),
    ARTIST_3(
            getArtistConfig("artist_3").getArtistName(),
            getArtistConfig("artist_3").getArtistId(),
            getArtistConfig("artist_3").getArtistGenres(),
            getArtistConfig("artist_3").getArtistType()
    );

    private final String artistName;
    private final List<String> artistGenres;
    private final String artistId;
    private final String artistType;

    Artists(String artistName, String artistId, List<String> artistGenres, String artistType) {
        this.artistName = artistName;
        this.artistGenres = artistGenres;
        this.artistId = artistId;
        this.artistType = artistType;
    }

    private static ArtistConfig getArtistConfig(String configItemName) {
        CountryCode countryCode = CountryCode.getByCode(ConfigProviderApi.getRestAssuredApiConfiguration().countryCode());

        try {
            return ConfigProviderApi.getEntityConfig(countryCode, configItemName, ArtistConfig.class);
        } catch (IOException e) {
            throw new IllegalArgumentException("Couldn't find an artist config for the provided item name: " + configItemName
                    + " and country: " + countryCode);
        }
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

    public static List<String> getMultipleArtistIds(List<Artists> multipleArtists) {
        List<String> multipleArtistIds = new ArrayList<>();
        for (Artists artistEntity : multipleArtists) {
            multipleArtistIds.add(artistEntity.getArtistId());
        }
        return multipleArtistIds;
    }

    public static List<String> getMultipleArtistNames(List<Artists> multipleArtists) {
        List<String> multipleArtistNames = new ArrayList<>();
        for (Artists artistEntity : multipleArtists) {
            multipleArtistNames.add(artistEntity.getArtistName());
        }
        return multipleArtistNames;
    }

    public static List<String> getMultipleArtistGenres(List<Artists> multipleArtists) {
        List<String> multipleArtistGenres = new ArrayList<>();
        for (Artists artistEntity : multipleArtists) {
            multipleArtistGenres.add(String.join(",", artistEntity.getArtistGenres()));
        }
        return multipleArtistGenres;
    }
}
