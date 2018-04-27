package edu.uoc.adp.q2018p.orders.domain;

enum CancelLineResponse{
    cancellationDone,
    cancellationRequested,
    cancellationDenied
}

public class UpdateOrder {

    private final Orders orders;

    public UpdateOrder(Orders orders) {
        this.orders = orders;
    }

    public CancelLineResponse cancelLine(String orderId, String productName){
        Order o = orders.getOrder(orderId);
        CancelLineResponse result = o.cancelLine(productName);
        orders.updateOrder(o);
        return result;
    }
}
