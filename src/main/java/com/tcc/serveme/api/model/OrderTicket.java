package com.tcc.serveme.api.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.tcc.serveme.api.model.enums.Status;

public class OrderTicket {

    private Integer id;
    private Integer table;
    private Status status;
    private Client client;
    private List<Order> order = new ArrayList<>();
    
     @JsonCreator
    public OrderTicket(
        @JsonProperty("id") Integer id,
        @JsonProperty("table") Integer table,
        @JsonProperty("client") Client client,
        @JsonProperty("order") List<Order> order
    ) {
        this.id = id;
        this.table = table;
        this.status = Status.OPEN;
        this.client = client;
        this.order = order;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public Double calculateTotal(){
        Double bill = 0.0;
        for (Order o : order){
            bill += o.subTotal();
        }
        return bill;
    }

    public void closeOrderticket(){
        status = Status.CLOSED;
    }
    

}
