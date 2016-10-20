package tv.twitchbot.common.rpc.services;

import tv.twitchbot.common.dto.messages.Request;
import tv.twitchbot.common.dto.messages.Response;
import tv.twitchbot.common.modules.GlobalConfiguration;
import tv.twitchbot.common.modules.Module;
import tv.twitchbot.common.modules.ModuleSettings;
import tv.twitchbot.common.modules.TenantConfiguration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cobi on 10/19/2016.
 */
public abstract class ThreadedService<T extends Request, U extends Response<T>> extends Service<T, U> {
    private ExecutorService executorService = Executors.newCachedThreadPool();

    public ThreadedService(Module<? extends ModuleSettings, ? extends GlobalConfiguration, ? extends TenantConfiguration> module, String serviceName, Class<T> requestClass) {
        super(module, serviceName, requestClass);
    }

    @Override
    protected void handleRequest(T request) {
        executorService.submit(() -> ThreadedService.super.handleRequest(request));
    }
}