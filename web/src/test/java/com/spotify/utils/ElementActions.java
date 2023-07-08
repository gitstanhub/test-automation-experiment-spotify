package com.spotify.utils;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

//    public List<Locator> findAndScrollIntoAllElementsBySelector(String selector, int desiredLimit) {
//        Set<Locator> allElements = new HashSet<>();
//        List<Locator> newElements;
//
//        do {
//            newElements = page.locator(selector).all();
//            newElements.forEach(Locator::scrollIntoViewIfNeeded);
//
//            newElements.removeAll(allElements);
//            allElements.addAll(newElements);
//
//        } while (!newElements.isEmpty() && allElements.size() < desiredLimit);
//
//        return new ArrayList<>(allElements);
//    }

    public List<Locator> findAndScrollIntoAllElementsBySelector(String selector, int desiredLimit) {
        List<Locator> allElements = new ArrayList<>();
        List<Locator> newElements;
        int currentSize = 0;

        do {
            newElements = page.locator(selector).all();
            newElements.removeAll(allElements);
            allElements.addAll(newElements);

            if (allElements.size() < desiredLimit) {
                Locator lastElement = newElements.get(newElements.size() - 1);
                lastElement.scrollIntoViewIfNeeded();
                page.waitForTimeout(500);
            }

            int newSize = allElements.size();
            if (newSize == currentSize) {
                break;
            }

            currentSize = newSize;
        } while (allElements.size() < desiredLimit);

        return allElements;
    }
}
