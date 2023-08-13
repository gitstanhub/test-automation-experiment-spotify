package com.spotify.tests;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.clients.ArtistClient;
import com.spotify.config.ConfigProviderApi;
import com.spotify.models.response.artist.*;
import com.spotify.testdata.artist.assertions.*;
import com.spotify.testdata.artist.constants.ArtistEntities;
import com.spotify.tests.base.ApiTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static com.spotify.testdata.artist.constants.AristTracks.*;
import static com.spotify.testdata.artist.constants.ArtistAlbums.*;
import static com.spotify.testdata.artist.constants.ArtistEntities.*;

public class ArtistDataTests extends ApiTests {

    @Autowired
    ArtistClient artistClient;

    @Test
    void artistProfileCanBeFetched() {

        ArtistEntitiesAssertionData.ExpectedArtistData expectedArtistData = new ArtistEntitiesAssertionData.ExpectedArtistData(
                ARTIST_1.getArtistName(),
                ARTIST_1.getArtistGenres(),
                ARTIST_1.getArtistId(),
                ARTIST_1.getArtistType(),
                ARTIST_1.getArtistUri()
        );

        String expectedArtistId = expectedArtistData.getExpectedArtistId();

        ArtistProfileResponseModel fetchedArtistProfile = artistClient.getArtistDataBy(expectedArtistId);

        ArtistEntitiesAssertionData.ActualArtistData actualArtistData = new ArtistEntitiesAssertionData.ActualArtistData(
                artistProfileResponseFieldsUtil.getArtistNameFrom(fetchedArtistProfile),
                artistProfileResponseFieldsUtil.getArtistGenresFrom(fetchedArtistProfile),
                artistProfileResponseFieldsUtil.getArtistIdFrom(fetchedArtistProfile),
                artistProfileResponseFieldsUtil.getArtistTypeFrom(fetchedArtistProfile),
                artistProfileResponseFieldsUtil.getArtistUriFrom(fetchedArtistProfile)
        );

        apiAssertionsUtil.assertFieldsAreEqual(actualArtistData, expectedArtistData);
    }

    @Test
    void artistTopTracksCanBeFetched() {

        ArtistTracksAssertionData.ExpectedTracksData expectedTopTracksData = new ArtistTracksAssertionData.ExpectedTracksData(
                ARTIST1_TRACK_1.getTrackName(),
                ARTIST1_TRACK_1.getTrackId(),
                ARTIST1_TRACK_1.getTrackDurationMs(),
                ARTIST1_TRACK_1.getTrackType(),
                ARTIST_1_ALBUM_1.getAlbumName(),
                ARTIST1_TRACK_1.getTrackArtists().get(0),
                ARTIST1_TRACK_1.getTrackExplicit()
        );

        String expectedArtistId = ARTIST_1.getArtistId();
        String expectedTrackName = expectedTopTracksData.getExpectedTrackName();
        String countryCode = ConfigProviderApi.getRestAssuredApiConfiguration().market();

        ArtistTopTracksResponseModel fetchedArtistTopTracks = artistClient.getArtistTopTracksBy(countryCode, expectedArtistId);

        ArtistTracksAssertionData.ActualTracksData actualTopTracksData = new ArtistTracksAssertionData.ActualTracksData(
                artistTopTracksResponseDataUtil.getTrackNameFrom(fetchedArtistTopTracks, expectedTrackName),
                artistTopTracksResponseDataUtil.getTrackIdFrom(fetchedArtistTopTracks, expectedTrackName),
                artistTopTracksResponseDataUtil.getTrackDurationFrom(fetchedArtistTopTracks, expectedTrackName),
                artistTopTracksResponseDataUtil.getTrackTypeFrom(fetchedArtistTopTracks, expectedTrackName),
                artistTopTracksResponseDataUtil.getTrackAlbumNameFrom(fetchedArtistTopTracks, expectedTrackName),
                artistTopTracksResponseDataUtil.getTrackArtistNameFrom(fetchedArtistTopTracks, expectedTrackName, 0),
                artistTopTracksResponseDataUtil.getTrackExplicitStatusFrom(fetchedArtistTopTracks, expectedTrackName)
        );

        apiAssertionsUtil.assertFieldsAreEqual(actualTopTracksData, expectedTopTracksData);
    }

    @Test
    void artistAlbumsCanBeFetched() {

        ArtistAlbumsAssertionData.ExpectedAlbumData expectedAlbumsData = new ArtistAlbumsAssertionData.ExpectedAlbumData(
                ARTIST_1_ALBUM_1.getAlbumName(),
                ARTIST_1_ALBUM_1.getAlbumId(),
                ARTIST_1_ALBUM_1.getAlbumArtists().get(0),
                ARTIST_1_ALBUM_1.getAlbumType(),
                ARTIST_1_ALBUM_1.getAlbumTotalTracks(),
                ARTIST_1_ALBUM_1.getAlbumReleaseDate()
        );

        String expectedArtistId = ARTIST_1.getArtistId();
        String expectedAlbumName = expectedAlbumsData.getExpectedAlbumName();
        String countryCode = ConfigProviderApi.getRestAssuredApiConfiguration().market();

        ArtistAlbumsResponseModel fetchedArtistAlbums = artistClient.getArtistAlbumsBy(countryCode, expectedArtistId);

        ArtistAlbumsAssertionData.ActualAlbumData actualAlbumsData = new ArtistAlbumsAssertionData.ActualAlbumData(
                artistAlbumResponseDataUtil.getAlbumNameFrom(fetchedArtistAlbums, expectedAlbumName),
                artistAlbumResponseDataUtil.getAlbumIdFrom(fetchedArtistAlbums, expectedAlbumName),
                artistAlbumResponseDataUtil.getAlbumArtistNameFrom(fetchedArtistAlbums, expectedAlbumName, 0),
                artistAlbumResponseDataUtil.getAlbumTypeFrom(fetchedArtistAlbums, expectedAlbumName),
                artistAlbumResponseDataUtil.getAlbumTotalTracksFrom(fetchedArtistAlbums, expectedAlbumName),
                artistAlbumResponseDataUtil.getAlbumReleaseDateFrom(fetchedArtistAlbums, expectedAlbumName)
        );

        apiAssertionsUtil.assertFieldsAreEqual(actualAlbumsData, expectedAlbumsData);
    }

    @Test
    void relatedArtistsCanBeFetched() {

        ArtistRelatedAssertionData.ExpectedRelatedArtistData expectedAssertionData = new ArtistRelatedAssertionData.ExpectedRelatedArtistData(
                ARTIST_2.getArtistName(),
                ARTIST_2.getArtistGenres(),
                ARTIST_2.getArtistId(),
                ARTIST_2.getArtistType(),
                ARTIST_2.getArtistUri()
        );

        String expectedFirstArtistId = ARTIST_1.getArtistId();
        String expectedRelatedArtistName = ARTIST_2.getArtistName();

        ArtistRelatedResponseModel fetchedArtistRelated = artistClient.getRelatedArtistsBy(expectedFirstArtistId);

        ArtistRelatedAssertionData.ActualRelatedArtistData actualRelatedArtistData = new ArtistRelatedAssertionData.ActualRelatedArtistData(
                relatedArtistsResponseDataUtil.getRelatedArtistNameFrom(fetchedArtistRelated, expectedRelatedArtistName),
                relatedArtistsResponseDataUtil.getRelatedArtistGenresFrom(fetchedArtistRelated, expectedRelatedArtistName),
                relatedArtistsResponseDataUtil.getRelatedArtistIdFrom(fetchedArtistRelated, expectedRelatedArtistName),
                relatedArtistsResponseDataUtil.getRelatedArtistTypeFrom(fetchedArtistRelated, expectedRelatedArtistName),
                relatedArtistsResponseDataUtil.getRelatedArtistUriFrom(fetchedArtistRelated, expectedRelatedArtistName)
        );

        apiAssertionsUtil.assertFieldsAreEqual(actualRelatedArtistData, expectedAssertionData);
    }

    @Test
    void multipleArtistsProfilesCanBeFetched() {

        List<ArtistEntities> inScopeArtists = Arrays.asList(
                ARTIST_1,
                ARTIST_2,
                ARTIST_3
        );

        List<String> inScopeArtistsIds = ArtistEntities.getMultipleArtistIds(inScopeArtists);
        List<String> inScopeArtistsNames = ArtistEntities.getMultipleArtistNames(inScopeArtists);
        List<String> inScopeArtistsGenres = ArtistEntities.getMultipleArtistGenres(inScopeArtists);

        ArtistMultipleAssertionData.ExpectedMultipleArtistData expectedMultipleArtistData = new ArtistMultipleAssertionData.ExpectedMultipleArtistData(
                inScopeArtistsNames,
                inScopeArtistsGenres,
                inScopeArtistsIds
        );

        ArtistMultipleResponseModel fetchedArtistMultiple = artistClient.getMultipleArtistsDataBy(inScopeArtistsIds);

        ArtistMultipleAssertionData.ActualMultipleArtistData actualMultipleArtistData = new ArtistMultipleAssertionData.ActualMultipleArtistData(
                multipleArtistsResponseDataUtil.getMultipleArtistsNamesFrom(fetchedArtistMultiple),
                multipleArtistsResponseDataUtil.getMultipleArtistGenresFrom(fetchedArtistMultiple),
                multipleArtistsResponseDataUtil.getMultipleArtistIdsFrom(fetchedArtistMultiple)
        );

        apiAssertionsUtil.assertFieldsAreEqual(actualMultipleArtistData, expectedMultipleArtistData);
    }
}
