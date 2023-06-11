package com.spotify.android.pageobjects.commons;

import com.spotify.android.pageobjects.commons.base.PermissionAccessPrompt;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BluetoothAccessPrompt extends PermissionAccessPrompt {

    public BluetoothAccessPrompt(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void handleAccessPrompt() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.spotify.music:id/design_bottom_sheet")));
            if (getAccessWidgetDescription().getText().contains("Bluetooth")) {
                getAccessWidgetLaterButton().click();
            }
        } catch (TimeoutException e) {
            System.out.println("No Bluetooth Access Prompt is visible to handle. Proceeding further...");
        }
    }

    protected WebElement getAccessWidget() {
        return driver.findElement(By.id("com.spotify.music:id/design_bottom_sheet"));
    }

    protected WebElement getAccessWidgetTitle() {
        return driver.findElement(By.id("com.spotify.music:id/title"));
    }

    protected WebElement getAccessWidgetDescription() {
        return driver.findElement(By.id("com.spotify.music:id/description"));
    }

    protected WebElement getAccessWidgetAcceptButton() {
        return driver.findElement(By.id("com.spotify.music:id/proceed_button"));
    }

    protected WebElement getAccessWidgetLaterButton() {
        return driver.findElement(By.id("com.spotify.music:id/later_button"));
    }
}
