package com.spotify.utils;

import com.microsoft.playwright.Page;

public class ElementChecks {

    private final Page page;
    private final ElementActions elementActions;

    public ElementChecks (Page page) {
        this.page = page;
        this.elementActions = new ElementActions(page);
    }

    public boolean isElementVisibleWithId (String elementId) {
        return elementActions.findElementByIdAttribute(elementId).isVisible();
    }
}
