package com.spotify.api.models.response.playlist;

import com.spotify.api.models.response.commons.ApiCommonsResponseModel;
import lombok.Data;

@Data
public class PlaylistResponseModel {

    private Boolean collaborative;
    private String description;
    private ApiCommonsResponseModel.ExternalUrls external_urls;

}
