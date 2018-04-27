package edu.uoc.adp.q2018p.orders.domain;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

public class Product {

    private String name;
    /** List of historical prices, newer prices go first */
    private final List<ProductPrice> prices;
    private final List<ProductCommand> commands;

    public Product(String name) {
        this.name = name;
        this.prices = new LinkedList<>();
        this.commands = new LinkedList<>();
    }

    Money getPrice(Instant at) {
        for(ProductPrice p : prices){
            if(p.getSince().isBefore(at)){
                return p.getPrice();
            }
        }
        return null;
    }

    String getName() {
        return name;
    }

    public List<ProductCommand> getCommands() {
        return commands;
    }

    void changeName(String userEmail, Instant at, String newName){
        this.execute(new ChangeNameProductCommand(this, userEmail, at, newName));
    }

    void execute(ProductCommand cmd){
        cmd.execute(this);
        commands.add(cmd);
    }

    void setName(String newName) {
        this.name = newName;
    }

    void undoLastChange(){
        ProductCommand cmd = commands.remove(commands.size() - 1);
        cmd.undo(this);
    }

}
