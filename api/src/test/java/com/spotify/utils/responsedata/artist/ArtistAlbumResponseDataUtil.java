package com.spotify.utils.responsedata.artist;

import com.spotify.models.response.artist.ArtistAlbumsResponseModel;
import com.spotify.models.response.artist.ArtistProfileResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class ArtistAlbumResponseDataUtil {

    public String getAlbumNameFrom(ArtistAlbumsResponseModel artistAlbumsResponse, String desiredAlbumName) {
        return getAlbumFrom(artistAlbumsResponse, desiredAlbumName).getName();
    }

    public String getAlbumIdFrom(ArtistAlbumsResponseModel artistAlbumsResponse, String desiredAlbumName) {
        return getAlbumFrom(artistAlbumsResponse, desiredAlbumName).getId();
    }

    public String getAlbumArtistNameFrom(ArtistAlbumsResponseModel artistAlbumsResponse, String desiredAlbumName, int desiredArtistPosition) {
        ArtistAlbumsResponseModel.Item desiredAlbum = getAlbumFrom(artistAlbumsResponse, desiredAlbumName);
        return getAlbumArtistFrom(desiredAlbum, desiredArtistPosition).getName();
    }

    public String getAlbumTypeFrom(ArtistAlbumsResponseModel artistAlbumsResponse, String desiredAlbumName) {
        return getAlbumFrom(artistAlbumsResponse, desiredAlbumName).getAlbumType();
    }

    public Integer getAlbumTotalTracksFrom(ArtistAlbumsResponseModel artistAlbumsResponse, String desiredAlbumName) {
        return getAlbumFrom(artistAlbumsResponse, desiredAlbumName).getTotalTracks();
    }

    public String getAlbumReleaseDateFrom(ArtistAlbumsResponseModel artistAlbumsResponse, String desiredAlbumName) {
        return getAlbumFrom(artistAlbumsResponse, desiredAlbumName).getReleaseDate();
    }

    private ArtistAlbumsResponseModel.Item getAlbumFrom(ArtistAlbumsResponseModel artistAlbumsResponse, String desiredAlbumName) {
        Optional<ArtistAlbumsResponseModel.Item> foundAlbum = artistAlbumsResponse.getItems().stream().filter(
                item -> desiredAlbumName.equals(item.getName())).findFirst();
        if (foundAlbum.isPresent()) {
            return foundAlbum.get();
        } else {
            throw new IllegalArgumentException("Album with the provided name is not found");
        }
    }

    private ArtistProfileResponseModel getAlbumArtistFrom(ArtistAlbumsResponseModel.Item album, String desiredArtistName) {
        Optional<ArtistProfileResponseModel> foundArtist = album.getArtists().stream().filter(
                artist -> desiredArtistName.equals(artist.getName())).findFirst();
        if (foundArtist.isPresent()) {
            return foundArtist.get();
        } else {
            throw new IllegalArgumentException("Artist with the provided name is not found");
        }
    }

    private ArtistProfileResponseModel getAlbumArtistFrom(ArtistAlbumsResponseModel.Item album, int desiredArtisPosition) {
        if (desiredArtisPosition < 0 || desiredArtisPosition >= album.getArtists().size()) {
            throw new IndexOutOfBoundsException("Artist position is out of bounds. Please provide an artist position between 0 and "
                    + album.getArtists().size() + ".");
        }
        return album.getArtists().get(desiredArtisPosition);
    }
}
