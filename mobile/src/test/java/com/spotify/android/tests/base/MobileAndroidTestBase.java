package com.spotify.android.tests.base;

import com.spotify.android.driver.RealDeviceAppiumDriverHandler;
import com.spotify.android.pageobjects.commons.BluetoothAccessPrompt;
import com.spotify.android.pageobjects.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MobileAndroidTestBase {

    private final RealDeviceAppiumDriverHandler realDeviceAppiumDriverHandler = new RealDeviceAppiumDriverHandler();
    protected final AndroidDriver driver = RealDeviceAppiumDriverHandler.getDriver();
    protected final WebDriverWait wait = RealDeviceAppiumDriverHandler.getWait();
    private final LoginPage loginPage = new LoginPage(driver, wait);
    private final BluetoothAccessPrompt bluetoothAccessPrompt = new BluetoothAccessPrompt(driver, wait);

    @BeforeEach
    public void login() {
        loginPage.handleLoginState("", "");
        bluetoothAccessPrompt.handleAccessPrompt();

//                List<WebElement> elements = driver.findElements(By.xpath("//*"));
//        for (WebElement element : elements) {
//            System.out.println("Tag:" + element.getTagName());
//            System.out.println("Text:" + element.getText());
//            System.out.println("Class:" + element.getAttribute("class"));
//            System.out.println("Resource-ID:" + element.getAttribute("resourceId"));
//            System.out.println("********************");
//        }
    }

    @AfterEach
    public void tearDown() {
        //requires appium server to be started with --relaxed-security flag
//        driver.executeScript("mobile: shell", new ImmutableMap.Builder<String, Object>().put("command", "pm clear").put("args", ImmutableList.of("com.spotify.music")).build());
        realDeviceAppiumDriverHandler.commonTearDown();
    }
}
