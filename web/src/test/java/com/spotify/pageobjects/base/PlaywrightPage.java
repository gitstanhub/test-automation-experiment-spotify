package com.spotify.pageobjects.base;

import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import com.spotify.utils.ElementChecks;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class PlaywrightPage {

    @Autowired
    protected BrowserActions browserActions;
    @Autowired
    protected ElementActions elementActions;
    @Autowired
    protected ElementChecks elementChecks;
}
