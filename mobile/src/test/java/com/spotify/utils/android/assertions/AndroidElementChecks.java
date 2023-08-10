package com.spotify.utils.android.assertions;

import com.spotify.utils.android.elementactions.AndroidElementActions;
import io.appium.java_client.AppiumBy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getDriver;

@Slf4j
@Component
public class AndroidElementChecks {

    @Autowired
    private AndroidElementActions androidElementActions;

    public void assertElementIsVisible(WebElement element) {
        Assertions.assertTrue(element.isDisplayed(), "Element with id: " + element.getAttribute("resource-id") + " is not visible");
    }

    public void assertElementContainsText(WebElement element, String expectedText) {
        Assertions.assertTrue(element.getText().contains(expectedText), "Couldn't find the expected text inside the specified element");
    }

    public void assertElementHasExactText(WebElement element, String expectedText) {
        Assertions.assertEquals(expectedText, element.getText(), "Specified element doesn't contain the exact text as the expected");
    }

    public void assertElementSelected(WebElement element) {
        Assertions.assertEquals("true", element.getAttribute("selected"));
    }

    public Boolean isElementSelected(WebElement element) {
        return "true".equals(element.getAttribute("selected"));
    }

    public boolean isElementExists(String resourceId) {
        System.out.println("Checking if elements with subtitles exist");
        try {
            androidElementActions.getElementByAndroidUiAutomator(
                    "new UiSelector().resourceId(\"" + resourceId + "\")"
            );

//            getDriver().findElement(AppiumBy.androidUIAutomator(
//                    "new UiSelector().resourceId(\"" + resourceId + "\")"
//            ));

            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
