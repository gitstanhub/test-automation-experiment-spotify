package com.spotify.pageobjects.commons;

import com.microsoft.playwright.Locator;
import com.spotify.config.ConfigProviderWeb;
import com.spotify.pageobjects.base.PlaywrightPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.PlaywrightDriverHandler.getPage;
import static com.spotify.locators.commons.OptionsMenuLocators.CONTEXT_MENU;
import static com.spotify.locators.commons.OptionsMenuLocators.EDIT_DETAILS_OPTION;

@Component
@Lazy
@Slf4j
public class OptionsMenu extends PlaywrightPage {

    @Step
    public OptionsMenu verifyOptionsMenuIsAvailable() {
        getPage().waitForSelector("div[id='context-menu']");
        Assertions.assertTrue(elementChecks.isElementVisible(findContextMenu()));
        return this;
    }

    @Step
    public OptionsMenu clickEditDetailsOption() {
        findEditDetailsOption().click();
        return this;
    }

    private Locator findContextMenu() {
        return elementActions.findElementBySelector(CONTEXT_MENU);
    }

    private Locator findEditDetailsOption() {
        return elementActions.findElementBySelectorAndText(EDIT_DETAILS_OPTION, ConfigProviderWeb.getWebAppLocaleConfig().editDetailsOptionText());
    }
}
