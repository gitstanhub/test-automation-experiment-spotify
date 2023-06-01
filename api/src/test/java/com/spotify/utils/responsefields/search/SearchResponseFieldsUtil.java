package com.spotify.utils.responsefields.search;

import com.spotify.models.response.artist.ArtistAlbumsResponseModel;
import com.spotify.models.response.search.SearchResponseModel;

import java.util.List;

public class SearchResponseFieldsUtil {

    public List<String> getAlbumTypes(SearchResponseModel searchResponse) {

    }

    public Integer getPaginationDataOffset(SearchResponseModel searchResponse, String objectType) {
        return switch (objectType) {
            case("albums") -> getAlbumsPage(searchResponse).getOffset();
            case("artists") -> getArtists(searchResponse).getOffset();
            case("playlists") -> getPlaylists(searchResponse).getOffset();
            default -> throw new IllegalArgumentException("Wrong type of response JSON object is specified. Please choose between: albums, artists, playlists");
        };
    }

    public Integer getPaginationDataLimit(SearchResponseModel searchResponseModel, String objectType) {
        return switch (objectType) {
            case ("albums") -> getAlbumsPage(searchResponseModel).getLimit();
            case ("artists") -> getArtists(searchResponseModel).getLimit();
            case ("playlists") -> getPlaylists(searchResponseModel).getLimit();
            default -> throw new IllegalArgumentException("Wrong type of response JSON object is specified. Please choose between: albums, artists, playlists");
        };
    }

    private SearchResponseModel.Playlists getPlaylists(SearchResponseModel searchResponse) {
        return searchResponse.getPlaylists();
    }

    private SearchResponseModel.Artists getArtists(SearchResponseModel searchResponse) {
        return searchResponse.getArtists();
    }

    private SearchResponseModel.Albums getAlbumsPage(SearchResponseModel searchResponse) {
        return searchResponse.getAlbums();
    }
}
