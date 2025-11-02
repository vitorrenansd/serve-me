package com.tcc.serveme.api.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.tcc.serveme.api.model.Orders;

@Repository
public class OrdersRepository implements GenericRepository<Orders, Long>{
    private JdbcTemplate jdbc;
    
    public JdbcTemplate getTemplate() {
        return jdbc;
    }

    @Autowired
    public void setTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Orders findById(Long id) {
        String sql = "SELECT id, table_number, waiter, total, created_at, status FROM orders WHERE id = ?";
        List<Orders> result = jdbc.query(sql, new BeanPropertyRowMapper<>(Orders.class), id);
        return result.isEmpty() ? null : result.get(0); // Return null if cant find a order
    }

    @Override
    public List<Orders> findAll() {
        String sql = "SELECT id, table_number, waiter, total, created_at, status FROM orders";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Orders.class));
    }

    @Override
    public int save(Orders order) {
        String sql = "INSERT INTO orders(table_number, waiter, total, created_at, status) VALUES (?, ?, ?, ?, ?)";
        return jdbc.update(sql, order.getTableNumber(), order.getWaiter(), order.getTotal(), order.getCreatedAt(), order.getStatus());
    }
    
    @Override
    public int update(Orders order) {
        String sql = "UPDATE orders SET table_number = ?, waiter = ?, total = ?, created_at = ?, status = ? WHERE id = ?";
        return jdbc.update(sql, order.getTableNumber(), order.getWaiter(), order.getTotal(), order.getCreatedAt(), order.getStatus(), order.getId());
    }

    @Override
    public int softDelete(Long id) {
        String sql = "UPDATE orders SET status = 'CANCELED' WHERE id = ?";
        return jdbc.update(sql, id);
    }

    // *******************************
    //  Product-specific querys below
    // *******************************
}