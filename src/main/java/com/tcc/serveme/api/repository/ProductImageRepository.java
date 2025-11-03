package com.tcc.serveme.api.repository;

import com.tcc.serveme.api.model.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductImageRepository {
    private final JdbcTemplate jdbc;

    @Autowired
    public ProductImageRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<String> findImagesByProductId(Long productId) {
        String sql = "SELECT url FROM product_image WHERE fk_product = ?";
        return jdbc.queryForList(sql, String.class, productId);
    }

    public int save(ProductImage productImage) {
        String sql = "INSERT INTO product_image(fk_product, url) VALUES (?, ?)";
        return jdbc.update(sql, productImage.getFkProduct(), productImage.getImage());
    }

    public int deleteByProductId(Long productId) {
        String sql = "DELETE FROM product_image WHERE fk_product = ?";
        return jdbc.update(sql, productId);
    }
}