package com.spotify.android.driver;

import com.spotify.android.config.ConfigProviderMobile;
import com.spotify.android.config.LocalAndroidDeviceConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.naming.ConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDeviceSessionFactory {

    public static AppiumDriver getDeviceSession(String environment, String platformName, String deviceName) throws ConfigurationException, MalformedURLException, IOException {

        switch (environment) {
            case "local":
                return getLocalSession(deviceName, platformName);
            case "browserStack":
                return getBrowserstackSession(deviceName, platformName);
            default:
                String errorMessage = String.format("The passed environment argument of type '%s' is not supported in this framework", environment);
                throw new ConfigurationException(errorMessage);
        }
    }

    private static AppiumDriver getLocalSession(String deviceName, String platformName) throws ConfigurationException, MalformedURLException, IOException {
        switch (platformName) {
            case "android":
                return getLocalAndroidSession(deviceName);
            default:
                throw new ConfigurationException("Invalid platform type is provided: " + platformName);
        }
    }

    private static AndroidDriver getLocalAndroidSession(String deviceName) throws MalformedURLException, IOException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigProviderMobile.getDeviceConfig(deviceName, LocalAndroidDeviceConfig.class).getDeviceName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigProviderMobile.getDeviceConfig(deviceName, LocalAndroidDeviceConfig.class).getPlatformName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigProviderMobile.getDeviceConfig(deviceName, LocalAndroidDeviceConfig.class).getOsVersion());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigProviderMobile.getDeviceConfig(deviceName, LocalAndroidDeviceConfig.class).getAutomationName());
        capabilities.setCapability(MobileCapabilityType.UDID, ConfigProviderMobile.getDeviceConfig(deviceName, LocalAndroidDeviceConfig.class).getUdid());
        capabilities.setCapability(MobileCapabilityType.NO_RESET, ConfigProviderMobile.getDeviceConfig(deviceName, LocalAndroidDeviceConfig.class).isNoReset());
        capabilities.setCapability("appPackage", "com.spotify.music");
        capabilities.setCapability("appActivity", "com.spotify.music.MainActivity");
        AppiumDriverHandler.launchAppiumServer();

        return new AndroidDriver(AppiumDriverHandler.appiumDriverLocalService.getUrl(), capabilities);
    }

    private static AndroidDriver getBrowserstackSession(String deviceName, String platformName) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        return new AndroidDriver(new URL("https://browserstack.com"), capabilities);
    }
}
