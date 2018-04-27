package edu.uoc.adp.q2018p.orders.domain;

public class PlacedOrderState extends OrderState {
    private final Order order;

    PlacedOrderState(Order order) {
        this.order = order;
    }

    @Override
    public void startPreparation() {
        order.setState(new InPreparationOrderState(order));
    }

    public CancelLineResponse cancelLine(String productName) {
        boolean removed = order.removeLine(productName);
        if(!removed) return CancelLineResponse.cancellationDenied;
        return CancelLineResponse.cancellationDone;
    }
}
