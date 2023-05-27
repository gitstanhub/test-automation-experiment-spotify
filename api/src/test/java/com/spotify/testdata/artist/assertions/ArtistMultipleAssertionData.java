package com.spotify.testdata.artist.assertions;

import com.spotify.testdata.commons.AssertionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

public class ArtistMultipleAssertionData extends AssertionData {

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class ActualMultipleArtistData extends ActualAssertionData {

        private final List<String> actualMultipleArtistNames;
        private final List<String> actualMultipleArtistGenres;
        private final List<String> actualMultipleAristIds;

        public ActualMultipleArtistData(List<String> actualMultipleArtistNames, List<String> actualMultipleArtistGenres, List<String> actualMultipleAristIds) {
            this.actualMultipleArtistNames = actualMultipleArtistNames;
            this.actualMultipleArtistGenres = actualMultipleArtistGenres;
            this.actualMultipleAristIds = actualMultipleAristIds;
        }

        public List<Object> toList() {
            List<Object> actualFieldList = new ArrayList<>();
            actualFieldList.add(this.getActualMultipleArtistNames());
            actualFieldList.add(this.getActualMultipleArtistGenres());
            actualFieldList.add(this.getActualMultipleAristIds());
            return actualFieldList;
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class ExpectedMultipleArtistData extends ExpectedAssertionData {

        private final List<String> expectedMultipleArtistNames;
        private final List<String> expectedMultipleArtistGenres;
        private final List<String> expectedMultipleArtistIds;

        public ExpectedMultipleArtistData(List<String> expectedMultipleArtistNames, List<String> expectedMultipleArtistGenres, List<String> expectedMultipleArtistIds) {
            this.expectedMultipleArtistNames = expectedMultipleArtistNames;
            this.expectedMultipleArtistGenres = expectedMultipleArtistGenres;
            this.expectedMultipleArtistIds = expectedMultipleArtistIds;
        }

        public List<Object> toList() {
            List<Object> expectedFieldList = new ArrayList<>();
            expectedFieldList.add(this.getExpectedMultipleArtistNames());
            expectedFieldList.add(this.getExpectedMultipleArtistGenres());
            expectedFieldList.add(this.getExpectedMultipleArtistIds());
            return expectedFieldList;
        }
    }
}
