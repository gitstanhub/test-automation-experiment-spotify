package com.spotify.config.appium.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PlaylistConfig extends EntityConfig {

    private String playlistName;
    private String playlistAuthor;
    private String playlistType;
}
