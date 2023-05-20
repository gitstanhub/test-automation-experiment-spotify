package com.spotify.testdata.artist.assertions;

import com.spotify.testdata.commons.AssertionData;

import java.util.ArrayList;
import java.util.List;

public class ArtistAssertionData extends AssertionData {

    public static class ActualArtistData extends ActualAssertionData {

        private final String actualArtistName;
        private final List<String> actualArtistGenres;
        private final String actualArtistId;
        private final String actualArtistType;
        private final String actualArtistUri;

        public ActualArtistData(String actualArtistName, List<String> actualArtistGenres, String actualArtistId, String actualArtistType, String actualArtistUri) {
            this.actualArtistName = actualArtistName;
            this.actualArtistGenres = actualArtistGenres;
            this.actualArtistId = actualArtistId;
            this.actualArtistType = actualArtistType;
            this.actualArtistUri = actualArtistUri;
        }

        public String getActualArtistName() {
            return actualArtistName;
        }

        public List<String> getActualArtistGenres() {
            return actualArtistGenres;
        }

        public String getActualArtistId() {
            return actualArtistId;
        }

        public String getActualArtistType() {
            return actualArtistType;
        }

        public String getActualArtistUri() {
            return actualArtistUri;
        }

        public List<Object> toList() {
            List<Object> actualFieldsList = new ArrayList<>();
            actualFieldsList.add(this.getActualArtistName());
            actualFieldsList.add(this.getActualArtistGenres());
            actualFieldsList.add(this.getActualArtistId());
            actualFieldsList.add(this.getActualArtistType());
            actualFieldsList.add(this.getActualArtistUri());
            return actualFieldsList;
        }
    }

    public static class ExpectedArtistData extends ExpectedAssertionData {

        private final String expectedArtistName;
        private final List<String> expectedArtistGenres;
        private final String expectedArtistId;
        private final String expectedArtistType;
        private final String expectedArtistUri;

        public ExpectedArtistData(String expectedArtistName, List<String> expectedArtistGenres, String expectedArtistId, String expectedArtistType, String expectedArtistUri) {
            this.expectedArtistName = expectedArtistName;
            this.expectedArtistGenres = expectedArtistGenres;
            this.expectedArtistId = expectedArtistId;
            this.expectedArtistType = expectedArtistType;
            this.expectedArtistUri = expectedArtistUri;
        }

        public String getExpectedArtistName() {
            return expectedArtistName;
        }

        public List<String> getExpectedArtistGenres() {
            return expectedArtistGenres;
        }

        public String getExpectedArtistId() {
            return expectedArtistId;
        }

        public String getExpectedArtistType() {
            return expectedArtistType;
        }

        public String getExpectedArtistUri() {
            return expectedArtistUri;
        }

        public List<Object> toList() {
            List<Object> expectedFieldsList = new ArrayList<>();
            expectedFieldsList.add(this.getExpectedArtistName());
            expectedFieldsList.add(this.getExpectedArtistGenres());
            expectedFieldsList.add(this.getExpectedArtistId());
            expectedFieldsList.add(this.getExpectedArtistType());
            expectedFieldsList.add(this.getExpectedArtistUri());
            return expectedFieldsList;
        }
    }
}
