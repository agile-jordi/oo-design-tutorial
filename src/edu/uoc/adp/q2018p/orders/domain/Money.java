package edu.uoc.adp.q2018p.orders.domain;

public class Money {

    private final int cents;

    private Money(int cents) {
        this.cents = cents;
    }

    public static Money zero = Money.fromCents(0);

    public static Money fromCents(int cents){
        return new Money(cents);
    }

    public Money sum(Money b) {
        return fromCents(this.cents + b.cents);
    }

    public Money times(int units) {
        return fromCents(this.cents * units);
    }
}
