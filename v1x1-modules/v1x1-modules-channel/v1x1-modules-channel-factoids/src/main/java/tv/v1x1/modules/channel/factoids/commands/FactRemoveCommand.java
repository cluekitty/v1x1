package tv.v1x1.modules.channel.factoids.commands;

import com.google.common.collect.ImmutableList;
import tv.v1x1.common.dto.core.Channel;
import tv.v1x1.common.dto.core.ChatMessage;
import tv.v1x1.common.services.chat.Chat;
import tv.v1x1.common.util.commands.Command;
import tv.v1x1.common.util.text.Shorten;
import tv.v1x1.modules.channel.factoids.FactoidsModule;
import tv.v1x1.modules.channel.factoids.dao.Factoid;

import java.util.List;

/**
 * @author Josh
 */
public class FactRemoveCommand extends Command {
    final private FactoidsModule module;

    public FactRemoveCommand(FactoidsModule module) {
        this.module = module;
    }

    @Override
    public List<String> getCommands() {
        return ImmutableList.of("remove", "del", "delete");
    }

    @Override
    public void run(final ChatMessage chatMessage, final String command, final List<String> args) {
        final Channel channel = chatMessage.getChannel();
        final String commander = chatMessage.getSender().getDisplayName();
        final String factName = args.remove(0).toLowerCase();
        final Factoid fact = module.delFact(channel.getTenant(), factName);
        if(fact == null) {
            Chat.i18nMessage(module, channel, "noexist",
                    "commander", commander,
                    "id", factName);
        } else {
            if(fact.isAlias()) {
                Chat.i18nMessage(module, channel, "remove.alias.success",
                        "commander", commander,
                        "id", fact.getId(),
                        "alias", fact.getData());
            } else {
                module.pruneAliases(channel.getTenant(), fact.getId());
                Chat.i18nMessage(module, channel, "remove.fact.success",
                        "commander", commander,
                        "id", fact.getId(),
                        "fact", Shorten.genPreview(fact.getData()));
            }
        }
    }

    @Override
    public String getUsage() {
        return "<fact>";
    }

    @Override
    public String getDescription() {
        return "remove a fact";
    }

    @Override
    public int getMinArgs() {
        return 1;
    }

    @Override
    public void handleArgMismatch(final ChatMessage chatMessage, final String command, final List<String> args) {
        if(args.size() < 1) {
            Chat.i18nMessage(module, chatMessage.getChannel(), "invalid.args",
                    "commander", chatMessage.getSender().getDisplayName(),
                    "usage", getUsage());
        }
    }
}