package edu.uoc.adp.q2018p.orders.domain;

public interface Orders {

    /**
     * Stores a new order persistently
     */
    void insertOrder(Order o);


    /**
     * Returns the order identified by orderId
     * @throws RuntimeException if no order with such an id exists
     */
    Order getOrder(String orderId);

    /**
     * Update the order in the persistent store to match the current order received as order
     * @throws RuntimeException if no order with id order.getId() exists
     */
    void updateOrder(Order order);
}
