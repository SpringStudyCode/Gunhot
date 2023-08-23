package dev.gunhot.store.Repository;

import dev.gunhot.store.Entity.StoreEntity;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<StoreEntity, Long> {
}
