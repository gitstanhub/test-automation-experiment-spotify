package com.spotify.android.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.spotify.android.config.appium.AppiumDriverConfiguration;
import org.aeonbits.owner.ConfigFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConfigProviderMobile {

    private static final AppiumDriverConfiguration appiumDriverConfiguration = ConfigFactory.create(
            AppiumDriverConfiguration.class, System.getProperties());

    public static AppiumDriverConfiguration getAppiumDriverConfiguration() {
        return appiumDriverConfiguration;
    }

    public static <T extends DeviceConfig> T getDeviceConfig(String deviceName, Class<T> configClass) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        String fileName = appiumDriverConfiguration.environment().toLowerCase()
                + "_" + appiumDriverConfiguration.platformName().toLowerCase()
                + "_devices.json";

        List<T> deviceConfigList = objectMapper.readValue(new File(fileName), objectMapper.getTypeFactory().constructCollectionType(List.class, configClass));

        for (T deviceConfig : deviceConfigList) {
            if (deviceConfig.getConfigItemName().equals(deviceName)) {
                return deviceConfig;
            }
        }

        throw new IllegalArgumentException("No device configuration found for the given device name: " + appiumDriverConfiguration.deviceName());
    }
}
