package com.spotify.utils.responsefields.artist;

import com.spotify.models.response.artist.ArtistProfileResponseModel;
import com.spotify.models.response.artist.ArtistRelatedResponseModel;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class RelatedArtistsResponseFieldsUtil {

    public String getRelatedArtistName(ArtistRelatedResponseModel artistRelatedResponse, String desiredArtistName) {
        return getRelatedArtist(artistRelatedResponse, desiredArtistName).getName();
    }

    public String getRelatedArtistName(ArtistRelatedResponseModel artistRelatedResponse, int desiredArtistPosition) {
        return getRelatedArtist(artistRelatedResponse, desiredArtistPosition).getName();
    }

    public List<String> getRelatedArtistGenres(ArtistRelatedResponseModel artistRelatedResponse, String desiredArtistName) {
        return getRelatedArtist(artistRelatedResponse, desiredArtistName).getGenres();
    }

    public String getRelatedArtistId(ArtistRelatedResponseModel artistRelatedResponse, String desiredArtistName) {
        return getRelatedArtist(artistRelatedResponse, desiredArtistName).getId();
    }

    public String getRelatedArtistType(ArtistRelatedResponseModel artistRelatedResponse, String desiredArtistName) {
        return getRelatedArtist(artistRelatedResponse, desiredArtistName).getType();
    }

    public String getRelatedArtistUri(ArtistRelatedResponseModel artistRelatedResponse, String desiredArtistName) {
        return getRelatedArtist(artistRelatedResponse, desiredArtistName).getUri();
    }

    private ArtistProfileResponseModel getRelatedArtist(ArtistRelatedResponseModel artistRelatedResponse, int desiredArtistPosition) {
        if (desiredArtistPosition < 0 || desiredArtistPosition >= artistRelatedResponse.getArtists().size()) {
            throw new IndexOutOfBoundsException("Related artist position is out of bounds. Please provide a position between 0 and "
                    + artistRelatedResponse.getArtists().size() + ".");
        }
        return artistRelatedResponse.getArtists().get(desiredArtistPosition);
    }

    private ArtistProfileResponseModel getRelatedArtist(ArtistRelatedResponseModel artistRelatedResponse, String desiredArtistName) {
        Optional<ArtistProfileResponseModel> foundRelatedArtist = artistRelatedResponse.getArtists().stream().filter(
                relatedArtist -> desiredArtistName.equals(relatedArtist.getName())).findFirst();
        if (foundRelatedArtist.isPresent()) {
            return foundRelatedArtist.get();
        } else {
            throw new NoSuchElementException("Related artist with the provided name is not found");
        }
    }
}
