package com.spotify.utils.response;

import com.spotify.models.response.artist.*;
import com.spotify.models.response.commons.ApiCommonsResponseModel;

import java.util.List;

public class ArtistResponseFieldsUtil {

    //ArtistDataResponseModel
    public String getArtistName(ArtistDataResponseModel artistDataResponse) {
        return artistDataResponse.getName();
    }

    public String getArtistType(ArtistDataResponseModel artistDataResponse) {
        return artistDataResponse.getType();
    }

    public String getArtistUri(ArtistDataResponseModel artistDataResponse) {
        return artistDataResponse.getUri();
    }

    public List<String> getArtistGenres(ArtistDataResponseModel artistDataResponse) {
        return artistDataResponse.getGenres();
    }

    public String getArtistId(ArtistDataResponseModel artistDataResponse) {
        return artistDataResponse.getId();
    }

    public ApiCommonsResponseModel.Images getArtistImage(ArtistDataResponseModel artistDataResponse, int imagePosition) {
        return artistDataResponse.getImages().get(imagePosition);
    }


    //ArtistMultipleResponseModel
    public String getArtistName(ArtistMultipleResponseModel artistMultipleResponse, int artistPosition) {
        return artistMultipleResponse.getArtists().get(artistPosition).getName();
    }


    //ArtistTopTracksResponseModel
    public String getTrackName(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return artistTopTracksResponse.getTracks().get(trackPosition).getName();
    }


    //ArtistAlbumsResponseModel
    public String getArtistAlbumName(ArtistAlbumsResponseModel artistAlbumsResponse, int albumPosition) {
        return artistAlbumsResponse.getItems().get(albumPosition).getName();
    }


    //ArtistRelatedResponseModel
    public String getArtistRelated(ArtistRelatedResponseModel artistRelatedResponse, int relatedArtistPosition) {
        return artistRelatedResponse.getArtists().get(relatedArtistPosition).getName();
    }
}
