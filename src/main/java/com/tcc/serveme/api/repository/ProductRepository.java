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

    // *******************************
    //  Product-specific querys below
    // *******************************

    public Product findByIdIncludingInactive(Long id) { // Good for tests
        String sql = "SELECT id, sku, name, price, fk_category, inactive FROM product WHERE id = ?";
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
    }

    public List<Product> findByCategory(Long categoryId) {
        String sql = "SELECT id, sku, name, price, fk_category FROM product WHERE fk_category = ? AND inactive = FALSE";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class), categoryId);
    }

    public List<Product> findByName(String keyword) {
        String sql = "SELECT id, sku, name, price, fk_category FROM product WHERE name LIKE ? AND inactive = FALSE";
        String searchPattern = "%" + keyword + "%"; // keyword anywhere in the name
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class), searchPattern); 
    }

    public List<Product> findBySku(String keyword) {
        String sql = "SELECT id, sku, name, price, fk_category FROM product WHERE sku LIKE ? AND inactive = FALSE";
        String searchPattern = keyword + "%"; // needs to match SKU start keyword
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class), searchPattern);
    }

    public boolean existsBySku(String sku) {
        String sql = "SELECT COUNT(*) FROM product WHERE sku = ? AND inactive = FALSE";
        Integer count = jdbc.queryForObject(sql, Integer.class, sku);
        return count != null && count > 0; // Blocks creating another product with the same SKU
    }
}