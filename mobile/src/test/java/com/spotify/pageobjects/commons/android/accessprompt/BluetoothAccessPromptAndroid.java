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
        return getDriver().findElement(By.id("com.spotify.music:id/design_bottom_sheet"));
    }

    protected WebElement getAccessWidgetTitle() {
        return getDriver().findElement(By.id("com.spotify.music:id/title"));
    }

    protected WebElement getAccessWidgetDescription() {
        return getDriver().findElement(By.id("com.spotify.music:id/description"));
    }

    protected WebElement getAccessWidgetAcceptButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/proceed_button"));
    }

    protected WebElement getAccessWidgetLaterButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/later_button"));
    }

    protected WebElement getTouchOutsideArea() {
        return getDriver().findElement(By.id("com.spotify.music:id/touch_outside"));
    }
}

//    public BluetoothAccessPromptAndroid(AndroidDriver driver, WebDriverWait wait) {
//        super(driver, wait);
//    }

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