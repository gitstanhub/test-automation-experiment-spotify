package com.spotify.pageobjects.base;

import com.spotify.utils.assertions.ElementChecksMobile;
import com.spotify.utils.navigation.android.AndroidDeviceActions;
import com.spotify.utils.navigation.android.AndroidElementActions;
import com.spotify.utils.navigation.android.AndroidPageNavigationActions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public abstract class AppiumPageAndroid {

    @Autowired
    protected ElementChecksMobile elementChecksMobile;
    @Autowired
    protected AndroidDeviceActions androidDeviceActions;
    @Autowired
    protected AndroidElementActions androidElementActions;
    @Autowired
    protected AndroidPageNavigationActions androidPageNavigationActions;
}
