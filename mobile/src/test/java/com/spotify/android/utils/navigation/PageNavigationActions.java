package com.spotify.android.utils.navigation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class PageNavigationActions {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public PageNavigationActions(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement scrollToElementWithInnerText(String scrollableElementResourceId, String scrollTargetResourceId, String scrollTargetText) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiScrollable(new UiSelector().resourceId(\"%s\"))" +
                                ".scrollIntoView(new UiSelector().resourceId(\"%s\").text(\"%s\"))",
                        scrollableElementResourceId, scrollTargetResourceId, scrollTargetText)));
    }

//    public WebElement scrollToElementWithInnerTextTemp(String scrollTargetResourceId, String scrollTargetText) {
//        String uiSelector = "new UiSelector().resourceId(\"" + scrollTargetResourceId + "\").text(\"" + scrollTargetText + "\")";
//        String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" + uiSelector + ")";
//
//        return driver.findElement(AppiumBy.androidUIAutomator(uiScrollable));
//    }

//    public WebElement scrollToElementWithInnerTextTemp(String scrollableElementResourceId, String scrollTargetResourceId, String scrollTargetText) {
//        String xpath = String.format("//*[@resource-id='%s' and @text='%s']", scrollTargetResourceId, scrollTargetText);
//
//        return wait.until(driver -> {
//            driver.findElement(AppiumBy.androidUIAutomator(
//                    "new UiScrollable(new UiSelector().resourceId(\"" + scrollableElementResourceId + "\")).scrollForward()"
//            ));
//            return driver.findElement(By.xpath(xpath));
//        });
//    }

    public WebElement scrollToElementWithInnerTextTemp(String scrollTargetResourceId, String scrollTargetText) {
        String xpath = String.format("//*[@resource-id='%s' and @text='%s']", scrollTargetResourceId, scrollTargetText);

        return wait.until(driver -> {

            Map<String, Object> scrollObject = new HashMap<>();
            scrollObject.put("direction", "down");
            scrollObject.put("percent", 1.5);
            scrollObject.put("left", 80);
            scrollObject.put("top", 320);
            scrollObject.put("width", 400);
            scrollObject.put("height", 1400);

            boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", scrollObject);

            while (canScrollMore && driver.findElements(By.xpath(xpath)).size() == 0) {
                canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", scrollObject);
            }

            return driver.findElement(By.xpath(xpath));
        });
    }


    public WebElement scrollToElementWithDescriptionAttribute(String scrollableElementResourceId, String scrollTargetDescription) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiScrollable(new UiSelector().resourceId(\"%s\"))" +
                                ".scrollIntoView(new UiSelector().description(\"%s\"))",
                        scrollableElementResourceId, scrollTargetDescription)));
    }
}
