package dev.gunhot.store.Dto;

public class ItemDto {
    private int id;
    private String name;
    private int price;
    private int store_id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public ItemDto() {
    }

    public ItemDto(int id, String name, int price, int store_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.store_id = store_id;
    }
}
