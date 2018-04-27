package edu.uoc.adp.q2018p.orders.domain;

public interface Customers {

    /**
     * Returns the customer identified by email
     * @throws RuntimeException if the customer does not exist
     */
    Customer getCustomer(String email);
}
