package edu.uoc.adp.q2018p.orders.domain;

import java.time.Instant;
import java.util.List;

public class OrderLine {

    private final Product product;
    private int units;
    private boolean cancellationRequested;

    OrderLine(Product product, int units) {
        this.product = product;
        this.units = units;
    }

    public Money getPrice(Instant orderCreationInstant) {
        Money productPrice = product.getPrice(orderCreationInstant);
        if(productPrice == null) return null;
        return productPrice.times(units);
    }

    boolean isForProduct(String productName) {
        return product.getName().equals(productName);
    }

    boolean isForProductIn(List<String> productNames) {
        return productNames.contains(product.getName());
    }

    void addOne() {
        this.units += 1;
    }

    void setAmount(int newUnits) {
        this.units = newUnits;
    }

    void setCancellationRequested() {
        this.cancellationRequested = true;
    }
}
