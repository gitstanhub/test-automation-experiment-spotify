package com.spotify.android.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.naming.ConfigurationException;
import java.util.Arrays;

public class AppiumDeviceFactory {

    public static AppiumDriver getDevice(String environment, String platformName, String deviceName) throws ConfigurationException {

//        validateEnvironment(ConfigProvider.getApplicationConfig.environment())
        //validatePlatformName(ConfigProvider.getApplicationConfig.platformName())
        //validateDeviceName(ConfigProvider.getApplicationConfig.platformName())

        switch (environment) {
            case "local":
//                return getLocalDevice(deviceName, platformName);
            case "browserStack":
//                return getBrowserStackDevice(deviceName, platformName);
            default:
                String errorMessage = String.format("Couldn't find a device creation method for the environment of type %s", environment);
                throw new ConfigurationException(errorMessage);
        }
    }

//    private static void validateEnvironment(String environment) throws ConfigurationException {
//        if (!Arrays.asList("local", "browserstack").contains(environment)) {
//            throw new ConfigurationException("Invalid environment type is provided: " + environment);
//        }
//    }

    private static void validatePlatform(String platformName) throws ConfigurationException {
        if (!platformName.equals("android")) {
            throw new ConfigurationException("Invalid platform type is provided: " + platformName);
    }}

    private static void validateDeviceName(String deviceName) throws ConfigurationException {

    }

    private static AppiumDriver getLocalDriver(String deviceName, String platformName) throws ConfigurationException {
        switch (platformName) {
            case "android":
//                return getLocalAndroidDevice(deviceName);
            default:
                throw new ConfigurationException("Invalid platform type is provided: " + platformName);
        }
    }

    private static AndroidDriver getLocalAndroidDriver(String deviceName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);

        return new AndroidDriver(AppiumDriverHandler.appiumDriverLocalService.getUrl(), capabilities);
    }

}
