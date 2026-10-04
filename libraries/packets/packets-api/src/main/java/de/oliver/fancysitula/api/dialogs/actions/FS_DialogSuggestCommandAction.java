package de.oliver.fancysitula.api.dialogs.actions;

/**
 * A static button action that puts the given command into the player's chat input
 * without executing it, so the player can review or complete it before sending.
 */
public class FS_DialogSuggestCommandAction implements FS_DialogActionButtonAction {

    private String command;

    public FS_DialogSuggestCommandAction(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
