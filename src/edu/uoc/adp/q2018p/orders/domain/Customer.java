package edu.uoc.adp.q2018p.orders.domain;

import java.util.List;

public class Customer {

    private String email;
    private final List<Address> addresses;

    public Customer(String email, List<Address> addresses) {
        this.email = email;
        this.addresses = addresses;
    }
}
