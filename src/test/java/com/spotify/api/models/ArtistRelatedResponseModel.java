package com.spotify.api.models;

import lombok.Data;

import java.util.List;

@Data
public class ArtistRelatedResponseModel {

    private List<ArtistDataResponseModel> artists;
}
