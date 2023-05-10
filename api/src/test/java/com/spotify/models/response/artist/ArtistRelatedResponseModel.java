package com.spotify.models.response.artist;

import lombok.Data;

import java.util.List;

@Data
public class ArtistRelatedResponseModel {

    private List<ArtistDataResponseModel> artists;
}
