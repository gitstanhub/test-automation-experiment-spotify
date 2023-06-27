package com.spotify.android.tests;

import com.spotify.android.pageobjects.commons.MediaInteraction;
import com.spotify.android.pageobjects.commons.Navigation;
import com.spotify.android.pageobjects.pages.ArtistDiscographyPage;
import com.spotify.android.pageobjects.pages.ArtistProfilePage;
import com.spotify.android.pageobjects.pages.LibraryPage;
import com.spotify.android.tests.base.MobileAndroidTestBase;
import org.junit.jupiter.api.Test;

public class ArtistTests extends MobileAndroidTestBase {

    private final Navigation navigationBar = new Navigation(driver);
    private final LibraryPage libraryPage = new LibraryPage(driver, wait);
    private final ArtistProfilePage artistProfilePage = new ArtistProfilePage(driver, wait);
    private final MediaInteraction mediaInteraction = new MediaInteraction(driver, wait);
    private final ArtistDiscographyPage aristDiscographyPage = new ArtistDiscographyPage(driver, wait);

    @Test
    public void artistProfileCanBeOpenedFromLibrary() {

        navigationBar
                .clickLibraryButton();
        libraryPage
                .verifyLibraryPageIsOpened()
                .clickArtistsButton()
                .verifyArtistButtonIsSelected()
                .selectArtistItem("Oliver Tree");
        artistProfilePage
                .verifyProfileTitleHasText("Oliver Tree")
                .verifyMonthlyListenersCountIsAvailable()
                .verifyFollowButtonIsAvailable();
        mediaInteraction
                .verifyContextMenuButtonIsAvailable()
                .verifyShuffleButtonIsAvailable()
                .verifyPlayButtonIsAvailable();
        artistProfilePage
                .verifyTrackCloudContainsArtist("Oliver Tree")
                .verifyPopularReleasesSectionIsAvailable()
                .verifyArtistPlaylistsSectionIsAvailable()
                .verifyFansAlsoLikeSectionIsAvailable();
    }

    @Test
    public void artistDiscographyCanBeOpenedFromProfile() {

        navigationBar
                .clickLibraryButton();
        libraryPage
                .verifyLibraryPageIsOpened()
                .clickArtistsButton()
                .verifyArtistButtonIsSelected()
                .selectArtistItem("Oliver Tree");
        artistProfilePage
                .tapSeeDiscographyButton();
        aristDiscographyPage
                .verifyDiscographyTitleIsAvailable()
                .verifyLatestReleaseTitleIsAvailable()
                .verifyAlbumsTitleIsAvailable()
                .verifyDiscographyItemIsAvailable("Cowboy Tears", 2022)
                .verifySinglesTitleIsAvailable()
                .verifyDiscographyItemIsAvailable("Miss You (Remix)", 2022);
    }
}

//    @Test
//    public void accessArtistSpotifyCodeTest()




    //        List<WebElement> elements = driver.findElements(By.xpath("//*"));
//        for (WebElement element : elements) {
//            System.out.println("Tag:" + element.getTagName());
//            System.out.println("Text:" + element.getText());
//            System.out.println("Class:" + element.getAttribute("class"));
//            System.out.println("Resource-ID:" + element.getAttribute("resourceId"));
//            System.out.println("********************");
//        }

