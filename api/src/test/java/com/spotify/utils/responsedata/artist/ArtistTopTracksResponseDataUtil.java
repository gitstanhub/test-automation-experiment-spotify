package com.spotify.utils.responsedata.artist;

import com.spotify.models.response.artist.ArtistProfileResponseModel;
import com.spotify.models.response.artist.ArtistTopTracksResponseModel;

import java.util.NoSuchElementException;
import java.util.Optional;

public class ArtistTopTracksResponseDataUtil {

    public String getTrackNameFrom(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return getTrackFrom(artistTopTracksResponse, trackPosition).getName();
    }

    public String getTrackNameFrom(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        return getTrackFrom(artistTopTracksResponse, desiredTrackName).getName();
    }

    public String getTrackIdFrom(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return getTrackFrom(artistTopTracksResponse, trackPosition).getId();
    }

    public String getTrackIdFrom(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        return getTrackFrom(artistTopTracksResponse, desiredTrackName).getId();
    }

    public Integer getTrackDurationFrom(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return getTrackFrom(artistTopTracksResponse, trackPosition).getDurationMs();
    }

    public Integer getTrackDurationFrom(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        return getTrackFrom(artistTopTracksResponse, desiredTrackName).getDurationMs();
    }

    public String getTrackTypeFrom(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return getTrackFrom(artistTopTracksResponse, trackPosition).getType();
    }

    public String getTrackTypeFrom(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        return getTrackFrom(artistTopTracksResponse, desiredTrackName).getType();
    }

    public String getTrackAlbumNameFrom(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return getTrackFrom(artistTopTracksResponse, trackPosition).getAlbum().getName();
    }

    public String getTrackAlbumNameFrom(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        return getTrackFrom(artistTopTracksResponse, desiredTrackName).getAlbum().getName();
    }

    public String getTrackArtistNameFrom(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition, int artistPosition) {
        ArtistTopTracksResponseModel.Track desiredTrack = getTrackFrom(artistTopTracksResponse, trackPosition);
        return getTrackArtistFrom(desiredTrack, artistPosition).getName();
    }

    public String getTrackArtistNameFrom(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName, String desiredArtistName) {
        ArtistTopTracksResponseModel.Track desiredTrack = getTrackFrom(artistTopTracksResponse, desiredTrackName);
        return getTrackArtistFrom(desiredTrack, desiredArtistName).getName();
    }

    public String getTrackArtistNameFrom(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName, int artistPosition) {
        ArtistTopTracksResponseModel.Track desiredTrack = getTrackFrom(artistTopTracksResponse, desiredTrackName);
        return getTrackArtistFrom(desiredTrack, artistPosition).getName();
    }

    public Boolean getTrackExplicitStatusFrom(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return getTrackFrom(artistTopTracksResponse, trackPosition).getExplicit();
    }

    public Boolean getTrackExplicitStatusFrom(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        return getTrackFrom(artistTopTracksResponse, desiredTrackName).getExplicit();
    }

    private ArtistTopTracksResponseModel.Track getTrackFrom(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        if (trackPosition < 0 || trackPosition >= artistTopTracksResponse.getTracks().size()) {
            throw new IndexOutOfBoundsException("Track position is out of bounds. Please provide a track position between 0 and "
                    + artistTopTracksResponse.getTracks().size() + ".");
        }
        return artistTopTracksResponse.getTracks().get(trackPosition);
    }

    private ArtistTopTracksResponseModel.Track getTrackFrom(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        Optional<ArtistTopTracksResponseModel.Track> foundTrack = artistTopTracksResponse.getTracks().stream().filter(
                track -> desiredTrackName.equals(track.getName())).findFirst();
        if (foundTrack.isPresent()) {
            return foundTrack.get();
        } else {
            throw new NoSuchElementException("Track with the provided name is not found");
        }
    }

    private ArtistProfileResponseModel getTrackArtistFrom(ArtistTopTracksResponseModel.Track track, int desiredArtistPosition) {
        if (desiredArtistPosition < 0 || desiredArtistPosition >= track.getArtists().size()) {
            throw new IndexOutOfBoundsException("Artist position is out of bounds. Please provide an artist position between 0 and "
                    + track.getArtists().size() + ".");
        }
        return track.getArtists().get(desiredArtistPosition);
    }

    private ArtistProfileResponseModel getTrackArtistFrom(ArtistTopTracksResponseModel.Track track, String desiredArtistName) {
        Optional<ArtistProfileResponseModel> foundArtist = track.getArtists().stream().filter(
                artist -> desiredArtistName.equals(artist.getName())).findFirst();
        if (foundArtist.isPresent()) {
            return foundArtist.get();
        } else {
            throw new NoSuchElementException("Artist with the provided name is not found");
        }
    }
}
