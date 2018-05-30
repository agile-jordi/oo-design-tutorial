package edu.uoc.adp.q2018p.orders.domain;

public interface Money {
    static Money zero = Money.fromCents(0);
    static Money unknown = new UnkownMoney();
    static Money fromCents(int cents){
        return new MoneyInCents(cents);
    }
    Money sum(Money b);
    Money times(int units);
}

