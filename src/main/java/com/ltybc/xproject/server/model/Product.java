package com.ltybc.xproject.server.model;

import com.ltybc.xproject.server.dao.CategoryDao;
import com.ltybc.xproject.server.service.CategoryService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @Size(min = 2, max = 60)
    @NotEmpty
    private String title;

    @Column(name = "price")
    @NotNull
    private Double price;

    @Column(name = "imageSrc")
    private String imageSrc;

    @ManyToOne(fetch = FetchType.EAGER
            , cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "categoryId")
    private Category category;

    public Product() {
    }

    public Product(String title, double price, Category category, String imageSrc) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.imageSrc = imageSrc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull
    public Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull Double price) {
        this.price = price;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
