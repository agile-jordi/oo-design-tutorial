package edu.uoc.adp.q2018p.orders.domain;

public abstract class ProductCommand {
    abstract void execute(Product product);
    abstract void undo(Product product);
}
