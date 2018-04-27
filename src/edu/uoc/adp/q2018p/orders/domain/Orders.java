package edu.uoc.adp.q2018p.orders.domain;

public interface Orders {

    /**
     * Stores a new order persistently
     */
    void insertOrder(Order o);
}
