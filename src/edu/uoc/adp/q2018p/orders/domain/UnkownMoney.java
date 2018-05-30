package edu.uoc.adp.q2018p.orders.domain;

public class UnkownMoney implements Money{

    @Override
    public Money sum(Money b) {
        return this;
    }

    @Override
    public Money times(int units) {
        return this;
    }
}
