package dev.gunhot.store.Service;

import dev.gunhot.store.Dto.ItemDto;
import dev.gunhot.store.Dto.StoreDto;
import dev.gunhot.store.Entity.ItemEntity;
import dev.gunhot.store.Entity.StoreEntity;
import dev.gunhot.store.Repository.StoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    private static final Logger logger = LoggerFactory.getLogger(StoreService.class);
    private final StoreRepository storeRepository;

    public StoreService(@Autowired StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void createStore(StoreDto storeDto) {
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setName(storeDto.getName());
        this.storeRepository.save(storeEntity);
    }

    public void updateStore(int id, StoreDto storeDto) {
        Optional<StoreEntity> targetEntity = storeRepository.findById(Long.valueOf(id));
        if (targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        StoreEntity storeEntity = targetEntity.get();
        storeEntity.setName(storeDto.getName());
        this.storeRepository.save(storeEntity);
    }

    public void deleteStore(int id) {
        Optional<StoreEntity> targetEntity = storeRepository.findById(Long.valueOf(id));
        if (targetEntity.isEmpty())
        {
            throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        }
        StoreEntity storeEntity = targetEntity.get();
        this.storeRepository.delete(storeEntity);
    }

    public StoreDto readOneStore(int id) {
        Optional<StoreEntity> targetEntity = storeRepository.findById(Long.valueOf(id));
        if (targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        StoreEntity storeEntity = targetEntity.get();
        List<ItemDto> ItemDtoList = new ArrayList<ItemDto>();
        Iterator<ItemEntity> itemEntityIterator = storeEntity.getItemEntityList().iterator();
        while (itemEntityIterator.hasNext()) {
            ItemEntity itemEntity = itemEntityIterator.next();
            ItemDtoList.add(
                    new ItemDto(
                            Math.toIntExact(itemEntity.getId()),
                            itemEntity.getName(),
                            Math.toIntExact(itemEntity.getPrice()),
                            itemEntity.getStoreEntity() == null ? 0 : Math.toIntExact(itemEntity.getStoreEntity().getId())
                    )
            );
        }
        return new StoreDto(
                Math.toIntExact(storeEntity.getId()),
                storeEntity.getName(),
                ItemDtoList
        );
    }

    public List<StoreDto> readAllStore() {
        Iterator<StoreEntity> storeEntityIterator = this.storeRepository.findAll().iterator();
        List<StoreDto> storeDtoList = new ArrayList<StoreDto>();

        while (storeEntityIterator.hasNext()) {
            StoreEntity storeEntity = storeEntityIterator.next();
            Iterator<ItemEntity> itemEntityIterator = storeEntity.getItemEntityList().iterator();
//          각 객체별 Item List만들기
            List<ItemDto> ItemDtoList = new ArrayList<ItemDto>();
            while (itemEntityIterator.hasNext()) {
                ItemEntity itemEntity = itemEntityIterator.next();
                ItemDtoList.add(
                        new ItemDto(
                                Math.toIntExact(itemEntity.getId()),
                                itemEntity.getName(),
                                Math.toIntExact(itemEntity.getPrice()),
                                itemEntity.getStoreEntity() == null ? 0 : Math.toIntExact(itemEntity.getStoreEntity().getId())
                        )
                );
            }
            storeDtoList.add(
                    new StoreDto(
                            Math.toIntExact(storeEntity.getId()),
                            storeEntity.getName(),
                            ItemDtoList
                            )
            );
        }
        return storeDtoList;
    }
}
