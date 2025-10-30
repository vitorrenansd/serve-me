package com.tcc.serveme.api.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.tcc.serveme.api.model.Product;

@Repository
public class ProductRepository {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public Product findById(Long id) {
        String sql = "SELECT id, name, price, fk_category FROM product WHERE id = ?";
        return template.queryForObject(
            sql,
            new BeanPropertyRowMapper<>(Product.class),
            id);
    }

    public List<Product> findAll() {
        String sql = "SELECT * FROM product";
        return template.query(
            sql,
            new BeanPropertyRowMapper<>(Product.class));
    }
}