package com.spotify.pageobjects.commons.interfaces.contextmenu;

import com.spotify.pageobjects.commons.android.contextmenu.ContextMenuAndroid;

public interface ContextMenu {

    public ContextMenuAndroid verifyContextMenuTitleIsAvailable(String expectedTitleText);

    public ContextMenuAndroid tapShowSpotifyCodeButton();

    public ContextMenuAndroid tapDeletePlaylistButton();

}
