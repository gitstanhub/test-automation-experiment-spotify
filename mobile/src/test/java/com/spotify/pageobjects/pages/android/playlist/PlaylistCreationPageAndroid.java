package com.spotify.pageobjects.pages.android.playlist;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.playlist.PlaylistCreationPage;
import io.appium.java_client.AppiumBy;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getDriver;

@Component
@Lazy
@Slf4j
public class PlaylistCreationPageAndroid extends AppiumPageAndroid implements PlaylistCreationPage {

    public PlaylistCreationPageAndroid verifyPlaylistCreationPageIsOpened() {
        androidElementChecks.assertElementIsVisible(getPlayListCreationPageTitle());
        return this;
    }

    public PlaylistCreationPageAndroid enterPlaylistName(String playlistName) {
        getPlaylistNameField().clear();
        getPlaylistNameField().sendKeys(playlistName);
        return this;
    }

    public PlaylistCreationPageAndroid tapCreateButton() {
        getCreateButton().click();
        return this;
    }

    public PlaylistCreationPageAndroid tapCancelButton() {
        getCancelButton().click();
        return this;
    }

    private WebElement getPlayListCreationPageTitle() {
        return androidElementActions.getElementByXpath("//android.widget.TextView[@resource-id='com.spotify.music:id/naming_title' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().playListCreationPageTitleText() + "']");
//        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/naming_title' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().playListCreationPageTitleText() + "']"));
    }

    private WebElement getPlaylistNameField() {
        return androidElementActions.getElementByAndroidUiAutomator("new UiSelector().resourceId(\"com.spotify.music:id/edit_text\").description(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().playlistNameFieldText() + "\")");
//        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.spotify.music:id/edit_text\").description(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().playlistNameFieldText() + "\")"));
    }

    private WebElement getCreateButton() {
        return androidElementActions.getElementById("com.spotify.music:id/continue_button");
    }

    private WebElement getCancelButton() {
        return androidElementActions.getElementById("com.spotify.music:id/cancel_button");
    }
}
