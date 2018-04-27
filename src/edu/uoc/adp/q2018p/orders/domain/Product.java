package edu.uoc.adp.q2018p.orders.domain;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

public class Product {

    private String name;
    /** List of historical prices, newer prices go first */
    private final List<ProductPrice> prices;

    public Product(String name) {
        this.name = name;
        this.prices = new LinkedList<>();
    }

    public Money getPrice(Instant at) {
        for(ProductPrice p : prices){
            if(p.getSince().isBefore(at)){
                return p.getPrice();
            }
        }
        return null;
    }

}
