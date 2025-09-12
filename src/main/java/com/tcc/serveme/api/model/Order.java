package com.tcc.serveme.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    private Product product;
    private Integer quantity;

    @JsonCreator
    public Order(@JsonProperty("product") Product product, @JsonProperty("quantity") Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double subTotal(){
        return quantity * product.getPrice();
    }

    @Override
    public String toString() {
        return "Order [product = " + getProduct() + ", quantity = " + getQuantity() + "]";
    }

    

}
