package com.tcc.serveme.api.model;

public class ProductImage {
    private Long id;
    private Long fkProduct;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkProduct() {
        return fkProduct;
    }

    public void setFkProduct(Long fkProduct) {
        this.fkProduct = fkProduct;
    }


}
