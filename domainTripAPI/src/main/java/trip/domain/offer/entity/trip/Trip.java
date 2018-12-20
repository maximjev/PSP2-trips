package trip.domain.offer.entity.trip;


import trip.domain.offer.entity.Offer;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

import static java.util.UUID.*;

public abstract class Trip implements Offer, Serializable {

    private String id;

    private LocalDateTime from;

    private LocalDateTime till;

    private String destination;

    private PackageType packageType;

    private int availableTickets;

    public Trip(LocalDateTime from, LocalDateTime till, String destination, PackageType packageType) {
        this.id = randomUUID().toString();
        this.from = from;
        this.till = till;
        this.destination = destination;
        this.packageType = packageType;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDuration() {
        return Long.toString(Duration.between(from, till).toDays());
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTill() {
        return till;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public PackageType getPackageType() {
        return packageType;
    }

    @Override
    public int getAvailableTickets() {
        return availableTickets;
    }

    @Override
    public void addAvailableTickets(int count) {
        availableTickets += count;
    }

    @Override
    public void buyTickets(int count) {
        availableTickets -= count;
    }
}
