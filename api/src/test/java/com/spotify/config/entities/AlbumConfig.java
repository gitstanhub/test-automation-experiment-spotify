package com.spotify.config.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class AlbumConfig extends EntityConfig {

    private List<String> albumArtists;
    private String albumName;
    private String albumId;
    private Integer albumTotalTracks;
    private String albumReleaseDate;
    private String albumReleaseDatePrecision;
    private String albumType;
}
