package com.spotify.utils.responsedata.artist;

import com.spotify.models.response.artist.ArtistMultipleResponseModel;
import com.spotify.models.response.artist.ArtistProfileResponseModel;

import java.util.List;
import java.util.stream.Collectors;

public class MultipleArtistsResponseDataUtil {

    public List<String> getMultipleArtistsNamesFrom(ArtistMultipleResponseModel artistMultipleResponse) {
        return getMultipleArtistsFrom(artistMultipleResponse).stream().map(ArtistProfileResponseModel::getName).collect(Collectors.toList());
    }

    public List<String> getMultipleArtistGenresFrom(ArtistMultipleResponseModel artistMultipleResponse) {
        return getMultipleArtistsFrom(artistMultipleResponse).stream().map(artist -> String.join(",", artist.getGenres())).collect(Collectors.toList());
    }

    public List<String> getMultipleArtistIdsFrom(ArtistMultipleResponseModel artistMultipleResponse) {
        return getMultipleArtistsFrom(artistMultipleResponse).stream().map(ArtistProfileResponseModel::getId).collect(Collectors.toList());
    }

    private List<ArtistProfileResponseModel> getMultipleArtistsFrom(ArtistMultipleResponseModel artistMultipleResponse) {
        return artistMultipleResponse.getArtists();
    }

}
