package dev.gunhot.store.Controller;

import dev.gunhot.store.Dto.ItemDto;
import dev.gunhot.store.Service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@RestController
@RequestMapping("item")
public class ItemController {
    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;

    public ItemController(@Autowired ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@RequestBody ItemDto itemDto){
        this.itemService.createItem(itemDto);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateItem(@PathVariable("id") int id, @RequestBody ItemDto itemDto){
        this.itemService.updateItem(id, itemDto);
    }

    @GetMapping("{id}")
    public ItemDto readItem(@PathVariable("id") int id)
    {
        return this.itemService.readItem(id);
    }

    @GetMapping("")
    public List<ItemDto> readAllItem()
    {
        return this.itemService.readAllItem();
    }

    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable("id") int id)
    {
        this.itemService.deleteItem(id);
    }

}
