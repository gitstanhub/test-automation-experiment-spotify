package com.spotify.utils.responsefields.artist;

import com.spotify.models.response.artist.ArtistTopTracksResponseModel;

import java.util.NoSuchElementException;
import java.util.Optional;

public class ArtistTopTracksFieldsUtil {

    public String getTrackName(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        if (trackPosition < 0 || trackPosition >= artistTopTracksResponse.getTracks().size()) {
            throw new IndexOutOfBoundsException("Track position is out of bounds. Please provide a track position between 0 and "
                    + artistTopTracksResponse.getTracks().size() + ".");
        }
        return artistTopTracksResponse.getTracks().get(trackPosition).getName();
    }

    public String getTrackName(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        Optional<ArtistTopTracksResponseModel.Track> foundTrack = artistTopTracksResponse.getTracks().stream().filter(
                track -> desiredTrackName.equals(track.getName())).findFirst();
        if (foundTrack.isPresent()) {
            return foundTrack.get().getName();
        } else {
            throw new NoSuchElementException("Track with expected name is not found");
        }
    }

    public String getTrackId(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return artistTopTracksResponse.getTracks().get(trackPosition).getId();
    }

    public String getTrackId(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        return "test";
    }

    public Integer getTrackDuration(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return artistTopTracksResponse.getTracks().get(trackPosition).getDuration_ms();
    }

    public String getTrackType(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return artistTopTracksResponse.getTracks().get(trackPosition).getType();
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
