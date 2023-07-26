package com.spotify.testdata.artist.assertions;

import com.spotify.testdata.commons.assertions.AssertionData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;

public class ArtistTracksAssertionData extends AssertionData {

    @Data
    @EqualsAndHashCode(callSuper = false)
    @AllArgsConstructor
    public static class ActualTracksData extends ActualAssertionData {

        private final String actualTrackName;
        private final String actualTrackId;
        private final Integer actualTrackDuration;
        private final String actualTrackType;
        private final String actualTrackAlbumName;
        private final String actualTrackArtistName;
        private final Boolean actualTrackExplicitStatus;

        @Override
        public List<Object> toList() {
            return Arrays.asList(
                    actualTrackName,
                    actualTrackId,
                    actualTrackDuration,
                    actualTrackType,
                    actualTrackAlbumName,
                    actualTrackArtistName,
                    actualTrackExplicitStatus
            );
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    @AllArgsConstructor
    public static class ExpectedTracksData extends ExpectedAssertionData {

        private final String expectedTrackName;
        private final String expectedTrackId;
        private final Integer expectedTrackDuration;
        private final String expectedTrackType;
        private final String expectedTrackAlbumName;
        private final String expectedTrackArtistName;
        private final Boolean expectedTrackExplicitStatus;

        @Override
        public List<Object> toList() {
            return Arrays.asList(
                    expectedTrackName,
                    expectedTrackId,
                    expectedTrackDuration,
                    expectedTrackType,
                    expectedTrackAlbumName,
                    expectedTrackArtistName,
                    expectedTrackExplicitStatus
            );
        }
    }
}
