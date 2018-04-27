package edu.uoc.adp.q2018p.orders.domain;

import java.util.List;

public abstract class OrderState {

    void startPreparation() {
        throw new IllegalStateException();
    }

    void finishPreparation(List<String> cancelledLines) {
        throw new IllegalStateException();
    }

    abstract CancelLineResponse cancelLine(String productName);
}
