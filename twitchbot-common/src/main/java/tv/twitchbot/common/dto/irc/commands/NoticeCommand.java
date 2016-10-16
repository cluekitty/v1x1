package tv.twitchbot.common.dto.irc.commands;

import tv.twitchbot.common.dto.irc.IrcSource;
import tv.twitchbot.common.dto.irc.IrcStanza;
import tv.twitchbot.common.dto.proto.core.IRC;

import java.util.Map;

/**
 * Created by cobi on 10/8/2016.
 */
public class NoticeCommand extends IrcStanza {
    public static NoticeCommand fromProto(String rawLine, Map<String, String> tags, IrcSource source, String rawArgs, String[] args, IRC.NoticeCommand noticeCommand) {
        String channel = noticeCommand.getChannel();
        String message = noticeCommand.getMessage();
        return new NoticeCommand(rawLine, tags, source, rawArgs, args, channel, message);
    }

    public enum MessageId {
        SUBS_ON, ALREADY_SUBS_ON, SUBS_OFF, ALREADY_SUBS_OFF,
        SLOW_ON, SLOW_OFF,
        R9K_ON, ALREADY_R9K_ON, R9K_OFF, ALREADY_R9K_OFF,
        HOST_ON, BAD_HOST_HOSTING, HOST_OFF, HOSTS_REMAINING,
        EMOTE_ONLY_ON, ALREADY_EMOTE_ONLY_ON, EMOTE_ONLY_OFF, ALREADY_EMOTE_ONLY_OFF,
        MSG_CHANNEL_SUSPENDED,
        TIMEOUT_SUCCESS, BAN_SUCCESS, UNBAN_SUCCESS, BAD_UNBAN_NO_BAN, ALREADY_BANNED,
        UNRECOGNIZED_COMMAND;
    }

    private String channel;
    private String message;

    private MessageId messageId;

    public NoticeCommand(String rawLine, Map<String, String> tags, IrcSource source, String rawArgs, String[] args, String channel, String message) {
        super(rawLine, tags, source, IrcCommand.NOTICE, rawArgs, args);
        this.channel = channel;
        this.message = message;
        if(tags.containsKey("msg-id") && !tags.get("msg-id").isEmpty())
            messageId = MessageId.valueOf(tags.get("msg-id").toUpperCase());
    }

    public String getChannel() {
        return channel;
    }

    public String getMessage() {
        return message;
    }

    public MessageId getMessageId() {
        return messageId;
    }

    @Override
    protected IRC.IrcStanza.Builder toProtoBuilder() {
        return super.toProtoBuilder()
                .setCommand(IRC.IrcStanza.IrcCommand.NOTICE)
                .setExtension(IRC.NoticeCommand.data, toProtoCommand());
    }

    private IRC.NoticeCommand toProtoCommand() {
        IRC.NoticeCommand.Builder builder = IRC.NoticeCommand.newBuilder()
                .setChannel(channel)
                .setMessage(message);
        if(messageId != null)
            builder.setMessageId(IRC.NoticeCommand.MessageId.valueOf(messageId.name()));
        return builder.build();
    }
}