package tv.twitchbot.common.dto.irc.commands;

import tv.twitchbot.common.dto.irc.IrcSource;
import tv.twitchbot.common.dto.irc.IrcStanza;
import tv.twitchbot.common.dto.proto.core.IRC;

import java.util.Map;

/**
 * Created by cobi on 10/8/2016.
 */
public class PartCommand extends IrcStanza {
    public static PartCommand fromProto(String rawLine, Map<String, String> tags, IrcSource source, String rawArgs, String[] args, IRC.PartCommand partCommand) {
        String channel = partCommand.getChannel();
        return new PartCommand(rawLine, tags, source, rawArgs, args, channel);
    }

    private String channel;

    public PartCommand(String rawLine, Map<String, String> tags, IrcSource source, String rawArgs, String[] args, String channel) {
        super(rawLine, tags, source, IrcCommand.PART, rawArgs, args);
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }

    @Override
    protected IRC.IrcStanza.Builder toProtoBuilder() {
        return super.toProtoBuilder()
                .setCommand(IRC.IrcStanza.IrcCommand.PART)
                .setExtension(IRC.PartCommand.data, toProtoCommand());
    }

    private IRC.PartCommand toProtoCommand() {
        return IRC.PartCommand.newBuilder()
                .setChannel(channel)
                .build();
    }
}