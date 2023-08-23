package dev.gunhot.store.Dto;

import java.util.List;

public class StoreDto {
    private int id;
    private String name;
    private List<ItemDto> itemDtoList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemDto> getItemDtoList() {
        return itemDtoList;
    }

    public void setItemDtoList(List<ItemDto> itemDtoList) {
        this.itemDtoList = itemDtoList;
    }

    public StoreDto() {
    }

    public StoreDto(int id, String name, List<ItemDto> itemDtoList) {
        this.id = id;
        this.name = name;
        this.itemDtoList = itemDtoList;
    }
}
