package com.spotify.driver;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.config.appium.device.browserstack.BrowserstackAndroidDeviceConfig;
import com.spotify.config.appium.device.local.LocalAndroidDeviceConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.naming.ConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDeviceSessionFactory {

    public static AppiumDriver getDeviceSession(String environment, String platformName, String deviceName, String testName) throws ConfigurationException, MalformedURLException, IOException {

        switch (environment) {
            case "local" -> {
                return getLocalSession(deviceName, platformName);
            }
            case "browserstack" -> {
                return getBrowserstackSession(deviceName, platformName, testName);
            }
            default -> {
                String errorMessage = String.format("The passed environment argument of type '%s' is not supported in this framework", environment);
                throw new ConfigurationException(errorMessage);
            }
        }
    }

    private static AppiumDriver getLocalSession(String deviceName, String platformName) throws ConfigurationException, MalformedURLException, IOException {
        switch (platformName) {
            case "android" -> {
                return getLocalAndroidSession(deviceName);
            }

            default -> {
                String errorMessage = String.format("Invalid platform of type %s is provided", platformName);
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    private static AndroidDriver getLocalAndroidSession(String deviceName) throws MalformedURLException, IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigProviderMobile.getDeviceConfig(deviceName, LocalAndroidDeviceConfig.class).getDeviceName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigProviderMobile.getDeviceConfig(deviceName, LocalAndroidDeviceConfig.class).getPlatformName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigProviderMobile.getDeviceConfig(deviceName, LocalAndroidDeviceConfig.class).getPlatformVersion());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigProviderMobile.getDeviceConfig(deviceName, LocalAndroidDeviceConfig.class).getAutomationName());
        capabilities.setCapability(MobileCapabilityType.UDID, ConfigProviderMobile.getDeviceConfig(deviceName, LocalAndroidDeviceConfig.class).getUdid());
        capabilities.setCapability(MobileCapabilityType.NO_RESET, ConfigProviderMobile.getDeviceConfig(deviceName, LocalAndroidDeviceConfig.class).isNoReset());
        capabilities.setCapability("appPackage", "com.spotify.music");
        capabilities.setCapability("appActivity", "com.spotify.music.MainActivity");

        AppiumDriverHandler.launchAppiumServer();

        return new AndroidDriver(AppiumDriverHandler.appiumDriverLocalService.getUrl(), capabilities);
    }

    private static AppiumDriver getBrowserstackSession(String deviceName, String platformName, String testName) throws ConfigurationException, MalformedURLException, IOException {
        switch (platformName) {
            case "android" -> {
                return getBrowserstackAndroidSession(deviceName, testName);
            }

            default -> {
                String errorMessage = String.format("Invalid platform of type %s is provided", platformName);
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    private static AndroidDriver getBrowserstackAndroidSession(String deviceName, String testName) throws ConfigurationException, MalformedURLException, IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", ConfigProviderMobile.getDeviceConfig(deviceName, BrowserstackAndroidDeviceConfig.class).getDeviceName());
        capabilities.setCapability("platformName", ConfigProviderMobile.getDeviceConfig(deviceName, BrowserstackAndroidDeviceConfig.class).getPlatformName());
        capabilities.setCapability("platformVersion", ConfigProviderMobile.getDeviceConfig(deviceName, BrowserstackAndroidDeviceConfig.class).getPlatformVersion());
        capabilities.setCapability("project", ConfigProviderMobile.getBrowserstackAndroidSessionConfiguration().browserstackProjectName());
        capabilities.setCapability("build", ConfigProviderMobile.getBrowserstackAndroidSessionConfiguration().browserstackBuildName());
        capabilities.setCapability("name", testName);
        capabilities.setCapability("browserstack.debug", ConfigProviderMobile.getBrowserstackAndroidSessionConfiguration().browserstackDebug());
        capabilities.setCapability("app", ConfigProviderMobile.getBrowserstackAndroidSessionConfiguration().browserstackAppUrl());

        return new AndroidDriver(new URL(String.format(ConfigProviderMobile.getBrowserstackAndroidSessionConfiguration().browserstackRemoteUrl(), ConfigProviderMobile.getBrowserstackAuthConfiguration().browserstackUsername(), ConfigProviderMobile.getBrowserstackAuthConfiguration().browserstackAccessToken())), capabilities);
    }
}
