package com.spotify.utils;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ElementActions {

    private final Page page;

    public ElementActions (Page page) {
        this.page = page;
    }

    public Locator findElementByText(String elementText) {
        return page.getByText(elementText);
    }

    public Locator findElementByTestId(String testId) {
        return page.getByTestId(testId);
    }

    public Locator findElementByIdAttribute(String idAttribute) {
        return page.locator("#" + idAttribute);
    }
}
