package com.spotify.utils;

import com.microsoft.playwright.Locator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ElementChecks {

    public static boolean isElementVisibleWithId(String elementId) {
        return ElementActions.findElementById(elementId).isVisible();
    }

    public static boolean isElementVisible(Locator locator) {
        return locator.isVisible();
    }

    public static boolean isElementVisibleWithText(String elementText) {
        return ElementActions.findElementByExactText(elementText).isVisible();
    }

    public static void assertInputElementContainsText(String expectedText, Locator locator) {
        Assertions.assertEquals(expectedText, locator.inputValue(), "Couldn't find the expected text inside the specified element");
    }

    public static void assertElementContainsText(String expectedText, Locator locator) {
        Assertions.assertEquals(expectedText, locator.innerText(), "Couldn't find the expected text inside the specified element");
    }
}
