package dev.gunhot.store.Entity;


import javax.persistence.*;

/*
id int
title varchar
content varchar
writer varchar
Store int
 */
/*
얘는 entity가 된다.
위에 있는 속성들을 적어주자
 */
@Entity
@Table(name="item")
public class ItemEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;

    @ManyToOne(targetEntity = StoreEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private StoreEntity storeEntity;

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public StoreEntity getStoreEntity() {
        return storeEntity;
    }

    public void setStoreEntity(StoreEntity storeEntity) {
        this.storeEntity = storeEntity;
    }

    public ItemEntity() {
    }

    public ItemEntity(Long id, String name, Long price, StoreEntity storeEntity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.storeEntity = storeEntity;
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", storeEntity=" + storeEntity +
                '}';
    }
}

