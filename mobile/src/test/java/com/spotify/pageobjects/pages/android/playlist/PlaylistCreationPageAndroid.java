package com.spotify.pageobjects.pages.android.playlist;

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
        elementChecksMobile.assertElementIsVisible(getPlayListCreationPageTitle());
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
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/naming_title' and @text='Give your playlist a name']"));
    }

    private WebElement getPlaylistNameField() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.spotify.music:id/edit_text\").description(\"Add a playlist name\")"));
    }

    private WebElement getCreateButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/continue_button"));
    }

    private WebElement getCancelButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/cancel_button"));
    }
}
