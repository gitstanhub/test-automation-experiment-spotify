package com.spotify.utils;

import com.microsoft.playwright.ElementHandle;
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

    public Locator findElementByExactText(String elementText) {
        return getPage().getByText(elementText, new Page.GetByTextOptions().setExact(true));
    }

    public Locator findElementByTestId(String testId) {
        return getPage().getByTestId(testId);
    }

    public Locator findElementById(String idAttribute) {
        return getPage().locator("#" + idAttribute);
    }

    public Locator findElementByRole(AriaRole role, String elementText) {
        return getPage().getByRole(role, new Page.GetByRoleOptions().setName(elementText).setExact(true));
    }

    public Locator findElementBySelector(String selector) {
        return getPage().locator(selector);
    }

    public List<Locator> findAllElementsBySelector(String selector) {
        return getPage().locator(selector).all();
    }

    public String getElementAttributeBySelector(String selector, String attributeName) {
        return getPage().locator(selector).getAttribute(attributeName);
    }

    public Locator findElementBySelectorAndText(String selector, String elementText) {
        return getPage().locator(selector + ":has-text(\"" + elementText + "\")");
    }
}
