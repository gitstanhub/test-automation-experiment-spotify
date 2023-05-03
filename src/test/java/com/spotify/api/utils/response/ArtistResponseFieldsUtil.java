package com.spotify.api.utils.response;

import com.spotify.api.models.response.artist.*;

public class ArtistResponseFieldsUtil {

    public String getArtistName(ArtistDataResponseModel artistDataResponse) {
        return artistDataResponse.getName();
    }

    public String getArtistName(ArtistMultipleResponseModel artistMultipleResponse, Integer artistPosition) {
        return artistMultipleResponse.getArtists().get(artistPosition).getName();
    }

    public String getTrackName(ArtistTopTracksResponseModel artistTopTracksResponse, Integer trackPosition) {
        return artistTopTracksResponse.getTracks().get(trackPosition).getName();
    }

    public String getArtistAlbumName(ArtistAlbumsResponseModel artistAlbumsResponse, Integer albumPosition) {
        return artistAlbumsResponse.getItems().get(albumPosition).getName();
    }

    public String getArtistRelated(ArtistRelatedResponseModel artistRelatedResponse, Integer relatedArtistPosition) {
        return artistRelatedResponse.getArtists().get(relatedArtistPosition).getName();
    }
}
