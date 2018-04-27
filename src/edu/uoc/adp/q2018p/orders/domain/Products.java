package edu.uoc.adp.q2018p.orders.domain;

public interface Products {

    /**
     * Returns the product identified by name
     * @throws RuntimeException if the product does not exist
     **/
    Product getProduct(String name);
}
