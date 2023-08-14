package com.spotify.config.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ArtistConfig extends EntityConfig {

    private String artistName;
    private List<String> artistGenres;
    private String artistId;
    private String artistType;
}
