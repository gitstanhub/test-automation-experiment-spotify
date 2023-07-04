package com.spotify.tests;

import com.spotify.pageobjects.pages.LoginPage;
import com.spotify.tests.base.WebPlaywrightTestBase;
import org.junit.jupiter.api.Test;

public class GlobalSearchTests extends WebPlaywrightTestBase {

    private final LoginPage loginPage = new LoginPage(page);
    @Test
    public void songCanBeFound() {
        System.out.println("hahahAha");
    }

    //@Test
    //public void playlistCanBeFound()

}
