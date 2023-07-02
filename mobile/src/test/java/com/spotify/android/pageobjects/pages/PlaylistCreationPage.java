package com.spotify.android.pageobjects.pages;

import com.spotify.android.utils.assertions.ElementChecks;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaylistCreationPage {

    private final AppiumDriver driver;
    private final ElementChecks elementChecks;

    public PlaylistCreationPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.elementChecks = new ElementChecks(driver, wait);
    }

    public PlaylistCreationPage verifyPlaylistCreationPageIsOpened() {
        elementChecks.assertElementIsVisible(getPlayListCreationPageTitle());
        return this;
    }

    public PlaylistCreationPage enterPlaylistName(String playlistName) {
        getPlaylistNameField().clear();
        getPlaylistNameField().sendKeys(playlistName);
        return this;
    }

    public PlaylistCreationPage tapCreateButton() {
        getCreateButton().click();
        return this;
    }

    public PlaylistCreationPage tapCancelButton() {
        getCancelButton().click();
        return this;
    }

    private WebElement getPlayListCreationPageTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/naming_title' and @text='Give your playlist a name']"));
    }

    private WebElement getPlaylistNameField() {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.spotify.music:id/edit_text\").description(\"Add a playlist name\")"));
    }

    private WebElement getCreateButton() {
        return driver.findElement(By.id("com.spotify.music:id/continue_button"));
    }

    private WebElement getCancelButton() {
        return driver.findElement(By.id("com.spotify.music:id/cancel_button"));
    }
}
