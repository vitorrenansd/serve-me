package com.model.entities;

import com.model.enums.Table;

public class Order {

    private Table table;
    private Product product;
    private Integer quantity;

    public Order(Table table, Product product, Integer quantity) {
        this.table = table;
        this.product = product;
        this.quantity = quantity;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
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

}
