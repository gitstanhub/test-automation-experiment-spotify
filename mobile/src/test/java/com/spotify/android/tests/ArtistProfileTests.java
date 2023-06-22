package com.spotify.android.tests;

import com.spotify.android.pageobjects.commons.Navigation;
import com.spotify.android.pageobjects.pages.ArtistProfilePage;
import com.spotify.android.pageobjects.pages.LibraryPage;
import com.spotify.android.tests.base.MobileAndroidTestBase;
import org.junit.jupiter.api.Test;

public class ArtistProfileTests extends MobileAndroidTestBase {

    private final Navigation navigationBar = new Navigation(driver);
    private final LibraryPage libraryPage = new LibraryPage(driver, wait);
    private final ArtistProfilePage artistProfilePage = new ArtistProfilePage(driver, wait);

    @Test
    public void artistProfileCanBeOpenedFromLibrary() {

        navigationBar
                .clickLibraryButton();
        libraryPage
                .verifyLibraryPageIsOpened()
                .clickArtistsButton()
                .verifyArtistButtonIsSelected()
                .selectArtistItem("Eminem");
        artistProfilePage
                .verifyProfileTitleAvailable("Eminem")
                .verifyMonthlyListenersCountAvailable()
                .verifyFollowButtonAvailable()
                .verifyContextMenuButtonAvailable()
                .verifyShuffleButtonAvailable()
                .verifyPlayButtonAvailable()
                .verifyTrackCloudContainsArtist("Eminem")
                .verifyPopularReleasesTitleIsAvailable();
    }
}





//@Test
//        public void accessArtistDiscographyTest()



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

