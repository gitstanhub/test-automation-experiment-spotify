package com.spotify.pageobjects.commons.android.spotifycode;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.commons.interfaces.spotifycode.SpotifyCode;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getWait;

@Component
@Lazy
@Slf4j
public class SpotifyCodeAndroid extends AppiumPageAndroid implements SpotifyCode {

    public SpotifyCodeAndroid verifySpotifyCodeIsAvailable() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("com.spotify.music:id/scannable_imageview")));
        androidElementChecks.assertElementIsVisible(getSpotifyCodeImage());
        return this;
    }

    private WebElement getSpotifyCodeImage() {
        return androidElementActions.getElementById("com.spotify.music:id/scannable_imageview");
    }
}
