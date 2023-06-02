package com.spotify.testdata.artist.assertions;

import com.spotify.testdata.commons.AssertionData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

public class ArtistAlbumsAssertionData extends AssertionData {

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
            List<Object> actualFieldList = new ArrayList<>();
            actualFieldList.add(getActualAlbumName());
            actualFieldList.add(getActualAlbumId());
            actualFieldList.add(getActualAlbumArtistName());
            actualFieldList.add(getActualAlbumType());
            actualFieldList.add(getActualAlbumTotalTracks());
            actualFieldList.add(getActualAlbumReleaseDate());
            return actualFieldList;
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
            List<Object> expectedFieldList = new ArrayList<>();
            expectedFieldList.add(getExpectedAlbumName());
            expectedFieldList.add(getExpectedAlbumId());
            expectedFieldList.add(getExpectedAlbumArtistName());
            expectedFieldList.add(getExpectedAlbumType());
            expectedFieldList.add(getExpectedAlbumTotalTracks());
            expectedFieldList.add(getExpectedAlbumReleaseDate());
            return expectedFieldList;
        }
    }
}
