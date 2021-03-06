package tv.v1x1.common.dto.irc;

import tv.v1x1.common.dto.irc.commands.ClearChatCommand;
import tv.v1x1.common.dto.irc.commands.GlobalUserStateCommand;
import tv.v1x1.common.dto.irc.commands.HostTargetCommand;
import tv.v1x1.common.dto.irc.commands.JoinCommand;
import tv.v1x1.common.dto.irc.commands.ModeCommand;
import tv.v1x1.common.dto.irc.commands.NoticeCommand;
import tv.v1x1.common.dto.irc.commands.PartCommand;
import tv.v1x1.common.dto.irc.commands.PingCommand;
import tv.v1x1.common.dto.irc.commands.PrivmsgCommand;
import tv.v1x1.common.dto.irc.commands.ReconnectCommand;
import tv.v1x1.common.dto.irc.commands.RoomStateCommand;
import tv.v1x1.common.dto.irc.commands.RplEndOfMotdCommand;
import tv.v1x1.common.dto.irc.commands.RplNameReplyCommand;
import tv.v1x1.common.dto.irc.commands.UserNoticeCommand;
import tv.v1x1.common.dto.irc.commands.UserStateCommand;
import tv.v1x1.common.dto.irc.commands.WhisperCommand;
import tv.v1x1.common.dto.proto.core.IRC;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by cobi on 10/8/2016.
 */
public abstract class IrcStanza {
    private final String rawLine;
    private final Map<String, String> tags;
    private final IrcSource source;
    private final IrcCommand command;
    private final String rawArgs;
    private final String[] args;

    public static IrcStanza fromProto(final IRC.IrcStanza stanza) {
        final String rawLine = stanza.getRawLine();
        final Map<String, String> tags = stanza.getTagsMap();
        final IrcSource source = IrcSource.fromProto(stanza.getSource());
        final String rawArgs = stanza.getRawArgs();
        final String[] args = stanza.getArgsList().toArray(new String[] {});
        switch(stanza.getCommand()) {
            case CLEARCHAT: return ClearChatCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.ClearChatCommand.data));
            case GLOBALUSERSTATE: return GlobalUserStateCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.GlobalUserStateCommand.data));
            case HOSTTARGET: return HostTargetCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.HostTargetCommand.data));
            case JOIN: return JoinCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.JoinCommand.data));
            case MODE: return ModeCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.ModeCommand.data));
            case NOTICE: return NoticeCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.NoticeCommand.data));
            case PART: return PartCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.PartCommand.data));
            case PING: return PingCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.PingCommand.data));
            case PRIVMSG: return PrivmsgCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.PrivmsgCommand.data));
            case RECONNECT: return ReconnectCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.ReconnectCommand.data));
            case ROOMSTATE: return RoomStateCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.RoomStateCommand.data));
            case RPL_ENDOFMOTD: return RplEndOfMotdCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.RplEndOfMotdCommand.data));
            case RPL_NAMREPLY: return RplNameReplyCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.RplNameReplyCommand.data));
            case USERNOTICE: return UserNoticeCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.UserNoticeCommand.data));
            case USERSTATE: return UserStateCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.UserStateCommand.data));
            case WHISPER: return WhisperCommand.fromProto(rawLine, tags, source, rawArgs, args, stanza.getExtension(IRC.WhisperCommand.data));
            default: throw new IllegalStateException("Unknown serialized IRC command: " + stanza.getCommand());
        }
    }

    public enum IrcCommand {
        JOIN, PART, PRIVMSG,
        RPL_NAMREPLY, RPL_ENDOFMOTD,
        MODE, NOTICE, HOSTTARGET,
        CLEARCHAT, USERSTATE,
        RECONNECT, ROOMSTATE,
        USERNOTICE, GLOBALUSERSTATE,
        PING, WHISPER
    }

    public IrcStanza(final String rawLine, final Map<String, String> tags, final IrcSource source, final IrcCommand command, final String rawArgs, final String[] args) {
        this.rawLine = rawLine;
        this.tags = tags;
        this.source = source;
        this.command = command;
        this.rawArgs = rawArgs;
        this.args = args;
    }

    public String getRawLine() {
        return rawLine;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public IrcSource getSource() {
        return source;
    }

    public IrcCommand getCommand() {
        return command;
    }

    public String getRawArgs() {
        return rawArgs;
    }

    public String[] getArgs() {
        return args;
    }

    public IRC.IrcStanza toProto() {
        return toProtoBuilder().build();
    }

    protected IRC.IrcStanza.Builder toProtoBuilder() {
        return IRC.IrcStanza.newBuilder()
                .setRawLine(rawLine)
                .putAllTags(tags)
                .setSource(source.toProto())
                .setRawArgs(rawArgs)
                .addAllArgs(Arrays.asList(args));
    }
}
