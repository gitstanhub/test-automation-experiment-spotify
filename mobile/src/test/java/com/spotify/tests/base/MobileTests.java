package com.spotify.tests.base;

import com.spotify.annotations.AuthRequiredMobile;
import com.spotify.config.ConfigProviderMobile;
import com.spotify.config.SpringConfigMobile;
import com.spotify.config.SpringConfigMobileContext;
import com.spotify.driver.AppiumDriverHandler;
import com.spotify.pageobjects.commons.interfaces.accessprompt.BluetoothAccessPrompt;
import com.spotify.pageobjects.commons.interfaces.contextmenu.ContextMenu;
import com.spotify.pageobjects.commons.interfaces.elementslist.ElementsList;
import com.spotify.pageobjects.commons.interfaces.mediainteraction.MediaInteraction;
import com.spotify.pageobjects.commons.interfaces.navigation.Navigation;
import com.spotify.pageobjects.commons.interfaces.screensaverad.ScreensaverAd;
import com.spotify.pageobjects.commons.interfaces.spotifycode.SpotifyCode;
import com.spotify.pageobjects.pages.interfaces.album.AlbumPage;
import com.spotify.pageobjects.pages.interfaces.artist.ArtistDiscographyPage;
import com.spotify.pageobjects.pages.interfaces.artist.ArtistProfilePage;
import com.spotify.pageobjects.pages.interfaces.library.LibraryPage;
import com.spotify.pageobjects.pages.interfaces.library.LibrarySearchPage;
import com.spotify.pageobjects.pages.interfaces.login.LoginPage;
import com.spotify.pageobjects.pages.interfaces.playlist.PlaylistCreationPage;
import com.spotify.pageobjects.pages.interfaces.playlist.PlaylistPage;
import com.spotify.pageobjects.pages.interfaces.search.SearchPage;
import com.spotify.pageobjects.pages.interfaces.search.SearchResultsPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.naming.ConfigurationException;
import java.io.IOException;
import java.lang.reflect.Method;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfigMobile.class)
@Slf4j
public class MobileTests {

    protected static AnnotationConfigApplicationContext applicationContext;

    protected BluetoothAccessPrompt getBluetoothAccessPrompt() {
        return applicationContext.getBean(BluetoothAccessPrompt.class);
    }

    protected ContextMenu getContextMenu() {
        return applicationContext.getBean(ContextMenu.class);
    }

    protected ElementsList getElementsList() {
        return applicationContext.getBean(ElementsList.class);
    }

    protected MediaInteraction getMediaInteraction() {
        return applicationContext.getBean(MediaInteraction.class);
    }

    protected Navigation getNavigation() {
        return applicationContext.getBean(Navigation.class);
    }

    protected ScreensaverAd getScreensaverAd() {
        return applicationContext.getBean(ScreensaverAd.class);
    }

    protected SpotifyCode getSpotifyCode() {
        return applicationContext.getBean(SpotifyCode.class);
    }

    protected AlbumPage getAlbumPage() {
        return applicationContext.getBean(AlbumPage.class);
    }

    protected ArtistDiscographyPage getArtistDiscographyPage() {
        return applicationContext.getBean(ArtistDiscographyPage.class);
    }

    protected ArtistProfilePage getArtistProfilePage() {
        return applicationContext.getBean(ArtistProfilePage.class);
    }

    protected LibraryPage getLibraryPage() {
        return applicationContext.getBean(LibraryPage.class);
    }

    protected LibrarySearchPage getLibrarySearchPage() {
        return applicationContext.getBean(LibrarySearchPage.class);
    }

    protected LoginPage getLoginPage() {
        return applicationContext.getBean(LoginPage.class);
    }

    protected PlaylistCreationPage getPlaylistCreationPage() {
        return applicationContext.getBean(PlaylistCreationPage.class);
    }

    protected PlaylistPage getPlaylistPage() {
        return applicationContext.getBean(PlaylistPage.class);
    }

    protected SearchPage getSearchPage() {
        return applicationContext.getBean(SearchPage.class);
    }

    protected SearchResultsPage getSearchResultsPage() {
        return applicationContext.getBean(SearchResultsPage.class);
    }

    @BeforeEach
    public void setUpApplicationContext() {
        String platformName = ConfigProviderMobile.getAppiumDriverConfiguration().platformName();

        applicationContext = SpringConfigMobileContext.setContextWithPages(platformName);
    }

    @BeforeEach
    public void setUp(TestInfo testInfo) throws ConfigurationException, IOException {
        String environment = ConfigProviderMobile.getAppiumDriverConfiguration().environment();
        String platformName = ConfigProviderMobile.getAppiumDriverConfiguration().platformName();
        String deviceName = ConfigProviderMobile.getAppiumDriverConfiguration().deviceName();

        AppiumDriverHandler.createDriver(environment, platformName, deviceName);

        handleAuthIfNeeded(testInfo);
    }

    @AfterEach
    public void tearDown() {
        AppiumDriverHandler.closeDriver();
    }

    @AfterEach
    public void cleanUpApplicationContext() {
        if (applicationContext != null) {
            applicationContext.close();
        }
    }

    private void handleAuthIfNeeded(TestInfo testInfo) {
        Method testMethod = testInfo.getTestMethod().orElseThrow();

        if (testMethod.isAnnotationPresent(AuthRequiredMobile.class)) {
            getLoginPage().handleLoginFor("", "");
            getBluetoothAccessPrompt().handleAccessPrompt();
        }
    }
}

//    private final AppiumDriverHandler realDeviceAppiumDriverHandler = new AppiumDriverHandler();
//    protected final AndroidDriver driver = AppiumDriverHandler.getDriver();
//    protected final WebDriverWait wait = AppiumDriverHandler.getWait();
//    private final LoginPage loginPage = new LoginPage(driver, wait);
//    private final BluetoothAccessPrompt bluetoothAccessPrompt = new BluetoothAccessPrompt(driver, wait);
//    private final ScreensaverAd screensaverAd = new ScreensaverAd(driver, wait);

//        loginPage.handleLoginFor("", "");
//        bluetoothAccessPrompt.handleAccessPrompt();

//        realDeviceAppiumDriverHandler.commonTearDown();
