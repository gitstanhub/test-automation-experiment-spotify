package com.spotify.utils;

import com.microsoft.playwright.Locator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ElementChecks {

    private final ElementActions elementActions = new ElementActions();

    public boolean isElementVisibleWithId(String elementId) {
        return elementActions.findElementById(elementId).isVisible();
    }

    public boolean isElementVisible(Locator locator) {
        return locator.isVisible();
    }

    public boolean isElementVisibleWithText(String elementText) {
        return elementActions.findElementByExactText(elementText).isVisible();
    }

    public void assertInputElementContainsText(String expectedText, Locator locator) {
        Assertions.assertEquals(expectedText, locator.inputValue(), "Couldn't find the expected text inside the specified element");
    }

    public void assertElementContainsText(String expectedText, Locator locator) {
        Assertions.assertEquals(expectedText, locator.innerText(), "Couldn't find the expected text inside the specified element");
    }
}
