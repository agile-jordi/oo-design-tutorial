package edu.uoc.adp.q2018p.orders.domain;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

public class PlaceOrder {

    private final Customers customers;
    private final Addresses addresses;
    private final Products products;
    private final Orders orders;

    private List<OrderLine> orderLines = new LinkedList<>();

    public PlaceOrder(Customers customers, Addresses addresses, Products products, Orders orders) {
        this.customers = customers;
        this.addresses = addresses;
        this.products = products;
        this.orders = orders;
    }

    public void identifyCustomer(String email) {
        Customer c = customers.getCustomer(email);
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void addProduct(String productName) {
        Product p = products.getProduct(productName);
        orderLines.add(new OrderLine(p, 1));
    }

    public void changeProductUnits(String productName, int newUnits){
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void selectDeliveryAddress(Address a){
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void selectDeliveryWindow(Instant deliverAfter, Instant deliverBefore){
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void confirmOrder(){
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
