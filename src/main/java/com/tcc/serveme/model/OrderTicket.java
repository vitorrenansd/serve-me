package com.tcc.serveme.model;

import java.util.ArrayList;
import java.util.List;
import com.tcc.serveme.model.enums.Status;

public class OrderTicket {

    private Integer id;
    private Integer table;
    private String waiter;
    private List<Order> order = new ArrayList<>();
    private Status status;
    
    // Complete constructor (read from database)
    public OrderTicket(Integer id, Integer table, String waiter, List<Order> order) {
        this.id = id;
        this.table = table;
        this.waiter = waiter;
        this.order = order;
        this.status = Status.OPEN;
    }

    // Constructor for new orders (without ID yet)
    // OrderMapper will use that
    public OrderTicket(Integer table, String waiter, List<Order> order) {
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

    public List<Order> getOrder() {
        return order;
    }

    public void addProduct(Order item) {
        order.add(item);
    }

    public void removeProduct(Order item) {
        order.remove(item);
    }

    public void closeOrderticket(){
        status = Status.CLOSED;
    }
}