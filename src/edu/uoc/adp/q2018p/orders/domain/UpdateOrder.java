package edu.uoc.adp.q2018p.orders.domain;

enum CancelLineResponse{
    cancelled,
    requested,
    denied
}

public class UpdateOrder {

    private final Orders orders;

    private Customer customer;

    public UpdateOrder(Orders orders) {
        this.orders = orders;
    }

    public CancelLineResponse cancelLine(String orderId, String productName){
        // PENDENT: Dissenyar
    }
}
