package com.spotify.utils.responsefields.artist;

import com.spotify.models.response.artist.ArtistMultipleResponseModel;
import com.spotify.models.response.artist.ArtistProfileResponseModel;

import java.util.List;
import java.util.stream.Collectors;

public class MultipleArtistsResponseFieldsUtil {

    public List<String> getMultipleArtistsNames(ArtistMultipleResponseModel artistMultipleResponse) {
        return getMultipleArtists(artistMultipleResponse).stream().map(ArtistProfileResponseModel::getName).collect(Collectors.toList());
    }

    public List<String> getMultipleArtistGenres(ArtistMultipleResponseModel artistMultipleResponse) {
        return getMultipleArtists(artistMultipleResponse).stream().map(artist -> String.join(",", artist.getGenres())).collect(Collectors.toList());
    }

    public List<String> getMultipleArtistIds(ArtistMultipleResponseModel artistMultipleResponse) {
        return getMultipleArtists(artistMultipleResponse).stream().map(ArtistProfileResponseModel::getId).collect(Collectors.toList());
    }

    private List<ArtistProfileResponseModel> getMultipleArtists(ArtistMultipleResponseModel artistMultipleResponse) {
        return artistMultipleResponse.getArtists();
    }

}
