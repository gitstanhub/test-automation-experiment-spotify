package com.spotify.utils.navigation.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getDriver;

@Component
@Slf4j
public class AndroidElementActions {

    private final AndroidPageNavigationActions androidPageNavigationActions = new AndroidPageNavigationActions();

    private WebElement getListItemByTitle(String title) {
        System.out.println("Getting item from the list by title");
        String targetResourceId = "com.spotify.music:id/title";

        androidPageNavigationActions.swipeToElementByText(targetResourceId, title, 10);
        return getDriver().findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiSelector().resourceId(\"%s\").text(\"%s\")",
                        targetResourceId, title)));
    }
}

//    AndroidDriver driver;
//    WebDriverWait wait;
//    AndroidPageNavigationActions androidPageNavigationActions;
