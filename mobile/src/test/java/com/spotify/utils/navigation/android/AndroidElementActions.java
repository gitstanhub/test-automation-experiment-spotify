package com.spotify.utils.navigation.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.spotify.driver.AppiumDriverHandler.getDriver;

@Component
@Slf4j
public class AndroidElementActions {

    @Autowired
    private AndroidPageNavigationActions androidPageNavigationActions;

    public WebElement getElementById(String idLocator) {
        return getDriver().findElement(By.id(idLocator));
    }

    public List<WebElement> getAllElementsById(String idLocator) {
        return getDriver().findElements(By.id(idLocator));
    }

    public WebElement getElementByXpath(String xpathLocator) {
        return getDriver().findElement(By.xpath(xpathLocator));
    }

    public WebElement getElementByAndroidUiAutomator(String androidUiAutomatorText) {
        return getDriver().findElement(AppiumBy.androidUIAutomator(androidUiAutomatorText));
    }

    public WebElement getListItemByTitleAndResourceId(String title, String targetResourceId) {
        System.out.println("Getting item from the list by title");

        androidPageNavigationActions.swipeToElementByText(targetResourceId, title, 10);
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().resourceId(\"%s\").text(\"%s\")",
                        targetResourceId, title)));
    }

    public WebElement getListItemByTitleAndSubtitle(String title, String subtitle) {
        System.out.println("Getting item from the list by title and subtitle");
        String contentDesc = String.format("%s, %s, ", title, subtitle);

        androidPageNavigationActions.swipeToElementByDescription(contentDesc, 10);
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().description(\"%s\")",
                        contentDesc)));
    }
}
