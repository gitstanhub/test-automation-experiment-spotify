package com.spotify.pageobjects.base;

import com.spotify.utils.assertions.ElementChecksMobile;
import com.spotify.utils.navigation.android.AndroidDeviceActions;
import com.spotify.utils.navigation.android.AndroidElementActions;
import com.spotify.utils.navigation.android.AndroidPageNavigationActions;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppiumPageAndroid {

    public ElementChecksMobile elementChecksMobile = new ElementChecksMobile();
    public AndroidDeviceActions androidDeviceActions = new AndroidDeviceActions();
    public AndroidElementActions androidElementActions = new AndroidElementActions();
    public AndroidPageNavigationActions androidPageNavigationActions = new AndroidPageNavigationActions();
}
