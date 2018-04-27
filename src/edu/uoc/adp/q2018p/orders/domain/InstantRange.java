package edu.uoc.adp.q2018p.orders.domain;

import java.time.Instant;

public class InstantRange {
    private final Instant since;
    private final Instant until;

    public InstantRange(Instant since, Instant until) {
        this.since = since;
        this.until = until;
    }

    public boolean includes(Instant i){
        return this.since.isBefore(i) && this.until.isAfter(i);
    }
}
