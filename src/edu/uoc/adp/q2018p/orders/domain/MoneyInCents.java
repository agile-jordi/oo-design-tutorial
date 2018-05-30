package edu.uoc.adp.q2018p.orders.domain;

public class MoneyInCents implements Money{

    private final int cents;

    MoneyInCents(int cents) {
        this.cents = cents;
    }

    @Override
    public Money sum(Money b) {
        if(b instanceof MoneyInCents){
            return Money.fromCents(this.cents + ((MoneyInCents)b).cents);
        }
    }

    @Override
    public Money times(int units) {
        return Money.fromCents(this.cents * units);
    }
}
