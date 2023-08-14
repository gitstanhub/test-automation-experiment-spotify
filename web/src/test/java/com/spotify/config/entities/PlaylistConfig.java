package com.spotify.config.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PlaylistConfig extends EntityConfig {

    private String playlistName;
    private String playlistDescription;
}
