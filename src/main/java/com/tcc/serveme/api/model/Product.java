package com.tcc.serveme.api.model;

import java.math.BigDecimal;

public class Product {
    private Long productId;
    private String name;
    private BigDecimal price;
    private boolean inactive;

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    @Override
    public String toString() {
        return "Product{id=" + productId + ", name='" + name + '\'' +
               ", price=" + price + ", inactive=" + inactive + '}';
    }
}