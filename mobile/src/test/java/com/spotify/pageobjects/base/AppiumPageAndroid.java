package com.spotify.pageobjects.base;

import com.spotify.utils.android.assertions.AndroidElementChecks;
import com.spotify.utils.android.navgiation.AndroidDeviceActions;
import com.spotify.utils.android.elementactions.AndroidElementActions;
import com.spotify.utils.android.navgiation.AndroidPageNavigationActions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public abstract class AppiumPageAndroid {

    @Autowired
    protected AndroidElementChecks androidElementChecks;
    @Autowired
    protected AndroidDeviceActions androidDeviceActions;
    @Autowired
    protected AndroidElementActions androidElementActions;
    @Autowired
    protected AndroidPageNavigationActions androidPageNavigationActions;
}
