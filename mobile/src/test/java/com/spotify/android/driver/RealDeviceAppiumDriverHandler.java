package com.spotify.android.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class RealDeviceAppiumDriverHandler {

    private static AndroidDriver driver;
    private WebDriverWait wait;

    private void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("appPackage", "com.spotify.music");
        desiredCapabilities.setCapability("appActivity", "com.spotify.music.MainActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "01021FFBA000PH");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 XL Android 13");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);

        System.out.println("Real-device driver is selected");
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            RealDeviceAppiumDriverHandler realDeviceAppiumDriverHandler = new RealDeviceAppiumDriverHandler();
            try {
                realDeviceAppiumDriverHandler.setUp();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public WebDriverWait getWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }

    public void commonTearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
