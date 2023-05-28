package com.spotify.utils.responsefields.artist;

import com.spotify.models.response.artist.*;
import com.spotify.models.response.commons.ApiCommonsResponseModel;

import java.util.List;

public class ArtistProfileFieldsUtil {

    public String getArtistName(ArtistProfileResponseModel artistDataResponse) {
        return artistDataResponse.getName();
    }

    public String getArtistType(ArtistProfileResponseModel artistDataResponse) {
        return artistDataResponse.getType();
    }

    public String getArtistUri(ArtistProfileResponseModel artistDataResponse) {
        return artistDataResponse.getUri();
    }

    public List<String> getArtistGenres(ArtistProfileResponseModel artistDataResponse) {
        return artistDataResponse.getGenres();
    }

    public String getArtistId(ArtistProfileResponseModel artistDataResponse) {
        return artistDataResponse.getId();
    }




    //ArtistMultipleResponseModel
    public String getArtistName(ArtistMultipleResponseModel artistMultipleResponse, int artistPosition) {
        return artistMultipleResponse.getArtists().get(artistPosition).getName();
    }

    //ArtistRelatedResponseModel
    public String getArtistRelated(ArtistRelatedResponseModel artistRelatedResponse, int relatedArtistPosition) {
        return artistRelatedResponse.getArtists().get(relatedArtistPosition).getName();
    }
}
