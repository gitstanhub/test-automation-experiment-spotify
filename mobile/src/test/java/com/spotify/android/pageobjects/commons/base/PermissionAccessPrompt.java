package com.spotify.android.pageobjects.commons.base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PermissionAccessPrompt {

    protected final AndroidDriver driver;
    protected final WebDriverWait wait;

    protected PermissionAccessPrompt(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public abstract void handleAccessPrompt();
    protected abstract WebElement getAccessWidget();
    protected abstract WebElement getAccessWidgetTitle();
    protected abstract WebElement getAccessWidgetDescription();
    protected abstract WebElement getAccessWidgetAcceptButton();
    protected abstract WebElement getAccessWidgetLaterButton();
}
