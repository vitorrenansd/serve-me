package com.tcc.serveme.api.model;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String sku; // Its common SKU having letters and numbers
    private String name;
    private BigDecimal price;
    private Long fkCategory;
    private boolean inactive;

    public Long getid() {
        return this.id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getFkCategory() {
        return fkCategory;
    }

    public void setFkCategory(Long fkCategory) {
        this.fkCategory = fkCategory;
    }

    public boolean getInactive() {
        return this.inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", sku='" + sku + "', name='" + name + '\'' + ", price=" + price + ", fk_category=" + fkCategory + ", inactive=" + inactive + "}\n";
    }
}