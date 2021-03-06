package tv.v1x1.common.dao;

import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import tv.v1x1.common.dto.db.PersistentLanguage;

import java.util.UUID;

/**
 * @author Josh
 */
@Singleton
public class DAOLanguage {
    private final Mapper<PersistentLanguage> mapper;

    @Inject
    public DAOLanguage(final MappingManager mappingManager) {
        mapper = mappingManager.mapper(PersistentLanguage.class);
    }

    public void put(final PersistentLanguage language) {
        mapper.save(language);
    }

    public PersistentLanguage get(final UUID id) {
        return mapper.get(id);
    }

    public void delete(final UUID id) {
        mapper.delete(id);
    }
}
