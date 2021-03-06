package tv.v1x1.common.services.state;

import com.google.common.cache.CacheLoader;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import tv.v1x1.common.services.cache.CacheManager;
import tv.v1x1.common.services.cache.JsonCodec;
import tv.v1x1.common.services.cache.SharedCache;
import tv.v1x1.common.services.cache.StringCodec;
import tv.v1x1.common.services.twitch.TwitchApi;
import tv.v1x1.common.services.twitch.dto.channels.Channel;
import tv.v1x1.common.services.twitch.dto.users.User;

import javax.ws.rs.NotFoundException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by jcarter on 2/24/17.
 */
@Singleton
public class TwitchDisplayNameService {
    private final SharedCache<String, String> userIdByUsernameCache;
    private final SharedCache<String, String> userIdByDisplayNameCache;
    private final SharedCache<String, String> usernameByUserIdCache;
    private final SharedCache<String, String> usernameByDisplayNameCache;
    private final SharedCache<String, String> displayNameByUserIdCache;
    private final SharedCache<String, String> displayNameByUsernameCache;
    private final SharedCache<String, User> userByUserIdCache;
    private final SharedCache<String, User> userByUsernameCache;
    private final SharedCache<String, User> userByDisplayNameCache;
    private final SharedCache<String, String> channelIdByChannelNameCache;
    private final SharedCache<String, String> channelIdByDisplayNameCache;
    private final SharedCache<String, String> channelNameByChannelIdCache;
    private final SharedCache<String, String> channelNameByDisplayNameCache;
    private final SharedCache<String, String> displayNameByChannelIdCache;
    private final SharedCache<String, String> displayNameByChannelNameCache;
    private final SharedCache<String, Channel> channelByChannelIdCache;
    private final SharedCache<String, Channel> channelByChannelNameCache;
    private final SharedCache<String, Channel> channelByDisplayNameCache;
    private final TwitchApi twitchApi;

    @Inject
    public TwitchDisplayNameService(final CacheManager cacheManager, final TwitchApi twitchApi) {
        final StringCodec stringCodec = StringCodec.INSTANCE;
        final JsonCodec<User> userCodec = new JsonCodec<>(User.class);
        final JsonCodec<Channel> channelCodec = new JsonCodec<>(Channel.class);
        this.userIdByUsernameCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|userIdByUsername", 90, TimeUnit.DAYS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return stringCodec.encode(String.valueOf(getUserByUsername(stringCodec.decode(bytes)).getId()));
            }
        }), stringCodec, stringCodec);
        this.userIdByDisplayNameCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|userIdByDisplayName", 90, TimeUnit.DAYS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return stringCodec.encode(String.valueOf(getUserByDisplayName(stringCodec.decode(bytes)).getId()));
            }
        }), stringCodec, stringCodec);
        this.usernameByUserIdCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|usernameByUserId", 1, TimeUnit.DAYS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return stringCodec.encode(String.valueOf(getUserByUserId(stringCodec.decode(bytes)).getName()));
            }
        }), stringCodec, stringCodec);
        this.usernameByDisplayNameCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|usernameByDisplayName", 1, TimeUnit.DAYS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return stringCodec.encode(String.valueOf(getUserByDisplayName(stringCodec.decode(bytes)).getName()));
            }
        }), stringCodec, stringCodec);
        this.displayNameByUserIdCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|displayNameByUserId", 1, TimeUnit.DAYS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return stringCodec.encode(String.valueOf(getUserByUserId(stringCodec.decode(bytes)).getDisplayName()));
            }
        }), stringCodec, stringCodec);
        this.displayNameByUsernameCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|displayNameByUsername", 1, TimeUnit.DAYS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return stringCodec.encode(String.valueOf(getUserByUsername(stringCodec.decode(bytes)).getDisplayName()));
            }
        }), stringCodec, stringCodec);
        this.userByUserIdCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|userByUserId", 1, TimeUnit.HOURS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return userCodec.encode(fetchUserByUserId(stringCodec.decode(bytes)));
            }
        }), stringCodec, userCodec);
        this.userByUsernameCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|userByUsername", 1, TimeUnit.HOURS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return userCodec.encode(fetchUserByUsername(stringCodec.decode(bytes)));
            }
        }), stringCodec, userCodec);
        this.userByDisplayNameCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|userByDisplayName", 1, TimeUnit.HOURS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return userCodec.encode(fetchUserByDisplayName(stringCodec.decode(bytes)));
            }
        }), stringCodec, userCodec);
        this.channelIdByChannelNameCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|channelIdByChannelName", 90, TimeUnit.DAYS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return stringCodec.encode(String.valueOf(getChannelByChannelName(stringCodec.decode(bytes)).getId()));
            }
        }), stringCodec, stringCodec);
        this.channelIdByDisplayNameCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|channelIdByDisplayName", 90, TimeUnit.DAYS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return stringCodec.encode(String.valueOf(getChannelByDisplayName(stringCodec.decode(bytes)).getId()));
            }
        }), stringCodec, stringCodec);
        this.channelNameByChannelIdCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|channelNameByChannelId", 1, TimeUnit.DAYS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return stringCodec.encode(String.valueOf(getChannelByChannelId(stringCodec.decode(bytes)).getName()));
            }
        }), stringCodec, stringCodec);
        this.channelNameByDisplayNameCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|channelNameByDisplayName", 1, TimeUnit.DAYS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return stringCodec.encode(String.valueOf(getChannelByDisplayName(stringCodec.decode(bytes)).getName()));
            }
        }), stringCodec, stringCodec);
        this.displayNameByChannelIdCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|displayNameByChannelId", 1, TimeUnit.DAYS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return stringCodec.encode(String.valueOf(getChannelByChannelId(stringCodec.decode(bytes)).getDisplayName()));
            }
        }), stringCodec, stringCodec);
        this.displayNameByChannelNameCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|displayNameByChannelName", 1, TimeUnit.DAYS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return stringCodec.encode(String.valueOf(getChannelByChannelName(stringCodec.decode(bytes)).getDisplayName()));
            }
        }), stringCodec, stringCodec);
        this.channelByChannelIdCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|channelByChannelId", 1, TimeUnit.HOURS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return channelCodec.encode(fetchChannelByChannelId(stringCodec.decode(bytes)));
            }
        }), stringCodec, channelCodec);
        this.channelByChannelNameCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|channelByChannelName", 1, TimeUnit.HOURS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return channelCodec.encode(fetchChannelByChannelName(stringCodec.decode(bytes)));
            }
        }), stringCodec, channelCodec);
        this.channelByDisplayNameCache = cacheManager.codec(cacheManager.redisCache("TwitchDisplayNameService|channelByDisplayName", 1, TimeUnit.HOURS, new CacheLoader<byte[], byte[]>() {
            @Override
            public byte[] load(final byte[] bytes) throws Exception {
                return channelCodec.encode(fetchChannelByDisplayName(stringCodec.decode(bytes)));
            }
        }), stringCodec, channelCodec);
        this.twitchApi = twitchApi;
    }

    public String getDisplayNameFromUserId(final String userId) throws NoSuchTargetException {
        try {
            return displayNameByUserIdCache.get(userId);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public String getUsernameFromUserId(final String userId) throws NoSuchTargetException {
        try {
            return usernameByUserIdCache.get(userId);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public String getDisplayNameFromUsername(final String username) throws NoSuchTargetException {
        try {
            return displayNameByUsernameCache.get(username);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public String getUsernameFromDisplayName(final String displayName) throws NoSuchTargetException {
        try {
            return usernameByDisplayNameCache.get(displayName);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public String getUserIdFromUsername(final String username) throws NoSuchTargetException {
        try {
            return userIdByUsernameCache.get(username);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public String getUserIdFromDisplayName(final String displayName) throws NoSuchTargetException {
        try {
            return userIdByDisplayNameCache.get(displayName);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public User getUserByUsername(final String username) throws NoSuchTargetException {
        try {
            return userByUsernameCache.get(username);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public User getUserByDisplayName(final String displayName) throws NoSuchTargetException {
        try {
            return userByDisplayNameCache.get(displayName);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public User getUserByUserId(final String userId) throws NoSuchTargetException {
        try {
            return userByUserIdCache.get(userId);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public String getDisplayNameFromChannelId(final String channelId) throws NoSuchTargetException {
        try {
            return displayNameByChannelIdCache.get(channelId);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public String getChannelNameFromChannelId(final String channelId) throws NoSuchTargetException {
        try {
            return channelNameByChannelIdCache.get(channelId);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public String getDisplayNameFromChannelName(final String channelName) throws NoSuchTargetException {
        try {
            return displayNameByChannelNameCache.get(channelName);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public String getChannelNameByDisplayName(final String displayName) throws NoSuchTargetException {
        try {
            return channelNameByDisplayNameCache.get(displayName);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public String getChannelIdByChannelName(final String channelName) throws NoSuchTargetException {
        try {
            return channelIdByChannelNameCache.get(channelName);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public String getChannelIdFromDisplayName(final String displayName) throws NoSuchTargetException {
        try {
            return channelIdByDisplayNameCache.get(displayName);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public Channel getChannelByChannelName(final String channelName) throws NoSuchTargetException {
        try {
            return channelByChannelNameCache.get(channelName);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public Channel getChannelByDisplayName(final String displayName) throws NoSuchTargetException {
        try {
            return channelByDisplayNameCache.get(displayName);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public Channel getChannelByChannelId(final String channelId) throws NoSuchTargetException {
        try {
            return channelByChannelIdCache.get(channelId);
        } catch (final ExecutionException e) {
            throw rethrowUnwrapped(e);
        }
    }

    public void cache(final String userId, final String username, final String displayName) {
        cacheUser(userId, username, displayName);
        cacheChannel(userId, username, displayName);
    }

    public void cacheUser(final String userId, final String username, final String displayName) {
        userIdByDisplayNameCache.put(displayName, userId);
        userIdByUsernameCache.put(username, userId);
        displayNameByUserIdCache.put(userId, displayName);
        displayNameByUsernameCache.put(username, displayName);
        usernameByDisplayNameCache.put(displayName, username);
        usernameByUserIdCache.put(userId, username);
    }

    public void cacheChannel(final String channelId, final String name, final String displayName) {
        channelIdByDisplayNameCache.put(displayName, channelId);
        channelIdByChannelNameCache.put(name, channelId);
        displayNameByChannelIdCache.put(channelId, displayName);
        displayNameByChannelNameCache.put(name, displayName);
        channelNameByDisplayNameCache.put(displayName, name);
        channelNameByChannelIdCache.put(channelId, name);
    }

    private void cacheUser(final User user) {
        if(user == null)
            return;
        if(user.getDisplayName() != null)
            userByDisplayNameCache.put(user.getDisplayName(), user);
        userByUsernameCache.put(user.getName(), user);
        userByUserIdCache.put(String.valueOf(user.getId()), user);
        cache(String.valueOf(user.getId()), user.getName(), user.getDisplayName());
    }

    private void cacheChannel(final Channel channel) {
        if(channel == null)
            return;
        if(channel.getDisplayName() != null)
            channelByDisplayNameCache.put(channel.getDisplayName(), channel);
        channelByChannelNameCache.put(channel.getName(), channel);
        channelByChannelIdCache.put(String.valueOf(channel.getId()), channel);
        cache(String.valueOf(channel.getId()), channel.getName(), channel.getDisplayName());
    }

    private User fetchUserByUserId(final String userId) throws NoSuchTargetException {
        try {
            final User user = twitchApi.getUsers().getUser(userId);
            cacheUser(user);
            return user;
        } catch(final NotFoundException e) {
            throw new NoSuchTargetException();
        }
    }

    private User fetchUserByUsername(final String username) throws NoSuchTargetException {
        final User user = twitchApi.getUsers().getUserByUsername(username);
        if(user == null)
            throw new NoSuchTargetException();
        cacheUser(user);
        return user;
    }

    private User fetchUserByDisplayName(final String displayName) throws NoSuchTargetException {
        final User user = fetchUserByUsername(displayName.toLowerCase());
        cacheUser(user);
        return user;
    }

    private Channel fetchChannelByChannelId(final String channelId) throws NoSuchTargetException {
        try {
            final Channel channel = twitchApi.getChannels().getChannel(channelId.split(":")[0]);
            cacheChannel(channel);
            return channel;
        } catch(final NotFoundException e) {
            throw new NoSuchTargetException();
        }
    }

    private Channel fetchChannelByChannelName(String channelName) throws NoSuchTargetException {
        // Twitch does not have a getChannelByChannelName, but we can get the user ID with the same name, and use that
        if(channelName.startsWith("#"))
            channelName = channelName.substring(1);
        final Channel channel = fetchChannelByChannelId(getUserIdFromUsername(channelName));
        cacheChannel(channel);
        return channel;
    }

    private Channel fetchChannelByDisplayName(final String displayName) throws NoSuchTargetException {
        final Channel channel = fetchChannelByChannelName(displayName.toLowerCase());
        cacheChannel(channel);
        return channel;
    }

    private Throwable unwrapException(final ExecutionException ee) {
        if(ee.getCause() == null)
            return ee;
        return ee.getCause();
    }

    private RuntimeException rethrowUnwrapped(final ExecutionException ee) throws NoSuchTargetException {
        final Throwable throwable = unwrapException(ee);
        if(throwable instanceof NoSuchTargetException)
            throw (NoSuchTargetException) throwable;
        if(throwable instanceof RuntimeException)
            throw (RuntimeException) throwable;
        throw new RuntimeException(throwable);
    }
}
