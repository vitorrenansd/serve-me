package com.tcc.serveme.model;

public class Item {

    private Product product;
    private Integer quantity;
    private String notes;

    public Item(Product product, Integer quantity, String notes) {
        this.product = product;
        this.quantity = quantity;
        this.notes = notes;
    }

    public Product getProduct() {
        return this.product;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}