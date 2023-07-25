package com.spotify.utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.spotify.driver.PlaywrightDriverHandler.getPage;

@Component
@Slf4j
public class ElementActions {

    public static Locator findElementByExactText(String elementText) {
        return getPage().getByText(elementText, new Page.GetByTextOptions().setExact(true));
    }

    public static Locator findElementByTestId(String testId) {
        return getPage().getByTestId(testId);
    }

    public static Locator findElementById(String idAttribute) {
        return getPage().locator("#" + idAttribute);
    }

    public static Locator findElementByRole(AriaRole role, String elementText) {
        return getPage().getByRole(role, new Page.GetByRoleOptions().setName(elementText).setExact(true));
    }

    public static Locator findElementBySelector(String selector) {
        return getPage().locator(selector);
    }

    public static List<Locator> findAllElementsBySelector(String selector) {
        return getPage().locator(selector).all();
    }

    public static String getElementAttributeBySelector(String selector, String attributeName) {
        return getPage().locator(selector).getAttribute(attributeName);
    }

    public static Locator findElementBySelectorAndText(String selector, String elementText) {
        return getPage().locator(selector + ":has-text(\"" + elementText + "\")");
    }
}
