package com.spotify.utils.responsedata.artist;

import com.spotify.models.response.artist.ArtistProfileResponseModel;
import com.spotify.models.response.artist.ArtistRelatedResponseModel;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class RelatedArtistsResponseDataUtil {

    public String getRelatedArtistNameFrom(ArtistRelatedResponseModel artistRelatedResponse, String desiredArtistName) {
        return getRelatedArtistFrom(artistRelatedResponse, desiredArtistName).getName();
    }

    public String getRelatedArtistNameFrom(ArtistRelatedResponseModel artistRelatedResponse, int desiredArtistPosition) {
        return getRelatedArtistFrom(artistRelatedResponse, desiredArtistPosition).getName();
    }

    public List<String> getRelatedArtistGenresFrom(ArtistRelatedResponseModel artistRelatedResponse, String desiredArtistName) {
        return getRelatedArtistFrom(artistRelatedResponse, desiredArtistName).getGenres();
    }

    public String getRelatedArtistIdFrom(ArtistRelatedResponseModel artistRelatedResponse, String desiredArtistName) {
        return getRelatedArtistFrom(artistRelatedResponse, desiredArtistName).getId();
    }

    public String getRelatedArtistTypeFrom(ArtistRelatedResponseModel artistRelatedResponse, String desiredArtistName) {
        return getRelatedArtistFrom(artistRelatedResponse, desiredArtistName).getType();
    }

    public String getRelatedArtistUriFrom(ArtistRelatedResponseModel artistRelatedResponse, String desiredArtistName) {
        return getRelatedArtistFrom(artistRelatedResponse, desiredArtistName).getUri();
    }

    private ArtistProfileResponseModel getRelatedArtistFrom(ArtistRelatedResponseModel artistRelatedResponse, int desiredArtistPosition) {
        if (desiredArtistPosition < 0 || desiredArtistPosition >= artistRelatedResponse.getArtists().size()) {
            throw new IndexOutOfBoundsException("Related artist position is out of bounds. Please provide a position between 0 and "
                    + artistRelatedResponse.getArtists().size() + ".");
        }
        return artistRelatedResponse.getArtists().get(desiredArtistPosition);
    }

    private ArtistProfileResponseModel getRelatedArtistFrom(ArtistRelatedResponseModel artistRelatedResponse, String desiredArtistName) {
        Optional<ArtistProfileResponseModel> foundRelatedArtist = artistRelatedResponse.getArtists().stream().filter(
                relatedArtist -> desiredArtistName.equals(relatedArtist.getName())).findFirst();
        if (foundRelatedArtist.isPresent()) {
            return foundRelatedArtist.get();
        } else {
            throw new NoSuchElementException("Related artist with the provided name is not found");
        }
    }
}
