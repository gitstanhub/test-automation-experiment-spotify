package com.spotify.android.utils.assertions;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class ElementChecks {

    public ElementChecks assertElementIsVisible(WebElement element) {
        Assertions.assertTrue(element.isDisplayed(), "Element with id: " + element.getAttribute("resource-id") + " is not visible");
        return this;
    }

}
