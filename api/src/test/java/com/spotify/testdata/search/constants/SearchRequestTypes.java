package com.spotify.testdata.search.constants;

public enum SearchRequestTypes {

    ALBUM("album"),
    ARTIST("artist"),
    PLAYLIST("playlist"),
    TRACK("track"),
    SHOW("show"),
    EPISODE("episode"),
    AUDIOBOOK("audiobook");

    private final String value;

    SearchRequestTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
