package com.spotify.android.tests.base;

import com.spotify.android.config.ConfigProviderMobile;
import com.spotify.android.driver.AppiumDriverHandler;
import com.spotify.android.pageobjects.commons.accessprompts.BluetoothAccessPrompt;
import com.spotify.android.pageobjects.commons.ScreensaverAd;
import com.spotify.android.pageobjects.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.WebDriverWait;

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
