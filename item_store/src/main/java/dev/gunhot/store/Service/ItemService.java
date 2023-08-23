package dev.gunhot.store.Service;

import dev.gunhot.store.Dto.ItemDto;
import dev.gunhot.store.Entity.ItemEntity;
import dev.gunhot.store.Entity.StoreEntity;
import dev.gunhot.store.Repository.ItemRepository;

import dev.gunhot.store.Repository.StoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class ItemService {
    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);
    private final ItemRepository itemRepository;
    private final StoreRepository storeRepository;
    public ItemService(@Autowired ItemRepository itemRepository, @Autowired StoreRepository storeRepository) {
        this.itemRepository = itemRepository;
        this.storeRepository = storeRepository;
    }

    public void createItem(ItemDto itemDto) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setName(itemDto.getName());
        itemEntity.setPrice(Long.valueOf(itemDto.getPrice()));
        Optional<StoreEntity> storeEntity = storeRepository.findById(Long.valueOf(itemDto.getStore_id()));
        if (storeEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        itemEntity.setStoreEntity(storeEntity.get());
        this.itemRepository.save(itemEntity);
    }

    public void updateItem(int id, ItemDto ItemDto) {
        Optional<ItemEntity> targetEntity = itemRepository.findById(Long.valueOf(id));
        if (targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        // 바뀔놈
        ItemEntity itemEntity = targetEntity.get();
        itemEntity.setName(
                ItemDto.getName() == null ? itemEntity.getName() : ItemDto.getName());
        itemEntity.setPrice(
                Long.valueOf(ItemDto.getPrice()) == 0 ? itemEntity.getPrice() : Long.valueOf(ItemDto.getPrice()));
        Optional<StoreEntity> targetStoreEntiy = storeRepository.findById(Long.valueOf(ItemDto.getStore_id()));
        if(targetStoreEntiy.isEmpty())
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        StoreEntity storeEntity = targetStoreEntiy.get();
        itemEntity.setStoreEntity(storeEntity);
        this.itemRepository.save(itemEntity);
    }

    public void deleteItem(int id) {
        Optional<ItemEntity> targetEntity = itemRepository.findById(Long.valueOf(id));
        if (targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        // 바뀔놈
        this.itemRepository.delete(targetEntity.get());
    }

    public ItemDto readItem(int id) {
        Optional<ItemEntity> targetEntity = this.itemRepository.findById(Long.valueOf(id));
        if (targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        // Optional은 바로 못쓰고 한 번 받아야 쓸 수 있음
        ItemEntity itemEntity = targetEntity.get();

        return new ItemDto(
            Math.toIntExact(itemEntity.getId()),
            itemEntity.getName(),
            Math.toIntExact(itemEntity.getPrice()),
            itemEntity.getStoreEntity() == null ? 0 : Math.toIntExact(itemEntity.getStoreEntity().getId())
            );
    }

    public List<ItemDto> readAllItem() {
        // iterator로 바꿔줘야함
        Iterator<ItemEntity> ItemEntityIterator = this.itemRepository.findAll().iterator();
        List<ItemDto> ItemDtoList = new ArrayList<ItemDto>();
        while(ItemEntityIterator.hasNext())
        {
            ItemEntity itemEntity = ItemEntityIterator.next();
            ItemDtoList.add(
                new ItemDto(
                    Math.toIntExact(itemEntity.getId()),
                    itemEntity.getName(),
                    Math.toIntExact(itemEntity.getPrice()),
                    itemEntity.getStoreEntity() == null ? 0 : Math.toIntExact(itemEntity.getStoreEntity().getId())
                    )
            );
        }
        return ItemDtoList;
    }
}
