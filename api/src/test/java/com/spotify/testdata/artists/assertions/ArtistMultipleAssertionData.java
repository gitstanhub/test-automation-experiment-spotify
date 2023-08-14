package com.spotify.testdata.artists.assertions;

import com.spotify.testdata.commons.assertions.AssertionData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;

public class ArtistMultipleAssertionData extends AssertionData {

    @Data
    @EqualsAndHashCode(callSuper = false)
    @AllArgsConstructor
    public static class ActualMultipleArtistData extends ActualAssertionData {

        private final List<String> actualMultipleArtistNames;
        private final List<String> actualMultipleArtistGenres;
        private final List<String> actualMultipleAristIds;

        @Override
        public List<Object> toList() {
            return Arrays.asList(
                    actualMultipleArtistNames,
                    actualMultipleArtistGenres,
                    actualMultipleAristIds
            );
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    @AllArgsConstructor
    public static class ExpectedMultipleArtistData extends ExpectedAssertionData {

        private final List<String> expectedMultipleArtistNames;
        private final List<String> expectedMultipleArtistGenres;
        private final List<String> expectedMultipleArtistIds;

        @Override
        public List<Object> toList() {
            return Arrays.asList(
                    expectedMultipleArtistNames,
                    expectedMultipleArtistGenres,
                    expectedMultipleArtistIds
            );
        }
    }
}
