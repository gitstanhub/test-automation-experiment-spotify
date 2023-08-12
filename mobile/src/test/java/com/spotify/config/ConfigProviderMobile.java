package com.spotify.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.neovisionaries.i18n.CountryCode;
import com.spotify.config.appium.AppiumDriverConfiguration;
import com.spotify.config.appium.BrowserstackAuthConfiguration;
import com.spotify.config.appium.BrowserstackAndroidSessionConfiguration;
import com.spotify.config.appium.app.MobileAppAuthConfiguration;
import com.spotify.config.appium.app.MobileAppConfiguration;
import com.spotify.config.appium.app.MobileAppLocaleConfig;
import com.spotify.config.appium.device.commons.DeviceConfig;
import com.spotify.config.appium.entities.EntityConfig;
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
    private static final BrowserstackAndroidSessionConfiguration browserstackAndroidSessionConfiguration = ConfigFactory.create(
            BrowserstackAndroidSessionConfiguration.class, System.getProperties());

    @Getter
    private static final BrowserstackAuthConfiguration browserstackAuthConfiguration = ConfigFactory.create(
            BrowserstackAuthConfiguration.class, System.getProperties());

    @Getter
    private static final MobileAppAuthConfiguration mobileAppAuthConfiguration = ConfigFactory.create(
            MobileAppAuthConfiguration.class, System.getProperties());

    @Getter
    private static final MobileAppConfiguration mobileAppConfiguration = ConfigFactory.create(
            MobileAppConfiguration.class, System.getProperties());

    @Getter
    private static final MobileAppLocaleConfig mobileAppLocaleConfig = ConfigFactory.create(
            MobileAppLocaleConfig.class, System.getProperties());

    public static <T extends DeviceConfig> T getDeviceConfig(String deviceName, Class<T> configClass) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        String fileName = "configuration/devices/"
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

    public static <T extends EntityConfig> T getEntityConfig(CountryCode market, String configItemName, Class<T> configClass) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        String fileName = "configuration/entities/"
                + market.toString().toLowerCase()
                + "_"
                + configClass.getSimpleName().toLowerCase()
                + ".json";

        URL fileUrl = ClassLoader.getSystemResource(fileName);
        if (fileUrl == null) {
            throw new FileNotFoundException("File " + fileName + " was not found.");
        }

        File entityConfigFile = new File(fileUrl.getFile());

        List<T> entityConfigList = objectMapper.readValue(entityConfigFile, objectMapper.getTypeFactory().constructCollectionType(List.class, configClass));

        for (T entityConfig : entityConfigList) {
            if (entityConfig.getConfigItemName().equals(configItemName)) {
                return entityConfig;
            }
        }

        throw new IllegalArgumentException("No entity configuration found for the given entity item name: " + configItemName);
    }
}
