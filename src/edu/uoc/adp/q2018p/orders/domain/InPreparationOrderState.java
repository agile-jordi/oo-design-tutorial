package edu.uoc.adp.q2018p.orders.domain;

import java.util.List;

public class InPreparationOrderState extends OrderState {

    private final Order order;

    InPreparationOrderState(Order order) {
        this.order = order;
    }

    @Override
    public void finishPreparation(List<String> cancelledLines) {
        this.order.setPreparationFinished(cancelledLines);
    }

    public CancelLineResponse cancelLine(String productName) {
        boolean found = order.setLineCancellationRequested(productName);
        if(!found) return CancelLineResponse.cancellationDenied;
        return CancelLineResponse.cancellationRequested;
    }
}
