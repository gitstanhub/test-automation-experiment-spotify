package com.spotify.pageobjects.commons.interfaces.mediainteraction;

public interface MediaInteraction {

    public MediaInteraction tapContextMenuButton();

    public MediaInteraction verifyContextMenuButtonIsAvailable();

    public MediaInteraction verifyShuffleButtonIsAvailable();

    public MediaInteraction verifyPlayButtonIsAvailable();
}
