package com.spotify.testdata.albums.assertions;

import com.spotify.testdata.commons.assertions.AssertionData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;

public class AlbumsAssertionData extends AssertionData {

    @Data
    @EqualsAndHashCode(callSuper = false)
    @AllArgsConstructor
    public static class ActualAlbumData extends ActualAssertionData {

        private final String actualAlbumName;
        private final String actualAlbumId;
        private final String actualAlbumArtistName;
        private final String actualAlbumType;
        private final Integer actualAlbumTotalTracks;
        private final String actualAlbumReleaseDate;

        @Override
        public List<Object> toList() {
            return Arrays.asList(
                    actualAlbumName,
                    actualAlbumId,
                    actualAlbumArtistName
            );
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    @AllArgsConstructor
    public static class ExpectedAlbumData extends ExpectedAssertionData {

        private final String expectedAlbumName;
        private final String expectedAlbumId;
        private final String expectedAlbumArtistName;
        private final String expectedAlbumType;
        private final Integer expectedAlbumTotalTracks;
        private final String expectedAlbumReleaseDate;

        @Override
        public List<Object> toList() {
            return Arrays.asList(
                    expectedAlbumName,
                    expectedAlbumId,
                    expectedAlbumArtistName
            );
        }
    }
}
