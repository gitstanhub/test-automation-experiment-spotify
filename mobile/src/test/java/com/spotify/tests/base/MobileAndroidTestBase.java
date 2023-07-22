package com.spotify.tests.base;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.driver.AppiumDriverHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javax.naming.ConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;

public class MobileAndroidTestBase {

//    private final AppiumDriverHandler realDeviceAppiumDriverHandler = new AppiumDriverHandler();
//    protected final AndroidDriver driver = AppiumDriverHandler.getDriver();
//    protected final WebDriverWait wait = AppiumDriverHandler.getWait();
//    private final LoginPage loginPage = new LoginPage(driver, wait);
//    private final BluetoothAccessPrompt bluetoothAccessPrompt = new BluetoothAccessPrompt(driver, wait);
//    private final ScreensaverAd screensaverAd = new ScreensaverAd(driver, wait);

    @BeforeEach
    public void login() throws ConfigurationException, MalformedURLException, IOException {
        String environment = ConfigProviderMobile.getAppiumDriverConfiguration().environment();
        String platformName = ConfigProviderMobile.getAppiumDriverConfiguration().platformName();
        String deviceName = ConfigProviderMobile.getAppiumDriverConfiguration().deviceName();


        AppiumDriverHandler.createDriver(environment, platformName, deviceName);
//        loginPage.handleLoginFor("", "");
//        bluetoothAccessPrompt.handleAccessPrompt();
    }

    @AfterEach
    public void tearDown() {
//        realDeviceAppiumDriverHandler.commonTearDown();
    }
}
