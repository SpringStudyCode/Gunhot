package dev.gunhot.store.Repository;

import dev.gunhot.store.Entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<ItemEntity, Long> {
}
