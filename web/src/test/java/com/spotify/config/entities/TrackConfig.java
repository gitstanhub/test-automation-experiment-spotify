package com.spotify.config.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class TrackConfig extends EntityConfig {

    private List<String> trackArtists;
    private String trackName;
}
