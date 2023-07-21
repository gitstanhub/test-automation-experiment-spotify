package com.spotify.android.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.extern.slf4j.Slf4j;

import javax.naming.ConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;

import static com.spotify.android.driver.AppiumDriverConstants.LOCAL_SERVER_ADDRESS;

@Slf4j
public class AppiumDriverHandler {

    private static ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();
    private static AppiumDeviceSessionFactory appiumDeviceSessionFactory;
    public static AppiumDriverLocalService appiumDriverLocalService;

    public static void createDriver(String environment, String platformName, String deviceName) throws ConfigurationException, MalformedURLException, IOException {
        log.info("Creating a new driver for {}", platformName);
        appiumDriver.set(AppiumDeviceSessionFactory.getDeviceSession(environment, platformName, deviceName));
    }

    public static AppiumDriver getDriver() {
        return appiumDriver.get();
    }

    static void launchAppiumServer() {
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



//    private static AndroidDriver driver;
//    private static WebDriverWait wait;
//
//    private void setUp() throws MalformedURLException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//
//        desiredCapabilities.setCapability("appPackage", "com.spotify.music");
//        desiredCapabilities.setCapability("appActivity", "com.spotify.music.MainActivity");
//        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID);
//        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
//        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
//        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 (Android 13) - Emulated");
//        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
//        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, false);
//
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
//
//        System.out.println("Real-device driver is selected");
//    }
//
//    public static AndroidDriver getDriver() {
//        if (driver == null) {
//            AppiumDriverHandler realDeviceAppiumDriverHandler = new AppiumDriverHandler();
//            try {
//                realDeviceAppiumDriverHandler.setUp();
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//        }
//        return driver;
//    }
//
//    public static WebDriverWait getWait() {
//        wait = new WebDriverWait(driver, Duration.ofMillis(4000));
//        return wait;
//    }




    //ToDo Factory: get local / browserstack driver
    //ToDo move all variables to Config


    //ToDo use this method in the factory
//    public void startService() {
//        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                .usingAnyFreePort() // Use any free port, it could be different for every new server instance
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE) // Override session if any
//                .withLogFile(new File("path/to/log/file"))); // Specify a file to output server logs
//                  .withIPadress("127.0.0.1")
//        service.start();
//    }


    //ToDo add support for ctx and include it into before method: config/ApplicationCofniguration, depending on platorm, do ctx.register for pages and then ctx.getBean of interface class of a page
}
