package com.spotify.android.tests.base;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.spotify.android.driver.RealDeviceAppiumDriverHandler;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileAndroidTestBase {

    private final RealDeviceAppiumDriverHandler realDeviceAppiumDriverHandler = new RealDeviceAppiumDriverHandler();
    protected final AndroidDriver driver = RealDeviceAppiumDriverHandler.getDriver();
    protected final WebDriverWait wait = RealDeviceAppiumDriverHandler.getWait();

//    @BeforeEach
//    check if not logged in, then login

    @AfterEach
    public void tearDown() {
        //requires appium server to be started with --relaxed-security flag
//        driver.executeScript("mobile: shell", new ImmutableMap.Builder<String, Object>().put("command", "pm clear").put("args", ImmutableList.of("com.spotify.music")).build());
        realDeviceAppiumDriverHandler.commonTearDown();
    }
}
