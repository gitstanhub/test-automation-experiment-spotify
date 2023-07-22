package com.spotify.config.appium;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfiguration {

    public static AnnotationConfigApplicationContext setConfig(String platformName) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        switch (platformName) {
            case "android" -> setAndroidConfig(applicationContext);

            default -> {
                String errorMessage = String.format("The provided platform of type %s is not supported", platformName);
                throw new IllegalArgumentException(errorMessage);
            }
        }

        applicationContext.refresh();

        return applicationContext;
    }

    private static void setAndroidConfig(AnnotationConfigApplicationContext applicationContext) {
        applicationContext.register();
    }
}
