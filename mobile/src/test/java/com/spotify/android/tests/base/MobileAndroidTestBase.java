package com.spotify.android.tests.base;

import com.spotify.android.driver.AppiumDriverHandler;
import com.spotify.android.pageobjects.commons.accessprompts.BluetoothAccessPrompt;
import com.spotify.android.pageobjects.commons.ScreensaverAd;
import com.spotify.android.pageobjects.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileAndroidTestBase {

    private final AppiumDriverHandler realDeviceAppiumDriverHandler = new AppiumDriverHandler();
    protected final AndroidDriver driver = AppiumDriverHandler.getDriver();
    protected final WebDriverWait wait = AppiumDriverHandler.getWait();
    private final LoginPage loginPage = new LoginPage(driver, wait);
    private final BluetoothAccessPrompt bluetoothAccessPrompt = new BluetoothAccessPrompt(driver, wait);
    private final ScreensaverAd screensaverAd = new ScreensaverAd(driver, wait);

    @BeforeEach
    public void login() {
        loginPage.handleLoginFor("", "");
        bluetoothAccessPrompt.handleAccessPrompt();
    }

    @AfterEach
    public void tearDown() {
        realDeviceAppiumDriverHandler.commonTearDown();
    }
}
