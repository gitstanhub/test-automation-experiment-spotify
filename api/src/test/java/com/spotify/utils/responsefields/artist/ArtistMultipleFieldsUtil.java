package com.spotify.utils.responsefields.artist;

import com.spotify.models.response.artist.ArtistMultipleResponseModel;
import com.spotify.models.response.artist.ArtistProfileResponseModel;
import com.spotify.models.response.artist.ArtistRelatedResponseModel;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArtistMultipleFieldsUtil {

    public List<String> getMultipleArtistsNames(ArtistMultipleResponseModel artistMultipleResponse) {
        return getArtists(artistMultipleResponse).stream().map(ArtistProfileResponseModel::getName).collect(Collectors.toList());
    }

    public List<List<String>> getArtistGenres(ArtistMultipleResponseModel artistMultipleResponse) {
        return getArtists(artistMultipleResponse).stream().map(ArtistProfileResponseModel::getGenres).collect(Collectors.toList());
    }

    public List<String> getArtistId(ArtistMultipleResponseModel artistMultipleResponse) {
        return getArtists(artistMultipleResponse).stream().map(ArtistProfileResponseModel::getId).collect(Collectors.toList());
    }

    private List<ArtistProfileResponseModel> getArtists(ArtistMultipleResponseModel artistMultipleResponse) {
        return artistMultipleResponse.getArtists();
    }

}
