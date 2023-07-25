package com.spotify.utils.navigation.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.spotify.driver.AppiumDriverHandler.getDriver;

@Component
@Slf4j
public class AndroidDeviceActions {

    public void swipeUp() {
        Map<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("percent", 1.0);
        scrollObject.put("left", 460);
        scrollObject.put("top", 1150);
        scrollObject.put("width", 300);
        scrollObject.put("height", 650);
        scrollObject.put("speed", 3500);

        ((JavascriptExecutor) getDriver()).executeScript("mobile: swipeGesture", scrollObject);
    }

    public void swipeDown() {
        Map<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "up");
        scrollObject.put("percent", 1.0);
        scrollObject.put("left", 460);
        scrollObject.put("top", 1150);
        scrollObject.put("width", 300);
        scrollObject.put("height", 650);
        scrollObject.put("speed", 3500);

        ((JavascriptExecutor) getDriver()).executeScript("mobile: swipeGesture", scrollObject);
    }

    public void swipeLeft() {
        Map<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "right");
        scrollObject.put("percent", 1.0);
        scrollObject.put("left", 460);
        scrollObject.put("top", 1150);
        scrollObject.put("width", 300);
        scrollObject.put("height", 650);
        scrollObject.put("speed", 3500);

        ((JavascriptExecutor) getDriver()).executeScript("mobile: swipeGesture", scrollObject);
    }

    public void swipeRight() {
        Map<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "left");
        scrollObject.put("percent", 1.0);
        scrollObject.put("left", 460);
        scrollObject.put("top", 1150);
        scrollObject.put("width", 300);
        scrollObject.put("height", 650);
        scrollObject.put("speed", 3500);

        ((JavascriptExecutor) getDriver()).executeScript("mobile: swipeGesture", scrollObject);
    }

    public Boolean scrollDown() {
        Map<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("percent", 3.0);
        scrollObject.put("left", 150);
        scrollObject.put("top", 150);
        scrollObject.put("width", 200);
        scrollObject.put("height", 1000);
        scrollObject.put("speed", 3000);

        return (Boolean) ((JavascriptExecutor) getDriver()).executeScript("mobile: scrollGesture", scrollObject);
    }

    public void slightlySwipeUp() {
        Map<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("percent", 0.7);
        scrollObject.put("left", 460);
        scrollObject.put("top", 1150);
        scrollObject.put("width", 300);
        scrollObject.put("height", 300);
        scrollObject.put("speed", 330);

        ((JavascriptExecutor) getDriver()).executeScript("mobile: swipeGesture", scrollObject);
    }

    public void slightlySwipeDown() {
        Map<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "up");
        scrollObject.put("percent", 0.4);
        scrollObject.put("left", 460);
        scrollObject.put("top", 1150);
        scrollObject.put("width", 300);
        scrollObject.put("height", 300);
        scrollObject.put("speed", 330);

        ((JavascriptExecutor) getDriver()).executeScript("mobile: swipeGesture", scrollObject);
    }

    public void slightlySwipeLeft() {
        Map<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "right");
        scrollObject.put("percent", 0.7);
        scrollObject.put("left", 460);
        scrollObject.put("top", 1150);
        scrollObject.put("width", 300);
        scrollObject.put("height", 300);
        scrollObject.put("speed", 330);

        ((JavascriptExecutor) getDriver()).executeScript("mobile: swipeGesture", scrollObject);
    }

    public void slightlySwipeRight() {
        Map<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "left");
        scrollObject.put("percent", 0.7);
        scrollObject.put("left", 460);
        scrollObject.put("top", 1150);
        scrollObject.put("width", 300);
        scrollObject.put("height", 300);
        scrollObject.put("speed", 330);

        ((JavascriptExecutor) getDriver()).executeScript("mobile: swipeGesture", scrollObject);
    }

    public void tapKeyboardSearchButton() {
        AppiumDriver driver = getDriver();

        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.SEARCH));
        } else {
            throw new IllegalStateException("Current driver is not an instance of Android Driver");
        }
    }
}
