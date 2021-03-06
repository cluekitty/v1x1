package tv.v1x1.modules.channel.timed_messages.commands;

import com.google.common.collect.ImmutableList;
import tv.v1x1.common.dto.core.Channel;
import tv.v1x1.common.dto.core.ChatMessage;
import tv.v1x1.common.dto.core.Permission;
import tv.v1x1.common.services.chat.Chat;
import tv.v1x1.common.util.commands.Command;
import tv.v1x1.common.util.text.Shorten;
import tv.v1x1.modules.channel.timed_messages.TimedMessages;

import java.util.List;

/**
 * @author Josh
 */
/* pkg-private */ class TimerAddCommand extends Command {
    private final TimedMessages module;

    TimerAddCommand(final TimedMessages module) {
        this.module = module;
    }

    @Override
    public List<String> getCommands() {
        return ImmutableList.of("add");
    }

    @Override
    public List<Permission> getAllowedPermissions() {
        return null;
    }

    @Override
    public void handleArgMismatch(final ChatMessage chatMessage, final String command, final List<String> args) {
        switch (args.size()) {
            case 0: Chat.i18nMessage(module, chatMessage.getChannel(), "add.notarget",
                    "commander", chatMessage.getSender().getMention(),
                    "usage", getUsage()
                );
                break;
            case 1: Chat.i18nMessage(module, chatMessage.getChannel(), "add.nomessage",
                    "commander", chatMessage.getSender().getMention(),
                    "usage", getUsage());
                break;
        }
    }

    @Override
    public void run(final ChatMessage chatMessage, final String command, final List<String> args) {
        final Channel channel = chatMessage.getChannel();
        final String commander = chatMessage.getSender().getMention();
        final String timerName = args.remove(0);
        final String message = String.join(" ", args);
        if(module.addTimerEntry(channel.getChannelGroup().getTenant(), timerName, message))
            Chat.i18nMessage(module, channel, "add.success",
                    "commander", commander,
                    "id", timerName,
                    "preview", Shorten.genPreview(message)
            );
        else
            Chat.i18nMessage(module, channel, "invalid.timer",
                    "commander", commander,
                    "id", timerName
            );
    }

    @Override
    public String getUsage() {
        return "<timer> <message>";
    }

    @Override
    public String getDescription() {
        return "add an entry to a rotation";
    }

    @Override
    public int getMinArgs() {
        return 2;
    }

    @Override
    public int getMaxArgs() {
        return -1;
    }
}
