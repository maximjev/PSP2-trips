package trip.domainAdventureAPI;

import trip.domainOfferAPI.Offer;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Adventure implements Offer, Serializable {

    private String id;

    private String location;

    private Duration duration;

    private PackageType packageType;

    private int availableTickets;

    public Adventure(Duration duration, String location, PackageType packageType) {
        this.id = UUID.randomUUID().toString();
        this.location = location;
        this.duration = duration;
        this.packageType = packageType;
        this.availableTickets = 0;

    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Duration getDuration() {
        return duration;
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
