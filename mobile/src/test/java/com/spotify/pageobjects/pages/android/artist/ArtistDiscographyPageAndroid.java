package com.spotify.pageobjects.pages.android.artist;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.artist.ArtistDiscographyPage;
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
public class ArtistDiscographyPageAndroid extends AppiumPageAndroid implements ArtistDiscographyPage {

    public ArtistDiscographyPageAndroid verifyDiscographyTitleIsAvailable() {
        elementChecksMobile.assertElementIsVisible(getPageTitle());
        return this;
    }

    public ArtistDiscographyPageAndroid verifyLatestReleaseTitleIsAvailable() {
        elementChecksMobile.assertElementIsVisible(getLatestReleaseTitle());
        return this;
    }

    public ArtistDiscographyPageAndroid verifyAlbumsTitleIsAvailable() {
        elementChecksMobile.assertElementIsVisible(getAlbumsTitle());
        return this;
    }

    public ArtistDiscographyPageAndroid verifySinglesTitleIsAvailable() {
        androidPageNavigationActions.swipeToElementByText("android:id/text1", ConfigProviderMobile.getMobileAppLocaleConfig().singlesTitleText(), 10);
        elementChecksMobile.assertElementIsVisible(getSinglesTitle());
        return this;
    }

    public ArtistDiscographyPageAndroid verifyDiscographyItemIsAvailable(String itemTitle, Integer itemReleaseYear) {
        androidPageNavigationActions.swipeToElementWithSiblingByText("com.spotify.music:id/labels", itemTitle, itemReleaseYear.toString(), 10);
        elementChecksMobile.assertElementIsVisible(getItemByChildSiblings("com.spotify.music:id/labels", itemTitle, itemReleaseYear.toString()));
        return this;
    }


    private WebElement getPageTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/glue_toolbar_title' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().artistDiscographyPageTitleText() + "']"));
    }

    private WebElement getLatestReleaseTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().latestReleaseTitleText() + "']"));
    }

    private WebElement getAlbumsTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().albumsTitleText() + "']"));
    }

    private WebElement getSinglesTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().singlesTitleText() + "']"));
    }

    //ToDo: move to other class with commons
    private WebElement getItemByChildSiblings(String parentResourceId, String childSiblingText1, String childSiblingText2) {
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().resourceId(\"%s\").childSelector(new UiSelector().text(\"%s\")).fromParent(new UiSelector().text(\"%s\"))",
                        parentResourceId, childSiblingText1, childSiblingText2)));
    }
}
