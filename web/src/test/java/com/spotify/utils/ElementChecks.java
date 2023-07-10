package com.spotify.utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

public class ElementChecks {

    private final Page page;
    private final ElementActions elementActions;

    public ElementChecks(Page page) {
        this.page = page;
        this.elementActions = new ElementActions(page);
    }

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
}
