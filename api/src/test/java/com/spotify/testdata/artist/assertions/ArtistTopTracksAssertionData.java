package com.spotify.testdata.artist.assertions;

import com.spotify.testdata.commons.AssertionData;

import java.util.ArrayList;
import java.util.List;

public class ArtistTopTracksAssertionData extends AssertionData {

    public static class ActualTopTracksData extends ActualAssertionData {

        private final String actualTrackId;
        private final Integer actualTrackDuration;
        private final String actualTrackType;
        private final String actualTrackAlbumName;
        private final String actualTrackArtistName;
        private final Boolean actualTrackExplicitStatus;

        public ActualTopTracksData(String trackId, Integer trackDuration, String trackType, String trackAlbumName, String trackArtistName, Boolean trackExplicitStatus) {
            this.actualTrackId = trackId;
            this.actualTrackDuration = trackDuration;
            this.actualTrackType = trackType;
            this.actualTrackAlbumName = trackAlbumName;
            this.actualTrackArtistName = trackArtistName;
            this.actualTrackExplicitStatus = trackExplicitStatus;
        }

        public List<Object> toList() {
            List<Object> actualFieldList = new ArrayList<>();
            actualFieldList.add(this.actualTrackId);
            actualFieldList.add(this.actualTrackDuration);
            actualFieldList.add(this.actualTrackType);
            actualFieldList.add(this.actualTrackAlbumName);
            actualFieldList.add(this.actualTrackArtistName);
            actualFieldList.add(this.actualTrackExplicitStatus);
            return actualFieldList;
        }
    }

    public static class ExpectedTopTracksData extends ExpectedAssertionData {

        private final String expectedTrackId;
        private final Integer expectedTrackDuration;
        private final String expectedTrackType;
        private final String expectedTrackAlbumName;
        private final String expectedTrackArtistName;
        private final Boolean expectedTrackExplicitStatus;

        public ExpectedTopTracksData(String expectedTrackId, Integer expectedTrackDuration, String expectedTrackType, String expectedTrackAlbumName, String expectedTrackArtistName, Boolean expectedTrackExplicitStatus) {
            this.expectedTrackId = expectedTrackId;
            this.expectedTrackDuration = expectedTrackDuration;
            this.expectedTrackType = expectedTrackType;
            this.expectedTrackAlbumName = expectedTrackAlbumName;
            this.expectedTrackArtistName = expectedTrackArtistName;
            this.expectedTrackExplicitStatus = expectedTrackExplicitStatus;
        }

        public List<Object> toList() {
            List<Object> actualFieldList = new ArrayList<>();
            actualFieldList.add(this.expectedTrackId);
            actualFieldList.add(this.expectedTrackDuration);
            actualFieldList.add(this.expectedTrackType);
            actualFieldList.add(this.expectedTrackAlbumName);
            actualFieldList.add(this.expectedTrackArtistName);
            actualFieldList.add(this.expectedTrackExplicitStatus);
            return actualFieldList;
        }
    }
}
