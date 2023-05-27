package com.spotify.utils.responsefields.artist;

import com.spotify.models.response.artist.ArtistProfileResponseModel;
import com.spotify.models.response.artist.ArtistTopTracksResponseModel;

import java.util.NoSuchElementException;
import java.util.Optional;

public class ArtistTopTracksFieldsUtil {

    public String getTrackName(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return getTrack(artistTopTracksResponse, trackPosition).getName();
    }

    public String getTrackName(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        return getTrack(artistTopTracksResponse, desiredTrackName).getName();
    }

    public String getTrackId(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return getTrack(artistTopTracksResponse, trackPosition).getId();
    }

    public String getTrackId(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        return getTrack(artistTopTracksResponse, desiredTrackName).getId();
    }

    public Integer getTrackDuration(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return getTrack(artistTopTracksResponse, trackPosition).getDuration_ms();
    }

    public Integer getTrackDuration(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        return getTrack(artistTopTracksResponse, desiredTrackName).getDuration_ms();
    }

    public String getTrackType(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return getTrack(artistTopTracksResponse, trackPosition).getType();
    }

    public String getTrackType(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        return getTrack(artistTopTracksResponse, desiredTrackName).getType();
    }

    public String getTrackAlbumName(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return getTrack(artistTopTracksResponse, trackPosition).getAlbum().getName();
    }

    public String getTrackAlbumName(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        return getTrack(artistTopTracksResponse, desiredTrackName).getAlbum().getName();
    }

    public String getTrackArtistName(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition, int artistPosition) {
        ArtistTopTracksResponseModel.Track desiredTrack = getTrack(artistTopTracksResponse, trackPosition);
        return getTrackArtist(desiredTrack, artistPosition).getName();
    }

    public String getTrackArtistName(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName, String desiredArtistName) {
        ArtistTopTracksResponseModel.Track desiredTrack = getTrack(artistTopTracksResponse, desiredTrackName);
        return getTrackArtist(desiredTrack, desiredArtistName).getName();
    }

    public String getTrackArtistName(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName, int artistPosition) {
        ArtistTopTracksResponseModel.Track desiredTrack = getTrack(artistTopTracksResponse, desiredTrackName);
        return getTrackArtist(desiredTrack, artistPosition).getName();
    }

    public Boolean getTrackExplicitStatus(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        return getTrack(artistTopTracksResponse, trackPosition).getExplicit();
    }

    public Boolean getTrackExplicitStatus(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        return getTrack(artistTopTracksResponse, desiredTrackName).getExplicit();
    }

    private ArtistTopTracksResponseModel.Track getTrack(ArtistTopTracksResponseModel artistTopTracksResponse, int trackPosition) {
        if (trackPosition < 0 || trackPosition >= artistTopTracksResponse.getTracks().size()) {
            throw new IndexOutOfBoundsException("Track position is out of bounds. Please provide a track position between 0 and "
                    + artistTopTracksResponse.getTracks().size() + ".");
        }
        return artistTopTracksResponse.getTracks().get(trackPosition);
    }

    private ArtistTopTracksResponseModel.Track getTrack(ArtistTopTracksResponseModel artistTopTracksResponse, String desiredTrackName) {
        Optional<ArtistTopTracksResponseModel.Track> foundTrack = artistTopTracksResponse.getTracks().stream().filter(
                track -> desiredTrackName.equals(track.getName())).findFirst();
        if (foundTrack.isPresent()) {
            return foundTrack.get();
        } else {
            throw new NoSuchElementException("Track with the provided name is not found");
        }
    }

    private ArtistProfileResponseModel getTrackArtist(ArtistTopTracksResponseModel.Track track, int desiredArtistPosition) {
        if (desiredArtistPosition < 0 || desiredArtistPosition >= track.getArtists().size()) {
            throw new IndexOutOfBoundsException("Artist position is out of bounds. Please provide an artist position between 0 and "
                    + track.getArtists().size() + ".");
        }
        return track.getArtists().get(desiredArtistPosition);
    }

    private ArtistProfileResponseModel getTrackArtist(ArtistTopTracksResponseModel.Track track, String desiredArtistName) {
        Optional<ArtistProfileResponseModel> foundArtist = track.getArtists().stream().filter(
                artist -> desiredArtistName.equals(artist.getName())).findFirst();
        if (foundArtist.isPresent()) {
            return foundArtist.get();
        } else {
            throw new NoSuchElementException("Artist with the provided name is not found");
        }
    }
}
