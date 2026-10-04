package com.fancyinnovations.fancydialogs.actions.defaultActions;

import com.fancyinnovations.fancydialogs.api.Dialog;
import com.fancyinnovations.fancydialogs.api.DialogAction;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.lushplugins.chatcolorhandler.common.parser.Parsers;
import org.lushplugins.chatcolorhandler.paper.PaperColor;

/**
 * Server-side fallback for the "suggest_command" action.
 * <p>
 * When a button has exactly one "suggest_command" action, {@code DialogImpl} turns it into a
 * client-side static action and the command is placed into the player's chat input directly.
 * This fallback only runs when "suggest_command" is combined with other actions on the same
 * button: the server cannot write into the chat input, so it sends a clickable message that
 * suggests the command instead.
 */
public class SuggestCommandDialogAction implements DialogAction {

    public static final SuggestCommandDialogAction INSTANCE = new SuggestCommandDialogAction();

    private SuggestCommandDialogAction() {
    }

    @Override
    public void execute(Player player, Dialog dialog, String data) {
        if (data == null || data.isEmpty()) {
            return;
        }

        String command = PaperColor.handler().translateRaw(data, player, Parsers::placeholder).trim();

        Component suggestion = Component.text(command)
                .decorate(TextDecoration.UNDERLINED)
                .clickEvent(ClickEvent.suggestCommand(command));
        player.sendMessage(suggestion);
    }

}
