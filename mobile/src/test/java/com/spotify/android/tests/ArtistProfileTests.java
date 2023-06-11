package com.spotify.android.tests;

import com.spotify.android.pageobjects.commons.NavigationBar;
import com.spotify.android.pageobjects.pages.LibraryPage;
import com.spotify.android.tests.base.MobileAndroidTestBase;
import org.junit.jupiter.api.Test;

public class ArtistProfileTests extends MobileAndroidTestBase {

    private final NavigationBar navigationBar = new NavigationBar(driver);
    private final LibraryPage libraryPage = new LibraryPage(driver, wait);

    @Test
    public void artistProfileIsPresented() {
        navigationBar.clickLibraryButton();
        libraryPage
//                .clickArtistsButton()
                .selectArtistItem("Capital Bra");

//        wait.until(webElement -> navigationBar.getNavigationBar().isDisplayed());




//        List<WebElement> elements = driver.findElements(By.xpath("//*"));
//        for (WebElement element : elements) {
//            System.out.println("Tag:" + element.getTagName());
//            System.out.println("Text:" + element.getText());
//            System.out.println("Class:" + element.getAttribute("class"));
//            System.out.println("Resource-ID:" + element.getAttribute("resourceId"));
//            System.out.println("********************");
//        }



//@Test
//        public void accessArtistDiscographyTest()
    }


//    @Test
//    public void accessArtistSpotifyCodeTest()
}
