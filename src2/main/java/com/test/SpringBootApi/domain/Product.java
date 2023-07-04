package com.test.SpringBootApi.domain;

import javax.persistence.*;

@Entity //얘를 통해 entity를 만들라고 함
@Table(name="products")
public class Product {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO) //하나씩 커져가는 규칙으로 ID 부여
    private Long id;

    @Column(name = "product_name")
    private String name;
    @Column(name = "price")
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product()
    {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
