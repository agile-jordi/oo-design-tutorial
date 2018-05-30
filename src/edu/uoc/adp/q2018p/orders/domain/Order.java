package edu.uoc.adp.q2018p.orders.domain;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

public class Order {

    private final String id;
    private final Instant orderedAt;
    private final Customer customer;
    private List<OrderLine> orderLines;
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

    CancelLineResponse cancelLine(String productName) {
        return state.cancelLine(productName);
    }

    private OrderLine findOrderLine(String productName){
        for(OrderLine ol : orderLines){
            if(ol.isForProduct(productName)) return ol;
        }
        return null;
    }

    boolean removeLine(String productName) {
        OrderLine ol = findOrderLine(productName);
        if(ol == null) return false;
        orderLines.remove(ol);
        return true;
    }

    boolean setLineCancellationRequested(String productName) {
        OrderLine ol = findOrderLine(productName);
        if(ol == null) return false;
        ol.setCancellationRequested();
        return true;
    }

    private void removeLines(List<String> lines) {
        List<OrderLine> resultingOrderLines = new LinkedList<>();
        for(OrderLine ol : orderLines){
            if(!ol.isForProductIn(lines)){
                resultingOrderLines.add(ol);
            }
        }
        this.orderLines = resultingOrderLines;
    }

    void setPreparationFinished(List<String> cancelledLines) {
        removeLines(cancelledLines);
        setState(new PreparedOrderState());

    }
}
