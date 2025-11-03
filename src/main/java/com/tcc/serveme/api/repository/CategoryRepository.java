package com.tcc.serveme.api.repository;

import com.tcc.serveme.api.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Category> findAll() {
        String sql = "SELECT id, name FROM category WHERE inactive = FALSE";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
    }
}
