package com.ltybc.xproject.server.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "products")
    @ElementCollection
    private List<Long> products = new ArrayList<>();

//    @OneToOne
//    private User user;

    public Cart() {
    }

    public Cart(List<Long> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getProducts() {
        return products;
    }

    public void setProducts(List<Long> products) {
        this.products = products;
    }
}
