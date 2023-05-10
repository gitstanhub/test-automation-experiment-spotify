package com.spotify.constants.search;

public enum SearchTypes {

    ALBUM("album"),
    ARTIST("artist"),
    PLAYLIST("playlist"),
    TRACK("track"),
    SHOW("show"),
    EPISODE("episode"),
    AUDIOBOOK("audiobook");

    private final String value;

    SearchTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
