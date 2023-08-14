package com.spotify.utils.responsedata.search;

import com.spotify.models.response.artist.ArtistAlbumsResponseModel;
import com.spotify.models.response.artist.ArtistProfileResponseModel;
import com.spotify.models.response.playlist.PlaylistResponseModel;
import com.spotify.models.response.search.SearchResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class SearchResponseDataUtil {

    public Integer getItemsCountFrom(SearchResponseModel searchResponse, String objectType) {
        return switch (objectType) {
            case ("albums") -> getAlbumsPageFrom(searchResponse).getItems().size();
            case ("artists") -> getArtistsFrom(searchResponse).getItems().size();
            case ("playlists") -> getPlaylistsFrom(searchResponse).getItems().size();
            default ->
                    throw new IllegalArgumentException("Wrong type of response JSON object is specified. Please choose between: albums, artists, playlists");
        };
    }

    public List<String> getAllPlaylistsTypesFrom(SearchResponseModel searchResponse) {
        return getPlaylistsFrom(searchResponse).getItems().stream().map(PlaylistResponseModel::getType).collect(Collectors.toList());
    }

    public List<String> getAllArtistsTypesFrom(SearchResponseModel searchResponse) {
        return getArtistsFrom(searchResponse).getItems().stream().map(ArtistProfileResponseModel::getType).collect(Collectors.toList());
    }

    public List<String> getAllAlbumsArtistsNamesFrom(SearchResponseModel searchResponse) {
        return getAlbumsPageFrom(searchResponse).getItems().stream()
                .flatMap(item -> item.getArtists().stream())
                .map(ArtistProfileResponseModel::getName)
                .collect(Collectors.toList());
    }

    public List<String> getAllAlbumsTypesFrom(SearchResponseModel searchResponse) {
        return getAlbumsPageFrom(searchResponse).getItems().stream().map(ArtistAlbumsResponseModel.Item::getAlbumType).collect(Collectors.toList());
    }

    public Integer getPaginationDataOffsetFrom(SearchResponseModel searchResponse, String objectType) {
        return switch (objectType) {
            case ("albums") -> getAlbumsPageFrom(searchResponse).getOffset();
            case ("artists") -> getArtistsFrom(searchResponse).getOffset();
            case ("playlists") -> getPlaylistsFrom(searchResponse).getOffset();
            default ->
                    throw new IllegalArgumentException("Wrong type of response JSON object is specified. Please choose between: albums, artists, playlists");
        };
    }

    public Integer getPaginationDataLimitFrom(SearchResponseModel searchResponseModel, String objectType) {
        return switch (objectType) {
            case ("albums") -> getAlbumsPageFrom(searchResponseModel).getLimit();
            case ("artists") -> getArtistsFrom(searchResponseModel).getLimit();
            case ("playlists") -> getPlaylistsFrom(searchResponseModel).getLimit();
            default ->
                    throw new IllegalArgumentException("Wrong type of response JSON object is specified. Please choose between: albums, artists, playlists");
        };
    }

    private SearchResponseModel.Playlists getPlaylistsFrom(SearchResponseModel searchResponse) {
        return searchResponse.getPlaylists();
    }

    private SearchResponseModel.Artists getArtistsFrom(SearchResponseModel searchResponse) {
        return searchResponse.getArtists();
    }

    private SearchResponseModel.Albums getAlbumsPageFrom(SearchResponseModel searchResponse) {
        return searchResponse.getAlbums();
    }
}
