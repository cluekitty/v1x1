package tv.v1x1.common.dto.messages.events;

import tv.v1x1.common.dto.core.Channel;
import tv.v1x1.common.dto.core.Module;
import tv.v1x1.common.dto.core.UUID;
import tv.v1x1.common.dto.core.User;
import tv.v1x1.common.dto.messages.Context;
import tv.v1x1.common.dto.messages.Event;
import tv.v1x1.common.dto.proto.messages.EventOuterClass;

/**
 * Fired when a {@link User} joining a {@link Channel}
 * @author Cobi
 */
public abstract class ChatJoinEvent extends Event {
    public static ChatJoinEvent fromProto(final Module module, final UUID uuid, final long timestamp, final Context context, final EventOuterClass.ChatJoinEvent chatJoinEvent) {
        final User user = User.fromProto(chatJoinEvent.getUser());
        final Channel channel = Channel.fromProto(chatJoinEvent.getChannel());
        switch(chatJoinEvent.getType()) {
            case TWITCH: return TwitchChatJoinEvent.fromProto(module, uuid, timestamp, context, user, channel, chatJoinEvent.getExtension(EventOuterClass.TwitchChatJoinEvent.data));
            default: throw new IllegalStateException("Unknown ChatJoinEvent type: " + chatJoinEvent.getType());
        }
    }

    private final User user;
    private final Channel channel;

    /**
     * Construct a new event using the current time and a random UUID
     */
    public ChatJoinEvent(final Module from, final User user, final Channel channel) {
        super(from);
        this.user = user;
        this.channel = channel;
    }

    /**
     * Construct a new event using your own UUID and time
     * For example, for deserialization of a saved event
     */
    public ChatJoinEvent(final Module from, final UUID messageId, final long timestamp, final Context context, final User user, final Channel channel) {
        super(from, messageId, timestamp, context);
        this.user = user;
        this.channel = channel;
    }

    public User getUser() {
        return user;
    }

    public Channel getChannel() {
        return channel;
    }

    @Override
    protected EventOuterClass.Event.Builder toProtoEvent() {
        return super.toProtoEvent()
                .setType(EventOuterClass.Event.EventType.CHAT_JOIN)
                .setExtension(EventOuterClass.ChatJoinEvent.data, toProtoChatJoin().build());
    }

    protected EventOuterClass.ChatJoinEvent.Builder toProtoChatJoin() {
        return EventOuterClass.ChatJoinEvent.newBuilder()
                .setUser(user.toProto())
                .setChannel(channel.toProto());
    }
}
