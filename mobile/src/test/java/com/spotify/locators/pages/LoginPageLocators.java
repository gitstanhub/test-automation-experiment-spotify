package com.spotify.locators.pages;

public class LoginPageLocators {

    public static final String LOGIN_BUTTON = "//android.widget.Button[contains(@text,'%s')]";
    public static final String LOGIN_BUTTON_UIAUTOMATOR = "new UiSelector().className(\"android.widget.Button\").text(\"%s\")";
    public static final String USERNAME_FIELD = "com.spotify.music:id/username_text";
    public static final String PASSWORD_FIELD = "com.spotify.music:id/password_text";
    public static final String LOGIN_SUBMIT_BUTTON = "com.spotify.music:id/login_button";
}
