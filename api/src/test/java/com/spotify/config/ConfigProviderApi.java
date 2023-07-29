package com.spotify.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.neovisionaries.i18n.CountryCode;
import com.spotify.config.restassured.RestAssuredApiAuthConfiguration;
import com.spotify.config.restassured.RestAssuredApiConfiguration;
import com.spotify.config.restassured.entities.EntityConfig;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ConfigProviderApi {

    @Getter
    private static final RestAssuredApiConfiguration restAssuredApiConfiguration = ConfigFactory.create(
            RestAssuredApiConfiguration.class, System.getProperties());

    @Getter
    private static final RestAssuredApiAuthConfiguration restAssuredApiAuthConfiguration = ConfigFactory.create(
            RestAssuredApiAuthConfiguration.class, System.getProperties());

//    public static RestAssuredApiConfiguration getRestAssuredApiConfiguration() {
//        return restAssuredApiConfiguration;
//    }
//
//    public static RestAssuredApiAuthConfiguration getRestAssuredApiAuthConfiguration() {
//        return restAssuredApiAuthConfiguration;
//    }

    public static <T extends EntityConfig> T getEntityConfig(CountryCode market, String configItemName, Class<T> configClass) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        String fileName = "configuration/entities/"
                + market.toString().toLowerCase()
                + "_"
                + configClass.getSimpleName().toLowerCase()
                + ".json";

        System.out.println(fileName + " heeey");

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