package com.tcc.serveme.api.model;

import java.util.ArrayList;
import java.util.List;

import com.tcc.serveme.api.model.enums.Status;

public class Order {

    private Integer id;
    private Integer table;
    private String waiter;
    private List<Item> order = new ArrayList<>();
    private Status status;
    
    // Complete constructor (read from database)
    public Order(Integer id, Integer table, String waiter, List<Item> order) {
        this.id = id;
        this.table = table;
        this.waiter = waiter;
        this.order = order;
        this.status = Status.OPEN;
    }

    // Constructor for new orders (without ID yet)
    // OrderMapper will use that
    public Order(Integer table, String waiter, List<Item> order) {
        this.table = table;
        this.waiter = waiter;
        this.order = order;
        this.status = Status.OPEN;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTable() {
        return table;
    }

    public void setTable(Integer table) {
        this.table = table;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getWaiter() {
        return this.waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public List<Item> getOrder() {
        return order;
    }

    public void addProduct(Item item) {
        order.add(item);
    }

    public void removeProduct(Item item) {
        order.remove(item);
    }

    public void closeOrderticket(){
        status = Status.CLOSED;
    }
}