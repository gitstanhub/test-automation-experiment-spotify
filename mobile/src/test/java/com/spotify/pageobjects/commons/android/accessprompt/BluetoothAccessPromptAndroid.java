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

@Component
@Lazy
@Slf4j
public class BluetoothAccessPromptAndroid extends AppiumPageAndroid implements BluetoothAccessPrompt {

    public void handleAccessPrompt() {
        try {
            getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("com.spotify.music:id/touch_outside")));
            getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("com.spotify.music:id/design_bottom_sheet")));
            if (getAccessWidgetDescription().getText().contains("Bluetooth")) {
                getAccessWidgetLaterButton().click();
            }
        } catch (TimeoutException e) {
            System.out.println("No Bluetooth Access Prompt is visible to handle. Proceeding further...");
        }
    }

    protected WebElement getAccessWidget() {
        return androidElementActions.getElementById("com.spotify.music:id/design_bottom_sheet");
    }

    protected WebElement getAccessWidgetTitle() {
        return androidElementActions.getElementById("com.spotify.music:id/title");
    }

    protected WebElement getAccessWidgetDescription() {
        return androidElementActions.getElementById("com.spotify.music:id/description");
    }

    protected WebElement getAccessWidgetAcceptButton() {
        return androidElementActions.getElementById("com.spotify.music:id/proceed_button");
    }

    protected WebElement getAccessWidgetLaterButton() {
        return androidElementActions.getElementById("com.spotify.music:id/later_button");
    }

    protected WebElement getTouchOutsideArea() {
        return androidElementActions.getElementById("com.spotify.music:id/touch_outside");
    }
}
