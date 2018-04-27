package edu.uoc.adp.q2018p.orders.domain;

import java.time.Instant;
import java.util.List;

public class Order {

    private final String id;
    private final Instant orderedAt;
    private final Customer customer;
    private final List<OrderLine> orderLines;
    private final Address address;
    private final InstantRange deliveryWindow;
    private Instant deliveredAt;
    private OrderState state;


    public Order(String id, Instant orderedAt, Customer customer, List<OrderLine> orderLines, Address address, InstantRange deliveryWindow) {
        this.id = id;
        this.orderedAt = orderedAt;
        this.customer = customer;
        this.orderLines = orderLines;
        this.address = address;
        this.deliveryWindow = deliveryWindow;
        this.deliveredAt = null;
        this.state = new PlacedOrderState(this);
    }

    private Money getTotalPrice() {
        Money result = Money.zero;
        for (OrderLine ol : orderLines) {
            result = result.sum(ol.getPrice(this.orderedAt));
        }
        return result;
    }

    void startPreparation(){
        this.state.startPreparation();
    }

    void finishPreparation(List<String> cancelledLines){
        this.state.finishPreparation(cancelledLines);
    }

    void setState(OrderState state) {
        this.state = state;
    }
}
