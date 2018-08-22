package com.ltybc.xproject.server.model;

import com.ltybc.xproject.server.utils.Utils;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "tag")
    private String tag;

    public Category() {
    }

    public Category(String category) {
        this.category = category;
        this.tag = Utils.generateTag(category);
    }

    public Category(String category, String tag) {
        this.category = category;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
