package com.spotify.android.tests;

import com.spotify.android.tests.base.MobileAndroidTestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArtistProfileTests extends MobileAndroidTestBase {

    @Test
    public void artistProfileTest() {

        driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Log in')]")).click();
        driver.findElement(By.id("com.spotify.music:id/username_text")).sendKeys("stasdmitruk1@gmail.com");
        driver.findElement(By.id("com.spotify.music:id/password_text")).sendKeys("3Dabde70!481516");
        driver.findElement(By.id("com.spotify.music:id/login_button")).click();

//        List<WebElement> elements = driver.findElements(By.xpath("//*"));
//        for (WebElement element : elements) {
//            System.out.println("Tag:" + element.getTagName());
//            System.out.println("Text:" + element.getText());
//            System.out.println("Class:" + element.getAttribute("class"));
//            System.out.println("Resource-ID:" + element.getAttribute("resourceId"));
//            System.out.println("********************");
//        }

//@Test
//        public void artistDiscographyTest()

    }
}
