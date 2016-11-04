package tv.v1x1.modules.core.api;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import tv.v1x1.common.services.persistence.DAOManager;

/**
 * Created by cobi on 10/24/2016.
 */
public class ApiGuiceModule extends AbstractModule {
    private final ApiModule apiModule;

    public ApiGuiceModule(final ApiModule module) {
        this.apiModule = module;
    }

    @Override
    protected void configure() {

    }

    @Provides
    public ApiModule provideApiModule() {
        return apiModule;
    }

    @Provides
    public DAOManager provideDAOManager() {
        return apiModule.getDaoManager();
    }
}