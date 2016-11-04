package tv.v1x1.modules.channel.timed_messages.commands;

import com.google.common.collect.ImmutableList;
import tv.v1x1.common.dto.core.Channel;
import tv.v1x1.common.dto.core.ChatMessage;
import tv.v1x1.common.dto.core.Permission;
import tv.v1x1.common.services.chat.Chat;
import tv.v1x1.common.util.commands.Command;
import tv.v1x1.modules.channel.timed_messages.TimedMessages;

import java.util.List;

/**
 * @author Josh
 */
public class TimerAddCommand extends Command {
    private TimedMessages module;

    public TimerAddCommand(final TimedMessages module) {
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
        Chat.i18nMessage(module, chatMessage.getChannel(), "entry.add.notarget",
                "commander", chatMessage.getSender().getDisplayName(),
                "usage", getUsage()
                );
    }

    @Override
    public void run(final ChatMessage chatMessage, final String command, final List<String> args) {
        final Channel channel = chatMessage.getChannel();
        final String senderName = chatMessage.getSender().getDisplayName();
        final String timerName = args.remove(0);
        final StringBuilder message = new StringBuilder();
        for(String arg : args)
            message.append(arg);
        if(module.addTimerEntry(channel.getTenant(), timerName, message.toString()))
            Chat.i18nMessage(module, channel, "entry.add.success",
                    "commander", senderName,
                    "id", timerName
            );
        else
            Chat.i18nMessage(module, channel, "entry.add.badtarget",
                    "commander", senderName,
                    "id", timerName
            );
    }

    @Override
    public String getUsage() {
        return "add <id> <message>";
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