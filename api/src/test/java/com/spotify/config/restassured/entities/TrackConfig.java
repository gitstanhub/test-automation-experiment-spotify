package com.spotify.config.restassured.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class TrackConfig extends EntityConfig{

    private List<String> trackArtists;
    private String trackName;
    private String trackId;
    private Integer trackDurationMs;
    private String trackType;
    private Boolean trackExplicit;
}
