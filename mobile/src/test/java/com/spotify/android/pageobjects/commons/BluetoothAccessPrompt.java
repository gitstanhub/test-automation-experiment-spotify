package com.spotify.android.pageobjects.commons;

import com.spotify.android.pageobjects.commons.base.PermissionAccessPrompt;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BluetoothAccessPrompt extends PermissionAccessPrompt {

    public BluetoothAccessPrompt(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void handleAccessPrompt() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.spotify.music:id/touch_outside")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.spotify.music:id/design_bottom_sheet")));
            if (getAccessWidgetDescription().getText().contains("Bluetooth")) {
                getAccessWidgetLaterButton().click();
            }
        } catch (TimeoutException e) {
            System.out.println("No Bluetooth Access Prompt is visible to handle. Proceeding further...");
        }
    }

//    public void handleAccessPrompt() {
//        FluentWait<AndroidDriver> fLuentWait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofMillis(6000))
//                .pollingEvery(Duration.ofMillis(2000))
//                .ignoring(NoSuchElementException.class);
//
//        try {
//            fLuentWait.until(driver) -> {
//                WebElement element = driver.
//
//            }
//        }
//    }

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

    protected WebElement getTouchOutsideArea() {
        return driver.findElement(By.id("com.spotify.music:id/touch_outside"));
    }
}
