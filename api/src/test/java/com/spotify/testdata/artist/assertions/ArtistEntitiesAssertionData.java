package com.spotify.testdata.artist.assertions;

import com.spotify.testdata.commons.assertions.AssertionData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArtistEntitiesAssertionData extends AssertionData {

    @Data
    @EqualsAndHashCode(callSuper = false)
    @AllArgsConstructor
    public static class ActualArtistData extends ActualAssertionData {

        private final String actualArtistName;
        private final List<String> actualArtistGenres;
        private final String actualArtistId;
        private final String actualArtistType;
        private final String actualArtistUri;

        @Override
        public List<Object> toList() {
            return Arrays.asList(
                    actualArtistName,
                    actualArtistGenres,
                    actualArtistId
            );
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    @AllArgsConstructor
    public static class ExpectedArtistData extends ExpectedAssertionData {

        private final String expectedArtistName;
        private final List<String> expectedArtistGenres;
        private final String expectedArtistId;
        private final String expectedArtistType;
        private final String expectedArtistUri;

        @Override
        public List<Object> toList() {
            return Arrays.asList(
                    expectedArtistName,
                    expectedArtistGenres,
                    expectedArtistId
            );
        }
    }
}
