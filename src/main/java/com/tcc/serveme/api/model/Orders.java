package com.tcc.serveme.api.model;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.tcc.serveme.api.model.enums.OrderStatus;

public class Orders {
    private Integer id;
    private Integer tableNumber;
    private String waiter;
    private BigDecimal total;
    private LocalDateTime createdAt;
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<>();

    // Full constructor (used when reading from DB)
    public Orders(Integer id, Integer tableNumber, String waiter, BigDecimal total, LocalDateTime createdAt, List<OrderItem> items, OrderStatus status) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.waiter = waiter;
        this.total = total;
        this.createdAt = createdAt;
        this.items = items != null ? items : new ArrayList<>();
        this.status = status != null ? status : OrderStatus.PENDING;
    }

    // Constructor for new orders (without ID and createdAt)
    public Orders(Integer tableNumber, String waiter, List<OrderItem> items) {
        this.tableNumber = tableNumber;
        this.waiter = waiter;
        this.items = items != null ? items : new ArrayList<>();
        this.status = OrderStatus.PENDING;
        this.total = BigDecimal.ZERO;
        this.createdAt = LocalDateTime.now();
    }

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTableNumber() {
        return this.tableNumber;
    }
    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getWaiter() {
        return this.waiter;
    }
    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public BigDecimal getTotal() {
        return this.total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OrderStatus getStatus() {
        return this.status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }
    public void addItem(OrderItem item) {
        items.add(item);
    }
    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public void markAsCompleted() { 
        status = OrderStatus.COMPLETED; 
    }
    public void markAsInProgress() {
        status = OrderStatus.IN_PROGRESS;
    }
    public void markAsCanceled() {
        status = OrderStatus.CANCELED;
    }
}