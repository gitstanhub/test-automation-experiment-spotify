package com.spotify.tests;

import com.spotify.tests.base.WebPlaywrightTestBase;
import org.junit.jupiter.api.Test;

public class SearchTests extends WebPlaywrightTestBase {

    @Test
    public void songCanBeSearchedGlobally() {
        page.navigate("https://open.spotify.com/");
    }
}
