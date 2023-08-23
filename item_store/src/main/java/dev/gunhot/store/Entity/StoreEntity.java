package dev.gunhot.store.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="store")
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(targetEntity = ItemEntity.class, fetch = FetchType.LAZY,mappedBy = "storeEntity")
    private List<ItemEntity> itemEntityList = new ArrayList<ItemEntity>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemEntity> getItemEntityList() {
        return itemEntityList;
    }

    public void setItemEntityList(List<ItemEntity> itemEntityList) {
        this.itemEntityList = itemEntityList;
    }

    public StoreEntity() {
    }

    public StoreEntity(Long id, String name, List<ItemEntity> itemEntityList) {
        this.id = id;
        this.name = name;
        this.itemEntityList = itemEntityList;
    }

    @Override
    public String toString() {
        return "StoreEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemEntityList=" + itemEntityList +
                '}';
    }
}
