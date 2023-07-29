package com.spotify.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.spotify.config.appium.AppiumDriverConfiguration;
import com.spotify.config.appium.BrowserstackAuthConfiguration;
import com.spotify.config.appium.BrowserstackAndroidConfiguration;
import com.spotify.config.appium.device.browserstack.BrowserstackDeviceConfig;
import com.spotify.config.appium.device.commons.DeviceConfig;
import com.spotify.config.appium.device.local.LocalDeviceConfig;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ConfigProviderMobile {

    @Getter
    private static final AppiumDriverConfiguration appiumDriverConfiguration = ConfigFactory.create(
            AppiumDriverConfiguration.class, System.getProperties());

    @Getter
    private static final BrowserstackAndroidConfiguration browserstackAndroidConfiguration = ConfigFactory.create(
            BrowserstackAndroidConfiguration.class, System.getProperties());

    @Getter
    private static final BrowserstackAuthConfiguration browserstackAuthConfiguration = ConfigFactory.create(
            BrowserstackAuthConfiguration.class, System.getProperties());

//    public static AppiumDriverConfiguration getAppiumDriverConfiguration() {
//        return appiumDriverConfiguration;
//    }

//    public static BrowserstackSessionConfiguration getBrowserstackSessionConfiguration() {
//        return browserstackSessionConfiguration;
//    }

//    public static BrowserstackAuthConfiguration getBrowserstackAuthConfiguration() {
//        return browserstackAuthConfiguration;
//    }

    public static <T extends DeviceConfig> T getDeviceConfig(String deviceName, Class<T> configClass) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        String fileName = "configuration/"
                + appiumDriverConfiguration.environment().toLowerCase()
                + "_"
                + appiumDriverConfiguration.platformName().toLowerCase()
                + "_devices.json";

        URL fileUrl = ClassLoader.getSystemResource(fileName);
        if (fileUrl == null) {
            throw new FileNotFoundException("File " + fileName + " was not found.");
        }

        File deviceConfigFile = new File(fileUrl.getFile());

        List<T> deviceConfigList = objectMapper.readValue(deviceConfigFile, objectMapper.getTypeFactory().constructCollectionType(List.class, configClass));

        for (T deviceConfig : deviceConfigList) {
            if (deviceConfig.getConfigItemName().equals(deviceName)) {
                return deviceConfig;
            }
        }

        throw new IllegalArgumentException("No device configuration found for the given device name: " + deviceName);
    }
}
