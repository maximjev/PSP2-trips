package trip.domainTripAPI;

import trip.domainOfferAPI.Offer;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;

import static java.util.UUID.*;

public abstract class Trip implements Offer, Serializable {

    private String id;

    private LocalDate from;

    private LocalDate till;

    private String destination;

    private double price;

    public Trip(LocalDate from, LocalDate till, String destination, double price) {
        this.id = randomUUID().toString();
        this.from = from;
        this.till = till;
        this.destination = destination;
        this.price = price;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Duration getDuration() {
        return Duration.between(from, till);
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTill() {
        return till;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public abstract double getTransportExpenses();
}
