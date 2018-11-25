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

    public Adventure(Duration duration, String location, PackageType packageType) {
        this.id = UUID.randomUUID().toString();
        this.location = location;
        this.duration = duration;
        this.packageType = packageType;
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
}
