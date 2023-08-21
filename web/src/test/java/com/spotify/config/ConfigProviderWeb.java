package com.spotify.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.neovisionaries.i18n.CountryCode;
import com.spotify.config.app.WebAppAuthConfiguration;
import com.spotify.config.app.WebAppConfiguration;
import com.spotify.config.app.WebAppLocaleConfig;
import com.spotify.config.entities.EntityConfig;
import com.spotify.config.playwright.PlaywrightBrowserConfiguration;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ConfigProviderWeb {

    @Getter
    private static final PlaywrightBrowserConfiguration playwrightBrowserConfiguration = ConfigFactory.create(
            PlaywrightBrowserConfiguration.class, System.getProperties());

    @Getter
    private static final WebAppAuthConfiguration webAppAuthConfiguration = ConfigFactory.create(
            WebAppAuthConfiguration.class, System.getProperties());

    @Getter
    private static final WebAppConfiguration webAppConfiguration = ConfigFactory.create(
            WebAppConfiguration.class, System.getProperties());

    @Getter
    private static final WebAppLocaleConfig webAppLocaleConfig = ConfigFactory.create(
            WebAppLocaleConfig.class, System.getProperties());

    public static <T extends EntityConfig> T getEntityConfig(CountryCode countryCode, String configItemName, Class<T> configClass) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        String fileName = "configuration/entities/"
                + countryCode.toString().toLowerCase()
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
