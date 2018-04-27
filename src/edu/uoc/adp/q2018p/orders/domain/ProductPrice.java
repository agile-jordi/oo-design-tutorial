package edu.uoc.adp.q2018p.orders.domain;

import java.time.Instant;

public class ProductPrice {

    private final Instant since;
    private final Money price;

    public ProductPrice(Instant since, Money price) {
        this.since = since;
        this.price = price;
    }

    public Instant getSince() {
        return since;
    }

    public Money getPrice() {
        return price;
    }
}
