package com.spotify.utils.responsedata.artist;

import com.spotify.models.response.artist.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
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
