package com.spotify.tests;

import com.spotify.pageobjects.pages.LoginPage;
import com.spotify.tests.base.WebPlaywrightTestBase;
import lombok.Getter;
import org.junit.jupiter.api.Test;

public class GlobalSearchTests extends WebPlaywrightTestBase {

    private final LoginPage loginPage = new LoginPage(page);
    @Test
    public void songCanBeFound() {
        loginPage
                .open()
                .fillInUsername("test");
    }

    //@Test
    //public void playlistCanBeFound()

}
