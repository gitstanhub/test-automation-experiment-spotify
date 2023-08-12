package com.spotify.config.appium.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class AlbumConfig extends EntityConfig {

    private List<String> albumArtists;
    private String albumName;
    private Integer albumReleaseYear;
    private String albumFullReleaseDate;
    private String albumType;
    private String albumCopyrightText;
}
