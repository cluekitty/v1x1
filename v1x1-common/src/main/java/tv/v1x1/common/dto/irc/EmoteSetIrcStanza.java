package tv.v1x1.common.dto.irc;

import tv.v1x1.common.dto.proto.core.IRC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by cobi on 10/9/2016.
 */
public abstract class EmoteSetIrcStanza extends TaggedIrcStanza {
    private Set<Integer> emoteSets = new HashSet<>();

    public EmoteSetIrcStanza(final String rawLine, final Map<String, String> tags, final IrcSource source, final IrcCommand command, final String rawArgs, final String[] args) {
        super(rawLine, tags, source, command, rawArgs, args);
        if(tags.containsKey("emote-sets") && !tags.get("emote-sets").isEmpty())
            emoteSets = Arrays.asList(tags.get("emote-sets").split(",")).stream().map(Integer::valueOf).collect(Collectors.toSet());
    }

    public Set<Integer> getEmoteSets() {
        return emoteSets;
    }

    protected IRC.EmoteSetIrcStanza toProtoEmoteSet() {
        return IRC.EmoteSetIrcStanza.newBuilder()
                .addAllEmoteSet(emoteSets)
                .setTaggedStanza(toProtoTagged())
                .build();
    }
}
