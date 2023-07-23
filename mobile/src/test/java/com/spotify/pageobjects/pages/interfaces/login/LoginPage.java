package com.spotify.pageobjects.pages.interfaces.login;

public interface LoginPage {

    public LoginPage tapLogInButton();

    public LoginPage fillInUsernameField(String username);

    public LoginPage fillInPasswordField(String password);

    public LoginPage tapLoginSubmitButton();

    public void handleLoginFor(String username, String password);
}
