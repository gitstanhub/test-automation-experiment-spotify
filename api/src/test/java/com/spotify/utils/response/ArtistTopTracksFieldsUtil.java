package com.spotify.utils.response;

import com.spotify.models.response.artist.ArtistTopTracksResponseModel;

public class ArtistTopTracksFieldsUtil {

    public String getTrackName(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return artistTopTracksResponse.getTracks().get(trackPosition).getName();
    }

    public String getTrackId(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return artistTopTracksResponse.getTracks().get(trackPosition).getId();
    }

    public Integer getTrackDuration(ArtistTopTracksResponseModel artistTopTracksResponseModel, int trackPosition) {
        return artistTopTracksResponseModel.getTracks().get(trackPosition).getDuration_ms();
    }

    public String getTrackType(ArtistTopTracksResponseModel artistTopTracksResponseModel, int trackPosition) {
        return artistTopTracksResponseModel.getTracks().get(trackPosition).getType();
    }

    public String getTrackAlbumName(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return artistTopTracksResponse.getTracks().get(trackPosition).getAlbum().getName();
    }

    public String getTrackArtistName(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition, int artistPosition) {
        return artistTopTracksResponse.getTracks().get(trackPosition).getArtists().get(artistPosition).getName();
    }

    public Boolean getTrackExplicitStatus(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return artistTopTracksResponse.getTracks().get(trackPosition).getExplicit();
    }

}
