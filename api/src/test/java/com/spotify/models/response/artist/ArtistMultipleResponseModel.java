package com.spotify.models.response.artist;

import lombok.Data;

import java.util.List;

@Data
public class ArtistMultipleResponseModel {

    private List<ArtistProfileResponseModel> artists;
}
