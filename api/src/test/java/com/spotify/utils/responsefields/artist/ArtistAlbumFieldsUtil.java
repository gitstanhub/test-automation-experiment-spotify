package com.spotify.utils.responsefields.artist;

import com.spotify.models.response.artist.ArtistAlbumsResponseModel;
import com.spotify.models.response.artist.ArtistProfileResponseModel;
import com.spotify.models.response.artist.ArtistTopTracksResponseModel;

import java.util.NoSuchElementException;
import java.util.Optional;

public class ArtistAlbumFieldsUtil {

    public String getAlbumName(ArtistAlbumsResponseModel artistAlbumsResponse, String desiredAlbumName) {
        return getAlbum(artistAlbumsResponse, desiredAlbumName).getName();
    }

    public String getAlbumId(ArtistAlbumsResponseModel artistAlbumsResponse, String desiredAlbumName) {
        return getAlbum(artistAlbumsResponse, desiredAlbumName).getId();
    }

    public String getAlbumArtistName(ArtistAlbumsResponseModel artistAlbumsResponse, String desiredAlbumName, int desiredArtistPosition) {
        ArtistAlbumsResponseModel.Item desiredAlbum = getAlbum(artistAlbumsResponse, desiredAlbumName);
        return getAlbumArtist(desiredAlbum, desiredArtistPosition).getName();
    }

    public String getAlbumType(ArtistAlbumsResponseModel artistAlbumsResponse, String desiredAlbumName) {
        return getAlbum(artistAlbumsResponse, desiredAlbumName).getAlbum_type();
    }

    public Integer getAlbumTotalTracks(ArtistAlbumsResponseModel artistAlbumsResponse, String desiredAlbumName) {
        return getAlbum(artistAlbumsResponse, desiredAlbumName).getTotal_tracks();
    }

    public String getAlbumReleaseDate(ArtistAlbumsResponseModel artistAlbumsResponse, String desiredAlbumName) {
        return getAlbum(artistAlbumsResponse, desiredAlbumName).getRelease_date();
    }

    private ArtistAlbumsResponseModel.Item getAlbum(ArtistAlbumsResponseModel artistAlbumsResponse, String desiredAlbumName) {
        Optional<ArtistAlbumsResponseModel.Item> foundAlbum = artistAlbumsResponse.getItems().stream().filter(
                item -> desiredAlbumName.equals(item.getName())).findFirst();
        if (foundAlbum.isPresent()) {
            return foundAlbum.get();
        } else {
            throw new NoSuchElementException("Album with the provided name is not found");
        }
    }

    private ArtistProfileResponseModel getAlbumArtist(ArtistAlbumsResponseModel.Item album, String desiredArtistName) {
        Optional<ArtistProfileResponseModel> foundArtist = album.getArtists().stream().filter(
                artist -> desiredArtistName.equals(artist.getName())).findFirst();
        if (foundArtist.isPresent()) {
            return foundArtist.get();
        } else {
            throw new NoSuchElementException("Artist with the provided name is not found");
        }
    }

    private ArtistProfileResponseModel getAlbumArtist(ArtistAlbumsResponseModel.Item album, int desiredArtisPosition) {
        if (desiredArtisPosition < 0 || desiredArtisPosition >= album.getArtists().size()) {
            throw new IndexOutOfBoundsException("Artist position is out of bounds. Please provide an artist position between 0 and "
                    + album.getArtists().size() + ".");
        }
        return album.getArtists().get(desiredArtisPosition);
    }

}
