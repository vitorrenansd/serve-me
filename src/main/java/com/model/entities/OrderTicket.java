package com.model.entities;

import java.util.ArrayList;
import java.util.List;
import com.model.enums.Status;

public class OrderTicket {

    private Integer id;
    private Status status;
    private Client client;
    private List<Order> order = new ArrayList<>();
    
    public OrderTicket(Integer id, Status status, Client client, List<Order> order) {
        this.id = id;
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
