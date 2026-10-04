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
 * Server-side fallback for the "open_url" action.
 * <p>
 * When a button has exactly one "open_url" action, {@code DialogImpl} turns it into a
 * client-side static action and the browser opens directly without a server round-trip.
 * This fallback only runs when "open_url" is combined with other actions on the same
 * button: the server cannot open a browser, so it sends a clickable link instead.
 */
public class OpenUrlDialogAction implements DialogAction {

    public static final OpenUrlDialogAction INSTANCE = new OpenUrlDialogAction();

    private OpenUrlDialogAction() {
    }

    @Override
    public void execute(Player player, Dialog dialog, String data) {
        if (data == null || data.isEmpty()) {
            return;
        }

        String url = PaperColor.handler().translateRaw(data, player, Parsers::placeholder).trim();

        Component link = Component.text(url)
                .decorate(TextDecoration.UNDERLINED)
                .clickEvent(ClickEvent.openUrl(url));
        player.sendMessage(link);
    }

}
