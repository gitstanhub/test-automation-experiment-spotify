package com.spotify.tests.base;

import com.spotify.annotations.AuthRequiredWeb;
import com.spotify.config.ConfigProviderWeb;
import com.spotify.config.SpringConfigWeb;
import com.spotify.driver.PlaywrightDriverHandler;
import com.spotify.pageobjects.commons.CookiesBanner;
import com.spotify.pageobjects.pages.LoginPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.naming.ConfigurationException;
import java.lang.reflect.Method;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfigWeb.class)
@Slf4j
public class WebTests {

    @Autowired
    @Lazy
    LoginPage loginPage;
    @Autowired
    @Lazy
    CookiesBanner cookiesBanner;

    @BeforeEach
    public void setUp(TestInfo testInfo) throws ConfigurationException {
        log.info("Initiating driver setup before each test run");

        String browserName = ConfigProviderWeb.getPlaywrightBrowserConfiguration().browser();
        String testName = testInfo.getTestMethod().map(Method::getName).orElse(null);

        boolean videoRecordingEnabled = ConfigProviderWeb.getPlaywrightBrowserConfiguration().videoRecordingEnabled();
        boolean headlessEnabled = ConfigProviderWeb.getPlaywrightBrowserConfiguration().headlessEnabled();
        boolean remoteEnabled = ConfigProviderWeb.getPlaywrightBrowserConfiguration().remoteEnabled();

        PlaywrightDriverHandler.createDriver(browserName, testName, videoRecordingEnabled, headlessEnabled, remoteEnabled);

        handleAuthIfNeeded(testInfo);
    }

    @AfterEach
    public void tearDown() {
        log.info("Closing driver after each test run");
        PlaywrightDriverHandler.closeDriver();
    }

    private void handleAuthIfNeeded(TestInfo testInfo) {
        Method testMethod = testInfo.getTestMethod().orElseThrow();

        if (testMethod.isAnnotationPresent(AuthRequiredWeb.class)) {
            loginPage.handleLoginFor(ConfigProviderWeb.getWebAppAuthConfiguration().username(), ConfigProviderWeb.getWebAppAuthConfiguration().password());
            cookiesBanner.handleCookiesBanner();
        }
    }
}
