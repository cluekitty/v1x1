package tv.v1x1.modules.core.api.api.pubsub.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 * Created by cobi on 7/9/2017.
 */
public class UnlistenResponseWebSocketFrame extends ResponseWebSocketFrame {
    @JsonProperty
    private String topic;

    public UnlistenResponseWebSocketFrame() {
        super();
    }

    public UnlistenResponseWebSocketFrame(final UUID id, final UUID responseTo, final String topic) {
        super(id, WebSocketFrameType.UNLISTEN_RESPONSE, responseTo);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(final String topic) {
        this.topic = topic;
    }
}
