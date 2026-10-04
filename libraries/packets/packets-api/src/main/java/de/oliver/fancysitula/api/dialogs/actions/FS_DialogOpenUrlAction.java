package de.oliver.fancysitula.api.dialogs.actions;

/**
 * A static button action that opens the given URL in the player's browser.
 * The client asks the player for confirmation before opening the link.
 */
public class FS_DialogOpenUrlAction implements FS_DialogActionButtonAction {

    private String url;

    public FS_DialogOpenUrlAction(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
