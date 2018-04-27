package edu.uoc.adp.q2018p.orders.domain;

public class Address {
    private final String alias;
    private final String address;
    private final String city;
    private final String postalCode;

    public Address(String alias, String address, String city, String postalCode) {
        this.alias = alias;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
    }
}
