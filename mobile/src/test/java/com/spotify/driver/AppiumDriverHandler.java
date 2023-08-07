package com.spotify.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.ConfigurationException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.time.Duration;

import static com.spotify.driver.AppiumDriverConstants.LOCAL_SERVER_ADDRESS;
import static com.spotify.driver.AppiumDriverConstants.WEB_DRIVER_WAIT_TIMEOUT;

@Slf4j
public class AppiumDriverHandler {

    private static final ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> webDriverWait = new ThreadLocal<>();
    public static AppiumDriverLocalService appiumDriverLocalService;

    public static void createDriver(String environment, String platformName, String deviceName, TestInfo testInfo) throws ConfigurationException, IOException {
        log.info("Creating a new driver for {}", platformName);

        String testName = testInfo.getTestMethod().map(Method::getName).orElse(null);

        try {
            appiumDriver.set(AppiumDeviceSessionFactory.getDeviceSession(environment, platformName, deviceName, testName));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AppiumDriver getDriver() {
        return appiumDriver.get();
    }

    public static WebDriverWait getWait() {
        if (webDriverWait.get() == null) {
            webDriverWait.set(new WebDriverWait(getDriver(), Duration.ofMillis(WEB_DRIVER_WAIT_TIMEOUT)));
        }
        return webDriverWait.get();
    }

    public static void launchAppiumServer() {
        appiumDriverLocalService = AppiumDriverLocalService
                .buildService(new AppiumServiceBuilder()
                        .withIPAddress(LOCAL_SERVER_ADDRESS)
                        .usingAnyFreePort()
                        .withArgument(GeneralServerFlag.SESSION_OVERRIDE));

        appiumDriverLocalService.start();
    }

    public static void closeDriver() {
        try {
            if (getDriver() != null) {
                getDriver().quit();
                appiumDriver.set(null);
                webDriverWait.set(null);
            }

            if (appiumDriverLocalService != null && appiumDriverLocalService.isRunning()) {
                appiumDriverLocalService.stop();
                log.info("A running Appium server was found and stopped as part of the tear down");
            }

            log.info("Appium driver has been closed");

        } catch (Exception e) {
            log.warn("Couldn't close the Appium driver due to: ", e);
        }
    }
}
