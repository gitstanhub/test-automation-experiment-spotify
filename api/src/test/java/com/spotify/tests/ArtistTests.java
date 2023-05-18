package com.spotify.tests;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.clients.ArtistClient;
import com.spotify.models.response.artist.*;
import com.spotify.utils.assertions.ApiAssertionsUtil;
import com.spotify.utils.responsefields.artist.ArtistProfileFieldsUtil;
import com.spotify.utils.responsefields.artist.ArtistTopTracksFieldsUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.spotify.testdata.artist.AristTracks.*;
import static com.spotify.testdata.artist.ArtistAlbums.*;
import static com.spotify.testdata.artist.ArtistEntities.*;

public class ArtistTests {

    ArtistClient artistClient = new ArtistClient();
    ApiAssertionsUtil apiAssertionsUtil = new ApiAssertionsUtil();
    ArtistProfileFieldsUtil artistResponseFieldsUtil = new ArtistProfileFieldsUtil();
    ArtistTopTracksFieldsUtil artistTopTracksFieldsUtil = new ArtistTopTracksFieldsUtil();

    @Test
    void artistProfileTest() {

        ArtistProfileResponseModel fetchedArtistData = artistClient.getArtistData(CAPITAL_BRA.getArtistId());

        List<Object> actualArtistData = new ArrayList<>();
        actualArtistData.add(artistResponseFieldsUtil.getArtistGenres(fetchedArtistData));
        actualArtistData.add(artistResponseFieldsUtil.getArtistName(fetchedArtistData));
        actualArtistData.add(artistResponseFieldsUtil.getArtistId(fetchedArtistData));
        actualArtistData.add(artistResponseFieldsUtil.getArtistType(fetchedArtistData));
        actualArtistData.add(artistResponseFieldsUtil.getArtistUri(fetchedArtistData));

        List<Object> expectedArtistData = new ArrayList<>();
        expectedArtistData.add(CAPITAL_BRA.getArtistGenres());
        expectedArtistData.add(CAPITAL_BRA.getArtistName());
        expectedArtistData.add(CAPITAL_BRA.getArtistId());
        expectedArtistData.add(CAPITAL_BRA.getArtistType());
        expectedArtistData.add(CAPITAL_BRA.getArtistUri());

        apiAssertionsUtil.verifyResponseMultipleFields(actualArtistData, expectedArtistData);


        String countryCode = String.valueOf(CountryCode.DE);
        ArtistTopTracksResponseModel fetchedArtistTopTracks = artistClient.getArtistTopTracks(countryCode, CAPITAL_BRA.getArtistId());

        List<Object> actualTopTracksData = new ArrayList<>();
        actualTopTracksData.add(artistTopTracksFieldsUtil.getTrackId(fetchedArtistTopTracks, NEYMAR.getTrackName()));
        actualTopTracksData.add(artistTopTracksFieldsUtil.getTrackDuration(fetchedArtistTopTracks, NEYMAR.getTrackName()));
        actualTopTracksData.add(artistTopTracksFieldsUtil.getTrackType(fetchedArtistTopTracks, NEYMAR.getTrackName()));
        actualTopTracksData.add(artistTopTracksFieldsUtil.getTrackAlbumName(fetchedArtistTopTracks, NEYMAR.getTrackName()));
        actualTopTracksData.add(artistTopTracksFieldsUtil.getTrackArtistName(fetchedArtistTopTracks, NEYMAR.getTrackName(), 0));
        actualTopTracksData.add(artistTopTracksFieldsUtil.getTrackExplicitStatus(fetchedArtistTopTracks, NEYMAR.getTrackName()));

        List<Object> expectedTopTracksData = new ArrayList<>();
        expectedTopTracksData.add(NEYMAR.getTrackId());
        expectedTopTracksData.add(NEYMAR.getTrackDurationMs());
        expectedTopTracksData.add(NEYMAR.getTrackType());
        expectedTopTracksData.add(BERLIN_LEBT.getAlbumName());
        expectedTopTracksData.add(CAPITAL_BRA.getArtistName());
        expectedTopTracksData.add(NEYMAR.getTrackExplicit());

        apiAssertionsUtil.verifyResponseMultipleFields(actualTopTracksData, expectedTopTracksData);


        ArtistAlbumsResponseModel artistAlbums = artistClient.getArtistAlbums(countryCode, CAPITAL_BRA.getArtistId());



        ArtistRelatedResponseModel artistRelated = artistClient.getRelatedArtists(CAPITAL_BRA.getArtistId());

    }

    @Test
    void multipleArtistProfilesTest() {

        String[] artistsCollection = {
                "4WZGDpNwrC0vNQyl9QzF7d",
                "3qiHUAX7zY4Qnjx8TNUzVx",
                "07SFzTMeYf5P8Rd32a9Zzw"
        };

        ArtistMultipleResponseModel artistsMultiple = artistClient.getMultipleArtistsData(artistsCollection);

//        apiAssertionsUtil.verifyResponseSingleField(artistResponseFieldsUtil.getArtistName(artistsMultiple, 1), ARTIST_NAME_MULTIPLE_PROFILES);
    }
}
