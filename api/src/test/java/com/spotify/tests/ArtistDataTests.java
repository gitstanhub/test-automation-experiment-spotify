package com.spotify.tests;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.clients.ArtistClient;
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
        ArtistProfileResponseModel fetchedArtistData = artistClient.getArtistData(ARTIST_1.getArtistId());

        ArtistEntitiesAssertionData.ActualArtistData actualArtistData = new ArtistEntitiesAssertionData.ActualArtistData(
                artistResponseFieldsUtil.getArtistName(fetchedArtistData),
                artistResponseFieldsUtil.getArtistGenres(fetchedArtistData),
                artistResponseFieldsUtil.getArtistId(fetchedArtistData),
                artistResponseFieldsUtil.getArtistType(fetchedArtistData),
                artistResponseFieldsUtil.getArtistUri(fetchedArtistData)
        );

        ArtistEntitiesAssertionData.ExpectedArtistData expectedArtistData = new ArtistEntitiesAssertionData.ExpectedArtistData(
                ARTIST_1.getArtistName(),
                ARTIST_1.getArtistGenres(),
                ARTIST_1.getArtistId(),
                ARTIST_1.getArtistType(),
                ARTIST_1.getArtistUri()
        );

        apiAssertionsUtil.assertFieldsAreEqual(actualArtistData, expectedArtistData);
    }

    @Test
    void artistTopTracksCanBeFetched() {
        String countryCode = String.valueOf(CountryCode.DE);

        ArtistTopTracksResponseModel fetchedArtistTopTracks = artistClient.getArtistTopTracks(countryCode, ARTIST_1.getArtistId());

        ArtistTracksAssertionData.ActualTracksData actualTopTracksData = new ArtistTracksAssertionData.ActualTracksData(
                artistTopTracksFieldsUtil.getTrackName(fetchedArtistTopTracks, ARTIST1_TRACK_1.getTrackName()),
                artistTopTracksFieldsUtil.getTrackId(fetchedArtistTopTracks, ARTIST1_TRACK_1.getTrackName()),
                artistTopTracksFieldsUtil.getTrackDuration(fetchedArtistTopTracks, ARTIST1_TRACK_1.getTrackName()),
                artistTopTracksFieldsUtil.getTrackType(fetchedArtistTopTracks, ARTIST1_TRACK_1.getTrackName()),
                artistTopTracksFieldsUtil.getTrackAlbumName(fetchedArtistTopTracks, ARTIST1_TRACK_1.getTrackName()),
                artistTopTracksFieldsUtil.getTrackArtistName(fetchedArtistTopTracks, ARTIST1_TRACK_1.getTrackName(), 0),
                artistTopTracksFieldsUtil.getTrackExplicitStatus(fetchedArtistTopTracks, ARTIST1_TRACK_1.getTrackName())
        );

        ArtistTracksAssertionData.ExpectedTracksData expectedTopTracksData = new ArtistTracksAssertionData.ExpectedTracksData(
                ARTIST1_TRACK_1.getTrackName(),
                ARTIST1_TRACK_1.getTrackId(),
                ARTIST1_TRACK_1.getTrackDurationMs(),
                ARTIST1_TRACK_1.getTrackType(),
                ARTIST_1_ALBUM_1.getAlbumName(),
                ARTIST1_TRACK_1.getTrackArtists().get(0),
                ARTIST1_TRACK_1.getTrackExplicit()
        );

        apiAssertionsUtil.assertFieldsAreEqual(actualTopTracksData, expectedTopTracksData);
    }

    @Test
    void artistAlbumsCanBeFetched() {
        String countryCode = String.valueOf(CountryCode.DE);

        ArtistAlbumsResponseModel fetchedArtistAlbums = artistClient.getArtistAlbums(countryCode, ARTIST_1.getArtistId());

        ArtistAlbumsAssertionData.ActualAlbumData actualAlbumsData = new ArtistAlbumsAssertionData.ActualAlbumData(
                artistAlbumFieldsUtil.getAlbumName(fetchedArtistAlbums, ARTIST_1_ALBUM_1.getAlbumName()),
                artistAlbumFieldsUtil.getAlbumId(fetchedArtistAlbums, ARTIST_1_ALBUM_1.getAlbumName()),
                artistAlbumFieldsUtil.getAlbumArtistName(fetchedArtistAlbums, ARTIST_1_ALBUM_1.getAlbumName(), 0),
                artistAlbumFieldsUtil.getAlbumType(fetchedArtistAlbums, ARTIST_1_ALBUM_1.getAlbumName()),
                artistAlbumFieldsUtil.getAlbumTotalTracks(fetchedArtistAlbums, ARTIST_1_ALBUM_1.getAlbumName()),
                artistAlbumFieldsUtil.getAlbumReleaseDate(fetchedArtistAlbums, ARTIST_1_ALBUM_1.getAlbumName())
        );

        ArtistAlbumsAssertionData.ExpectedAlbumData expectedAlbumsData = new ArtistAlbumsAssertionData.ExpectedAlbumData(
                ARTIST_1_ALBUM_1.getAlbumName(),
                ARTIST_1_ALBUM_1.getAlbumId(),
                ARTIST_1_ALBUM_1.getAlbumArtists().get(0),
                ARTIST_1_ALBUM_1.getAlbumType(),
                ARTIST_1_ALBUM_1.getAlbumTotalTracks(),
                ARTIST_1_ALBUM_1.getAlbumReleaseDate()
        );

        apiAssertionsUtil.assertFieldsAreEqual(actualAlbumsData, expectedAlbumsData);
    }

    @Test
    void relatedArtistsCanBeFetched() {
        ArtistRelatedResponseModel fetchedArtistRelated = artistClient.getRelatedArtists(ARTIST_1.getArtistId());

        ArtistRelatedAssertionData.ActualRelatedArtistData actualRelatedArtistData = new ArtistRelatedAssertionData.ActualRelatedArtistData(
                artistRelatedFieldsUtil.getRelatedArtistName(fetchedArtistRelated, ARTIST_2.getArtistName()),
                artistRelatedFieldsUtil.getRelatedArtistGenres(fetchedArtistRelated, ARTIST_2.getArtistName()),
                artistRelatedFieldsUtil.getRelatedArtistId(fetchedArtistRelated, ARTIST_2.getArtistName()),
                artistRelatedFieldsUtil.getRelatedArtistType(fetchedArtistRelated, ARTIST_2.getArtistName()),
                artistRelatedFieldsUtil.getRelatedArtistUri(fetchedArtistRelated, ARTIST_2.getArtistName())
        );

        ArtistRelatedAssertionData.ExpectedRelatedArtistData expectedAssertionData = new ArtistRelatedAssertionData.ExpectedRelatedArtistData(
                ARTIST_2.getArtistName(),
                ARTIST_2.getArtistGenres(),
                ARTIST_2.getArtistId(),
                ARTIST_2.getArtistType(),
                ARTIST_2.getArtistUri()
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

        ArtistMultipleResponseModel fetchedArtistMultiple = artistClient.getMultipleArtistsData(inScopeArtistsIds);

        ArtistMultipleAssertionData.ActualMultipleArtistData actualMultipleArtistData = new ArtistMultipleAssertionData.ActualMultipleArtistData(
                artistMultipleFieldsUtil.getMultipleArtistsNames(fetchedArtistMultiple),
                artistMultipleFieldsUtil.getMultipleArtistGenres(fetchedArtistMultiple),
                artistMultipleFieldsUtil.getMultipleArtistIds(fetchedArtistMultiple)
        );

        ArtistMultipleAssertionData.ExpectedMultipleArtistData expectedMultipleArtistData = new ArtistMultipleAssertionData.ExpectedMultipleArtistData(
                inScopeArtistsNames,
                inScopeArtistsGenres,
                inScopeArtistsIds
        );

        apiAssertionsUtil.assertFieldsAreEqual(actualMultipleArtistData, expectedMultipleArtistData);
    }
}
