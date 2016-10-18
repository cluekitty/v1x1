package tv.twitchbot.modules.core.chatrouter;

import tv.twitchbot.common.dto.core.Channel;
import tv.twitchbot.common.dto.messages.requests.SendMessageRequest;
import tv.twitchbot.common.dto.messages.responses.SendMessageResponse;
import tv.twitchbot.common.modules.GlobalConfiguration;
import tv.twitchbot.common.modules.Module;
import tv.twitchbot.common.modules.ModuleSettings;
import tv.twitchbot.common.modules.TenantConfiguration;
import tv.twitchbot.common.rpc.client.ServiceClient;

import java.util.concurrent.Future;

/**
 * Created by cobi on 10/16/2016.
 */
public class TmiServiceClient extends ServiceClient<SendMessageRequest, SendMessageResponse> {
    private String channel;

    public TmiServiceClient(Module<? extends ModuleSettings, ? extends GlobalConfiguration, ? extends TenantConfiguration> module, String channel) {
        super(module, SendMessageResponse.class);
        this.channel = channel;
    }

    @Override
    protected String getServiceName() {
        return "Core|TMI|Channel|" + channel;
    }

    public Future<SendMessageResponse> sendMessage(Channel channel, String text) {
        return send(new SendMessageRequest(getModule(), getQueueName(), channel, text));
    }
}