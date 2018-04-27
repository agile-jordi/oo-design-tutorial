package edu.uoc.adp.q2018p.orders.domain;

public class PreparedOrderState extends OrderState {

    private final Order order;

    PreparedOrderState(Order order) {
        this.order = order;
    }

    @Override
    public CancelLineResponse cancelLine(String productName) {
        return CancelLineResponse.cancellationDenied;
    }
}
