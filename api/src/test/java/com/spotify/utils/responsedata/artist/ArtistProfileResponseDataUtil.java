package com.spotify.utils.responsedata.artist;

import com.spotify.models.response.artist.*;

import java.util.List;

public class ArtistProfileResponseDataUtil {

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

}
