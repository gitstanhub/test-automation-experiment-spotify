package com.spotify.testdata.artist.assertions;

import com.spotify.testdata.commons.AssertionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

public class ArtistTracksAssertionData extends AssertionData {

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class ActualTracksData extends ActualAssertionData {

        private final String actualTrackName;
        private final String actualTrackId;
        private final Integer actualTrackDuration;
        private final String actualTrackType;
        private final String actualTrackAlbumName;
        private final String actualTrackArtistName;
        private final Boolean actualTrackExplicitStatus;

        public ActualTracksData(String actualTrackName, String trackId, Integer trackDuration, String trackType, String trackAlbumName, String trackArtistName, Boolean trackExplicitStatus) {
            this.actualTrackName = actualTrackName;
            this.actualTrackId = trackId;
            this.actualTrackDuration = trackDuration;
            this.actualTrackType = trackType;
            this.actualTrackAlbumName = trackAlbumName;
            this.actualTrackArtistName = trackArtistName;
            this.actualTrackExplicitStatus = trackExplicitStatus;
        }

        public List<Object> toList() {
            List<Object> actualFieldList = new ArrayList<>();
            actualFieldList.add(this.getActualTrackName());
            actualFieldList.add(this.getActualTrackId());
            actualFieldList.add(this.getActualTrackDuration());
            actualFieldList.add(this.getActualTrackType());
            actualFieldList.add(this.getActualTrackAlbumName());
            actualFieldList.add(this.getActualTrackArtistName());
            actualFieldList.add(this.getActualTrackExplicitStatus());
            return actualFieldList;
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class ExpectedTracksData extends ExpectedAssertionData {

        private final String expectedTrackName;
        private final String expectedTrackId;
        private final Integer expectedTrackDuration;
        private final String expectedTrackType;
        private final String expectedTrackAlbumName;
        private final String expectedTrackArtistName;
        private final Boolean expectedTrackExplicitStatus;

        public ExpectedTracksData(String expectedTrackName, String expectedTrackId, Integer expectedTrackDuration, String expectedTrackType, String expectedTrackAlbumName, String expectedTrackArtistName, Boolean expectedTrackExplicitStatus) {
            this.expectedTrackName = expectedTrackName;
            this.expectedTrackId = expectedTrackId;
            this.expectedTrackDuration = expectedTrackDuration;
            this.expectedTrackType = expectedTrackType;
            this.expectedTrackAlbumName = expectedTrackAlbumName;
            this.expectedTrackArtistName = expectedTrackArtistName;
            this.expectedTrackExplicitStatus = expectedTrackExplicitStatus;
        }

        public List<Object> toList() {
            List<Object> expectedFieldList = new ArrayList<>();
            expectedFieldList.add(this.getExpectedTrackName());
            expectedFieldList.add(this.getExpectedTrackId());
            expectedFieldList.add(this.getExpectedTrackDuration());
            expectedFieldList.add(this.getExpectedTrackType());
            expectedFieldList.add(this.getExpectedTrackAlbumName());
            expectedFieldList.add(this.getExpectedTrackArtistName());
            expectedFieldList.add(this.getExpectedTrackExplicitStatus());
            return expectedFieldList;
        }
    }
}
