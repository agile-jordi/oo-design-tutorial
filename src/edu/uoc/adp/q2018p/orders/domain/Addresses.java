package edu.uoc.adp.q2018p.orders.domain;

public interface Addresses {

    /**
     * Returns the address with alias addressAlias of the customer identified by customerEmail
     * @throws RuntimeException if either the customer or the address alias don't exist
     */
    Address getAddress(String customerEmail, String addressAlias);
}
