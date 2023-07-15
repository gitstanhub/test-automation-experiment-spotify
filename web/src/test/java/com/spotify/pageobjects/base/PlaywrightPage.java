package com.spotify.pageobjects.base;

import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import com.spotify.utils.ElementChecks;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PlaywrightPage {

    @Autowired
    public BrowserActions browserActions;
    @Autowired
    public ElementActions elementActions;
    @Autowired
    public ElementChecks elementChecks;

//    public BrowserActions browserActions = new BrowserActions();
//    public ElementActions elementActions = new ElementActions();
//    public ElementChecks elementChecks = new ElementChecks();
}
