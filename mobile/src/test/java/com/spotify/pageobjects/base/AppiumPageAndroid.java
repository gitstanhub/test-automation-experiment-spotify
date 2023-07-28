package com.spotify.pageobjects.base;

import com.spotify.utils.assertions.ElementChecksMobile;
import com.spotify.utils.navigation.android.AndroidDeviceActions;
import com.spotify.utils.navigation.android.AndroidElementActions;
import com.spotify.utils.navigation.android.AndroidPageNavigationActions;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppiumPageAndroid {

    public static final ElementChecksMobile elementChecksMobile = new ElementChecksMobile();
    public static final AndroidDeviceActions androidDeviceActions = new AndroidDeviceActions();
    public static final AndroidElementActions androidElementActions = new AndroidElementActions();
    public static final AndroidPageNavigationActions androidPageNavigationActions = new AndroidPageNavigationActions();
}
