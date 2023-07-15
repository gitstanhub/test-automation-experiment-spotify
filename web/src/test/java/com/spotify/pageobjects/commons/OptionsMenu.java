package com.spotify.pageobjects.commons;

import com.microsoft.playwright.Locator;
import com.spotify.pageobjects.base.PlaywrightPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.PlaywrightDriverHandler.getPage;

@Component
@Lazy
@Slf4j
public class OptionsMenu extends PlaywrightPage {

    public OptionsMenu verifyOptionsMenuIsAvailable() {
       getPage().waitForSelector("div[id='context-menu']");
        Assertions.assertTrue(elementChecks.isElementVisible(findContextMenu()));
        return this;
    }

    public OptionsMenu clickEditDetailsOption() {
        findEditDetailsOption().click();
        return this;
    }

    private Locator findContextMenu() {
        return elementActions.findElementBySelector("div[id='context-menu']");
    }

    private Locator findEditDetailsOption() {
        return elementActions.findElementBySelectorAndText("div[id='context-menu'] button[role='menuitem']", "Edit details");
    }
}
