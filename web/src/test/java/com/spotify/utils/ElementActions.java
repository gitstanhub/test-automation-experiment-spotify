package com.spotify.utils;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

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

    public Locator findElementById(String idAttribute) {
        return page.locator("#" + idAttribute);
    }

    public Locator findElementByRole(AriaRole role, String elementText) {
        return page.getByRole(role, new Page.GetByRoleOptions().setName(elementText).setExact(true));
    }

    public Locator findElementBySelector(String selector) {
        return page.locator(selector);
    }

    public List<Locator> findAllElementsBySelector(String selector) {
        return page.locator(selector).all();
    }
}
