package com.tcc.serveme.api.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.tcc.serveme.api.model.Product;

@Repository
public class ProductRepository implements GenericRepository<Product, Long> {
    private JdbcTemplate jdbc;

    public JdbcTemplate getTemplate() {
        return jdbc;
    }

    @Autowired
    public void setTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Product findById(Long id) {
        String sql = "SELECT id, sku, name, price, fk_category FROM product WHERE id = ? AND inactive = FALSE";
        List<Product> results = jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class), id);
        return results.isEmpty() ? null : results.get(0); // Return null if cant find a product
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT id, sku, name, price, fk_category FROM product WHERE inactive = FALSE";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public int save(Product product) {
        String sql = "INSERT INTO product(sku, name, price, fk_category) VALUES (?, ?, ?, ?)";
        return jdbc.update(sql, product.getSku(), product.getName(), product.getPrice(), product.getFkCategory());
    }

    @Override
    public int update(Product product) {
        String sql = "UPDATE product SET sku = ?, name = ?, price = ?, fk_category = ? WHERE id = ?";
        return jdbc.update(sql, product.getSku(), product.getName(), product.getPrice(), product.getFkCategory(), product.getId());
    }

    @Override
    public int softDelete(Long id) {
        String sql = "UPDATE product SET inactive = TRUE WHERE id = ?";
        return jdbc.update(sql, id);
    }
}