package tv.v1x1.common.services.persistence;

import com.datastax.driver.mapping.MappingManager;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.redisson.api.RedissonClient;
import tv.v1x1.common.dao.DAOChannelConfiguration;
import tv.v1x1.common.dao.DAOChannelGroupConfiguration;
import tv.v1x1.common.dao.DAOChannelGroupPlatformGroups;
import tv.v1x1.common.dao.DAOConfigurationDefinition;
import tv.v1x1.common.dao.DAOGlobalConfiguration;
import tv.v1x1.common.dao.DAOGlobalUser;
import tv.v1x1.common.dao.DAOI18nDefinition;
import tv.v1x1.common.dao.DAOJoinedTwitchChannel;
import tv.v1x1.common.dao.DAOKeyValueEntry;
import tv.v1x1.common.dao.DAOLanguage;
import tv.v1x1.common.dao.DAOPermissionDefinition;
import tv.v1x1.common.dao.DAOTenant;
import tv.v1x1.common.dao.DAOTenantConfiguration;
import tv.v1x1.common.dao.DAOTenantGroup;
import tv.v1x1.common.dao.DAOThirdPartyCredential;
import tv.v1x1.common.dao.DAOTwitchOauthToken;
import tv.v1x1.common.services.state.DisplayNameService;

/**
 *
 * @author Cobi
 */
@Singleton
public class DAOManager {
    private final DAOTenant daoTenant;
    private final DAOGlobalUser daoGlobalUser;
    private final DAOTenantGroup daoTenantGroup;
    private final DAOKeyValueEntry daoKeyValueEntry;
    private final DAOTenantConfiguration daoTenantConfiguration;
    private final DAOGlobalConfiguration daoGlobalConfiguration;
    private final DAOLanguage daoLanguage;
    private final DAOConfigurationDefinition daoConfigurationDefinition;
    private final DAOChannelConfiguration daoChannelConfiguration;
    private final DAOChannelGroupConfiguration daoChannelGroupConfiguration;
    private final DAOThirdPartyCredential daoThirdPartyCredential;
    private final DAOTwitchOauthToken daoTwitchOauthToken;
    private final DAOJoinedTwitchChannel daoJoinedTwitchChannel;
    private final DAOI18nDefinition daoI18nDefinition;
    private final DAOPermissionDefinition daoPermissionDefinition;
    private final DAOChannelGroupPlatformGroups daoChannelGroupPlatformGroups;

    @Inject
    public DAOManager(final RedissonClient redissonClient, final MappingManager mappingManager, final DisplayNameService displayNameService) {
        daoTenant = new DAOTenant(redissonClient, mappingManager, displayNameService);
        daoGlobalUser = new DAOGlobalUser(redissonClient, mappingManager, displayNameService);
        daoTenantGroup = new DAOTenantGroup(mappingManager);
        daoKeyValueEntry = new DAOKeyValueEntry(mappingManager);
        daoTenantConfiguration = new DAOTenantConfiguration(mappingManager);
        daoGlobalConfiguration = new DAOGlobalConfiguration(mappingManager);
        daoLanguage = new DAOLanguage(mappingManager);
        daoConfigurationDefinition = new DAOConfigurationDefinition(mappingManager);
        daoChannelConfiguration = new DAOChannelConfiguration(mappingManager);
        daoChannelGroupConfiguration = new DAOChannelGroupConfiguration(mappingManager);
        daoThirdPartyCredential = new DAOThirdPartyCredential(mappingManager);
        daoTwitchOauthToken = new DAOTwitchOauthToken(mappingManager);
        daoJoinedTwitchChannel = new DAOJoinedTwitchChannel(mappingManager);
        daoI18nDefinition = new DAOI18nDefinition(mappingManager);
        daoPermissionDefinition = new DAOPermissionDefinition(mappingManager);
        daoChannelGroupPlatformGroups = new DAOChannelGroupPlatformGroups(mappingManager);
    }

    public DAOTenant getDaoTenant() {
        return daoTenant;
    }

    public DAOGlobalUser getDaoGlobalUser() {
        return daoGlobalUser;
    }

    public DAOTenantGroup getDaoTenantGroup() {
        return daoTenantGroup;
    }

    public DAOKeyValueEntry getDaoKeyValueEntry() {
        return daoKeyValueEntry;
    }

    public DAOTenantConfiguration getDaoTenantConfiguration() {
        return daoTenantConfiguration;
    }

    public DAOGlobalConfiguration getDaoGlobalConfiguration() {
        return daoGlobalConfiguration;
    }

    public DAOLanguage getDaoLanguage() {
        return daoLanguage;
    }

    public DAOConfigurationDefinition getDaoConfigurationDefinition() {
        return daoConfigurationDefinition;
    }

    public DAOChannelConfiguration getDaoChannelConfiguration() {
        return daoChannelConfiguration;
    }

    public DAOThirdPartyCredential getDaoThirdPartyCredential() {
        return daoThirdPartyCredential;
    }

    public DAOTwitchOauthToken getDaoTwitchOauthToken() {
        return daoTwitchOauthToken;
    }

    public DAOJoinedTwitchChannel getDaoJoinedTwitchChannel() {
        return daoJoinedTwitchChannel;
    }

    public DAOChannelGroupConfiguration getDaoChannelGroupConfiguration() {
        return daoChannelGroupConfiguration;
    }

    public DAOI18nDefinition getDaoI18nDefinition() {
        return daoI18nDefinition;
    }

    public DAOPermissionDefinition getDaoPermissionDefinition() {
        return daoPermissionDefinition;
    }

    public DAOChannelGroupPlatformGroups getDaoChannelGroupPlatformGroups() {
        return daoChannelGroupPlatformGroups;
    }
}
