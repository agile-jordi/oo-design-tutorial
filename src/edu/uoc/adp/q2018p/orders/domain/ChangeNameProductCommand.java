package edu.uoc.adp.q2018p.orders.domain;

import java.time.Instant;

public class ChangeNameProductCommand extends ProductCommand {
    private final String userEmail;
    private final Instant at;
    private final String newName;
    private final String oldName;

    public ChangeNameProductCommand(Product currentProduct, String userEmail, Instant at, String newName) {
        this.userEmail = userEmail;
        this.at = at;
        this.newName = newName;
        this.oldName = currentProduct.getName();
    }

    @Override
    void execute(Product product) {
        product.setName(newName);
    }

    @Override
    void undo(Product product) {
        product.setName(oldName);
    }
}
