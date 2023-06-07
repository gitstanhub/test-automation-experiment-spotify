package com.spotify.android.tests;

import com.spotify.android.pageobjects.commons.NavigationBar;
import com.spotify.android.tests.base.MobileAndroidTestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class ArtistProfileTests extends MobileAndroidTestBase {

    NavigationBar navigationBar = new NavigationBar(driver);

    @Test
    public void accessArtistProfileTest() {
        driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Log in')]")).click();
        driver.findElement(By.id("com.spotify.music:id/username_text")).sendKeys("spotify_user_login");
        driver.findElement(By.id("com.spotify.music:id/password_text")).sendKeys("spotify_user_password");
        driver.findElement(By.id("com.spotify.music:id/login_button")).click();

        wait.until(webElement -> navigationBar.getNavigationBar().isDisplayed());





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
