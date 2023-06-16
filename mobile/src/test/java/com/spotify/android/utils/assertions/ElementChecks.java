package com.spotify.android.utils.assertions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class ElementChecks {

    public void assertElementIsVisible(WebElement element) {
        Assertions.assertTrue(element.isDisplayed(), "Element with id: " + element.getAttribute("resource-id") + " is not visible");
    }

    public void assertElementContainsText(WebElement element, String expectedText) {
        Assertions.assertTrue(element.getText().contains(expectedText), "Couldn't find the expected text inside the specified element");
    }

    public void assertElementHasExactText(WebElement element, String expectedText) {
        Assertions.assertEquals(expectedText, element.getText(), "Specified element doesn't contain the exact text as the expected");
    }


}
