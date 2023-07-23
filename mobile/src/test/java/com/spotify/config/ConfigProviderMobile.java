package com.spotify.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.spotify.config.appium.AppiumDriverConfiguration;
import com.spotify.config.appium.device.DeviceConfig;
import org.aeonbits.owner.ConfigFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ConfigProviderMobile {

    private static final AppiumDriverConfiguration appiumDriverConfiguration = ConfigFactory.create(
            AppiumDriverConfiguration.class, System.getProperties());

    public static AppiumDriverConfiguration getAppiumDriverConfiguration() {
        return appiumDriverConfiguration;
    }

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

        throw new IllegalArgumentException("No device configuration found for the given device name: " + appiumDriverConfiguration.deviceName());
    }
}
