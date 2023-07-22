package com.spotify.pageobjects.pages.android.artist;

import com.spotify.pageobjects.pages.interfaces.artist.ArtistDiscographyPage;
import com.spotify.utils.assertions.ElementChecks;
import com.spotify.utils.navigation.android.AndroidPageNavigationActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArtistDiscographyPageAndroid implements ArtistDiscographyPage {

    private final AndroidDriver driver;
    private final ElementChecks elementChecks;
    private final AndroidPageNavigationActions androidPageNavigationActions;

    public ArtistDiscographyPageAndroid(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        elementChecks = new ElementChecks(driver, wait);
        androidPageNavigationActions = new AndroidPageNavigationActions(driver, wait);
    }

    public ArtistDiscographyPageAndroid verifyDiscographyTitleIsAvailable() {
        elementChecks.assertElementIsVisible(getPageTitle());
        return this;
    }

    public ArtistDiscographyPageAndroid verifyLatestReleaseTitleIsAvailable() {
        elementChecks.assertElementIsVisible(getLatestReleaseTitle());
        return this;
    }

    public ArtistDiscographyPageAndroid verifyAlbumsTitleIsAvailable() {
        elementChecks.assertElementIsVisible(getAlbumsTitle());
        return this;
    }

    public ArtistDiscographyPageAndroid verifySinglesTitleIsAvailable() {
        androidPageNavigationActions.swipeToElementByText("android:id/text1", "Singles", 10);
        elementChecks.assertElementIsVisible(getAlbumsTitle());
        return this;
    }

    public ArtistDiscographyPageAndroid verifyDiscographyItemIsAvailable(String itemTitle, Integer itemReleaseYear) {
        androidPageNavigationActions.swipeToElementWithSiblingByText("com.spotify.music:id/labels", itemTitle, itemReleaseYear.toString(), 10);
        elementChecks.assertElementIsVisible(getItemByChildSiblings("com.spotify.music:id/labels", itemTitle, itemReleaseYear.toString()));
        return this;
    }


    private WebElement getPageTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/glue_toolbar_title' and @text='Releases']"));
    }

    private WebElement getLatestReleaseTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Latest release']"));
    }

    private WebElement getAlbumsTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Albums']"));
    }

    private WebElement getSinglesTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Singles']"));
    }

    //ToDo: move to other class with commons
    private WebElement getItemByChildSiblings(String parentResourceId, String childSiblingText1, String childSiblingText2) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().resourceId(\"%s\").childSelector(new UiSelector().text(\"%s\")).fromParent(new UiSelector().text(\"%s\"))",
                        parentResourceId, childSiblingText1, childSiblingText2)));
    }

}
