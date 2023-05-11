package com.spotify.tests;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.clients.ArtistClient;
import com.spotify.models.response.artist.*;
import com.spotify.utils.ApiAssertionsUtil;
import com.spotify.utils.response.ArtistResponseFieldsUtil;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.spotify.testdata.artist.ArtistProfileTestData.*;

public class ArtistTests {

    ArtistClient artistClient = new ArtistClient();
    ApiAssertionsUtil apiAssertionsUtil = new ApiAssertionsUtil();
    ArtistResponseFieldsUtil artistResponseFieldsUtil = new ArtistResponseFieldsUtil();

    @Test
    void artistProfileTest() {

        String countryCode = String.valueOf(CountryCode.DE);

        ArtistDataResponseModel artistData = artistClient.getArtistData(ARTIST_ID);
        ArtistTopTracksResponseModel artistTopTracks = artistClient.getArtistTopTracks(countryCode, ARTIST_ID);
        ArtistAlbumsResponseModel artistAlbums = artistClient.getArtistAlbums(countryCode, ARTIST_ID);
        ArtistRelatedResponseModel artistRelated = artistClient.getRelatedArtists(ARTIST_ID);

        Map<Object, Object> artistDataValidationPairs = Map.of(
                artistResponseFieldsUtil.getArtistName(artistData), ARTIST_NAME_SINGLE_PROFILE,
                artistResponseFieldsUtil.getArtistGenres(artistData), artistGenresList,
                artistResponseFieldsUtil.getArtistId(artistData), ARTIST_ID,
                artistResponseFieldsUtil.getArtistType(artistData), ARTIST_TYPE);

//                artistResponseFieldsUtil.getTrackName(artistTopTracks, 0), ARTIST_TOP_TRACK_TITLE,
//                artistResponseFieldsUtil.getArtistAlbumName(artistAlbums, 0), ARTIST_ALBUM_TITLE,
//                artistResponseFieldsUtil.getArtistRelated(artistRelated, 0), ARTIST_RELATED_NAME


        apiAssertionsUtil.verifyResponseMultipleFields(artistDataValidationPairs);
    }

    @Test
    void multipleArtistProfilesTest() {

        String[] artistsCollection = {
                "4WZGDpNwrC0vNQyl9QzF7d",
                "3qiHUAX7zY4Qnjx8TNUzVx",
                "07SFzTMeYf5P8Rd32a9Zzw"
        };

        ArtistMultipleResponseModel artistsMultiple = artistClient.getMultipleArtistsData(artistsCollection);

        apiAssertionsUtil.verifyResponseSingleField(artistResponseFieldsUtil.getArtistName(artistsMultiple, 1), ARTIST_NAME_MULTIPLE_PROFILES);
    }
}
