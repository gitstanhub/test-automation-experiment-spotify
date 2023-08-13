package com.spotify.tests.base;

import com.spotify.config.SpringConfigApi;
import com.spotify.utils.assertions.ApiAssertionsUtil;
import com.spotify.utils.requestdata.search.SearchRequestDataUtil;
import com.spotify.utils.responsedata.artist.*;
import com.spotify.utils.responsedata.search.SearchResponseDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfigApi.class)
@Slf4j
public abstract class ApiTests {

    @Autowired
    protected ApiAssertionsUtil apiAssertionsUtil;

    @Autowired
    protected ArtistProfileResponseDataUtil artistProfileResponseDataUtil;

    @Autowired
    protected ArtistTopTracksResponseDataUtil artistTopTracksResponseDataUtil;

    @Autowired
    protected ArtistAlbumResponseDataUtil artistAlbumResponseDataUtil;

    @Autowired
    protected RelatedArtistsResponseDataUtil relatedArtistsResponseDataUtil;

    @Autowired
    protected MultipleArtistsResponseDataUtil multipleArtistsResponseDataUtil;

    @Autowired
    protected SearchRequestDataUtil searchRequestDataUtil;

    @Autowired
    protected SearchResponseDataUtil searchResponseDataUtil;
}
