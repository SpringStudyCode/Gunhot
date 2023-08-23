package dev.gunhot.store.Controller;
import dev.gunhot.store.Dto.ItemDto;
import dev.gunhot.store.Dto.StoreDto;
import dev.gunhot.store.Service.StoreService;
import org.apache.catalina.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@RestController
@RequestMapping("store")
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
    private final StoreService storeService;
    public StoreController(@Autowired StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStore(@RequestBody StoreDto storeDto)
    {
        this.storeService.createStore(storeDto);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateStore(@PathVariable("id") int id, @RequestBody StoreDto storeDto)
    {
        this.storeService.updateStore(id, storeDto);
    }

    @GetMapping("{id}")
    public StoreDto readOneStore(@PathVariable("id") int id)
    {
        return this.storeService.readOneStore(id);
    }

    @GetMapping
    public List<StoreDto> readAllStore()
    {
        return this.storeService.readAllStore();
    }

    @DeleteMapping("{id}")
    public void deleteStore(@PathVariable("id") int id)
    {
        this.storeService.deleteStore(id);
    }
}
