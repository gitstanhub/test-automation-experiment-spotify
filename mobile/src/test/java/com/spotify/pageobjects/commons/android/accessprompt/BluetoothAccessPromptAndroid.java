package com.spotify.pageobjects.commons.android.accessprompt;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.commons.interfaces.accessprompt.BluetoothAccessPrompt;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getDriver;
import static com.spotify.driver.AppiumDriverHandler.getWait;
import static com.spotify.locators.commons.BluetoothAccessPromptLocators.*;

@Component
@Lazy
@Slf4j
public class BluetoothAccessPromptAndroid extends AppiumPageAndroid implements BluetoothAccessPrompt {

    public void handleAccessPrompt() {
        try {
            getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(ACCESS_WIDGET_TOUCH_OUTSIDE_AREA)));
            getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(ACCESS_WIDGET)));
            if (getAccessWidgetDescription().getText().contains("Bluetooth")) {
                getAccessWidgetLaterButton().click();
            }
        } catch (TimeoutException e) {
            log.info("No Bluetooth Access Prompt is visible to handle. Proceeding further...");
//            System.out.println("No Bluetooth Access Prompt is visible to handle. Proceeding further...");
        }
    }

    protected WebElement getAccessWidget() {
        return androidElementActions.getElementById(ACCESS_WIDGET);
    }

    protected WebElement getAccessWidgetTitle() {
        return androidElementActions.getElementById(ACCESS_WIDGET_TITLE);
    }

    protected WebElement getAccessWidgetDescription() {
        return androidElementActions.getElementById(ACCESS_WIDGET_DESCRIPTION);
    }

    protected WebElement getAccessWidgetAcceptButton() {
        return androidElementActions.getElementById(ACCESS_WIDGET_ACCEPT_BUTTON);
    }

    protected WebElement getAccessWidgetLaterButton() {
        return androidElementActions.getElementById(ACCESS_WIDGET_LATER_BUTTON);
    }

    protected WebElement getTouchOutsideArea() {
        return androidElementActions.getElementById(ACCESS_WIDGET_TOUCH_OUTSIDE_AREA);
    }
}
