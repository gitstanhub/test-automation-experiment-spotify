package com.spotify.pageobjects.base;

import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import com.spotify.utils.ElementChecks;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlaywrightPage {

    public static final BrowserActions browserActions = new BrowserActions();

    public static final ElementActions elementActions = new ElementActions();

    public static final ElementChecks elementChecks = new ElementChecks();
}
