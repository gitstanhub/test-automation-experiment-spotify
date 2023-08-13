package com.spotify.utils.responsedata.artist;

import com.spotify.models.response.artist.*;

import java.util.List;

public class ArtistProfileResponseDataUtil {

    public String getArtistNameFrom(ArtistProfileResponseModel artistDataResponse) {
        return artistDataResponse.getName();
    }

    public String getArtistTypeFrom(ArtistProfileResponseModel artistDataResponse) {
        return artistDataResponse.getType();
    }

    public String getArtistUriFrom(ArtistProfileResponseModel artistDataResponse) {
        return artistDataResponse.getUri();
    }

    public List<String> getArtistGenresFrom(ArtistProfileResponseModel artistDataResponse) {
        return artistDataResponse.getGenres();
    }

    public String getArtistIdFrom(ArtistProfileResponseModel artistDataResponse) {
        return artistDataResponse.getId();
    }

}
