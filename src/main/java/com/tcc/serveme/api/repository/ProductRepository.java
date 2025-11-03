package com.tcc.serveme.api.repository;

import com.tcc.serveme.api.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class ProductRepository implements GenericRepository<Product, Long> {
    private final JdbcTemplate jdbc;
    private final ProductImageRepository productImageRepository;

    @Autowired
    public ProductRepository(JdbcTemplate jdbc, ProductImageRepository productImageRepository) {
        this.jdbc = jdbc;
        this.productImageRepository = productImageRepository;
    }

    @Override
    public Product findById(Long id) {
        String sql = "SELECT id, sku, name, description, price, fk_category FROM product WHERE id = ? AND inactive = FALSE";
        Product product = jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
        if (product != null) {
            product.setImages(productImageRepository.findImagesByProductId(id));
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT id, sku, name, description, price, fk_category FROM product WHERE inactive = FALSE";
        List<Product> products = jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class));
        for (Product product : products) {
            product.setImages(productImageRepository.findImagesByProductId(product.getId()));
        }
        return products;
    }

    @Override
    public long save(Product product) {
        String sql = "INSERT INTO product(sku, name, description, price, fk_category) VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getSku());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
            ps.setBigDecimal(4, product.getPrice());
            ps.setLong(5, product.getFkCategory());
            return ps;
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            return keyHolder.getKey().longValue();
        } else {
            throw new RuntimeException("Generated key is null");
        }
    }

    @Override
    public int update(Product product) {
        String sql = "UPDATE product SET sku = ?, name = ?, description = ?, price = ?, fk_category = ? WHERE id = ?";
        return jdbc.update(sql, product.getSku(), product.getName(), product.getDescription(), product.getPrice(), product.getFkCategory(), product.getId());
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
        String sql = "SELECT id, sku, name, description, price, fk_category, inactive FROM product WHERE id = ?";
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
    }

    public List<Product> findByCategory(Long categoryId) {
        String sql = "SELECT id, sku, name, description, price, fk_category FROM product WHERE fk_category = ? AND inactive = FALSE";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class), categoryId);
    }

    public List<Product> findByName(String keyword) {
        String sql = "SELECT id, sku, name, description, price, fk_category FROM product WHERE name LIKE ? AND inactive = FALSE";
        String searchPattern = "%" + keyword + "%"; // keyword anywhere in the name
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class), searchPattern);
    }

    public List<Product> findBySku(String keyword) {
        String sql = "SELECT id, sku, name, description, price, fk_category FROM product WHERE sku LIKE ? AND inactive = FALSE";
        String searchPattern = keyword + "%"; // needs to match SKU start keyword
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class), searchPattern);
    }

    public boolean existsBySku(String sku) {
        String sql = "SELECT COUNT(*) FROM product WHERE sku = ? AND inactive = FALSE";
        Integer count = jdbc.queryForObject(sql, Integer.class, sku);
        return count != null && count > 0; // Blocks creating another product with the same SKU
    }
}