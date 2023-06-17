package com.spotify.android.utils.assertions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementChecks {

    AndroidDriver driver;
    WebDriverWait wait;

    public ElementChecks(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void assertElementIsVisible(WebElement element) {
        Assertions.assertTrue(element.isDisplayed(), "Element with id: " + element.getAttribute("resource-id") + " is not visible");
    }

    public void assertElementContainsText(WebElement element, String expectedText) {
        Assertions.assertTrue(element.getText().contains(expectedText), "Couldn't find the expected text inside the specified element");
    }

    public void assertElementHasExactText(WebElement element, String expectedText) {
        Assertions.assertEquals(expectedText, element.getText(), "Specified element doesn't contain the exact text as the expected");
    }

    public void assertElementIsSelected(WebElement element) {
        Assertions.assertEquals("true", element.getAttribute("selected"));
//        wait.until(ExpectedConditions.attributeContains(element, "selected", "true"));
    }

    public boolean isElementExistWithResourceId(String resourceId) {
        System.out.println("Checking if elements with subtitles exist");
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().resourceId(\"" + resourceId + "\")"
            ));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
