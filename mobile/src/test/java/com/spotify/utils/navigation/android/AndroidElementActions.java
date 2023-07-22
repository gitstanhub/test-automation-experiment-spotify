package com.spotify.utils.navigation.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AndroidElementActions {

    AndroidDriver driver;
    WebDriverWait wait;
    AndroidPageNavigationActions androidPageNavigationActions;

    private WebElement getListItemByTitle(String title) {
        System.out.println("Getting item from the list by title");
        String targetResourceId = "com.spotify.music:id/title";

        androidPageNavigationActions.swipeToElementByText(targetResourceId, title, 10);
        return driver.findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().resourceId(\"%s\").text(\"%s\")",
                        targetResourceId, title)));
    }
}
