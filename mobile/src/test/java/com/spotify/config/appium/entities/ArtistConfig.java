package com.spotify.config.appium.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ArtistConfig extends EntityConfig {

    private String artistName;
    private String artistType;
}
