package com.spotify.android.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.naming.ConfigurationException;

public class AppiumDeviceSessionFactory {

    public static AppiumDriver getDeviceSession(String environment, String platformName, String deviceName) throws ConfigurationException {

        //validateDeviceName(ConfigProvider.getApplicationConfig.platformName())

        switch (environment) {
            case "local":
                return getLocalSession(deviceName, platformName);
            case "browserStack":
//                return getBrowserStackSession(deviceName, platformName);
            default:
                String errorMessage = String.format("The passed environment argument of type '%s' is not supported in this framework", environment);
                throw new ConfigurationException(errorMessage);
        }
    }

    private static void validateDeviceName(String deviceName) throws ConfigurationException {

    }

    private static AppiumDriver getLocalSession(String deviceName, String platformName) throws ConfigurationException {
        switch (platformName) {
            case "android":
                return getLocalAndroidSession(deviceName);
            default:
                throw new ConfigurationException("Invalid platform type is provided: " + platformName);
        }
    }

    private static AndroidDriver getLocalAndroidSession(String deviceName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, );


        return new AndroidDriver(AppiumDriverHandler.appiumDriverLocalService.getUrl(), capabilities);
    }

}
