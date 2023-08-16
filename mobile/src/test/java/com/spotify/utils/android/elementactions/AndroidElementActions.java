package com.spotify.utils.android.elementactions;

import com.spotify.utils.android.navgiation.AndroidPageNavigationActions;
import io.appium.java_client.AppiumBy;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    public WebElement getItemByChildSiblings(String parentResourceId, String childSiblingText1, String childSiblingText2) {
        return getElementByAndroidUiAutomator(
                String.format(
                        "new UiSelector().resourceId(\"%s\").childSelector(new UiSelector().text(\"%s\")).fromParent(new UiSelector().text(\"%s\"))",
                        parentResourceId, childSiblingText1, childSiblingText2));
    }

    public WebElement getListItemByTitleAndResourceId(String title, String targetResourceId) {
        log.info("Getting item from the list by title");

        androidPageNavigationActions.swipeToElementByText(targetResourceId, title, 15);

        return getElementByAndroidUiAutomator(
                String.format(
                        "new UiSelector().resourceId(\"%s\").text(\"%s\")",
                        targetResourceId, title));
    }

    public WebElement getListItemByTitleAndSubtitle(String title, String subtitle) {
        log.info("Getting item from the list by title and subtitle");
        String contentDesc = String.format("%s, %s, ", title, subtitle);

        androidPageNavigationActions.swipeToElementByDescription(contentDesc, 15);

        return getElementByAndroidUiAutomator(
                String.format(
                        "new UiSelector().description(\"%s\")",
                        contentDesc));
    }
}
