package com.spotify.android.utils.navigation;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;
import java.util.Map;

public class AndroidDeviceGestures {

    private final AndroidDriver driver;

    public AndroidDeviceGestures(AndroidDriver driver) {
        this.driver = driver;
    }

    public void swipeUp() {
        Map<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("percent", 1.0);
        scrollObject.put("left", 460);
        scrollObject.put("top", 1150);
        scrollObject.put("width", 300);
        scrollObject.put("height", 650);
        scrollObject.put("speed", 3500);

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", scrollObject);
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

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", scrollObject);
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

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", scrollObject);
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

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", scrollObject);
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

        return (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", scrollObject);
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

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", scrollObject);
    }

    public void slightlySwipeDown() {
        Map<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "up");
        scrollObject.put("percent", 0.7);
        scrollObject.put("left", 460);
        scrollObject.put("top", 1150);
        scrollObject.put("width", 300);
        scrollObject.put("height", 300);
        scrollObject.put("speed", 330);

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", scrollObject);
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

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", scrollObject);
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

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", scrollObject);
    }
}
