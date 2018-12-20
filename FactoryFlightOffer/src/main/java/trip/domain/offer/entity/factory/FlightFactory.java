package trip.domain.offer.entity.factory;


import trip.domain.offer.entity.adventure.FlightAdventure;
import trip.domain.offer.entity.trip.FlightTrip;
import trip.domain.offer.entity.Offer;

import java.time.Duration;
import java.time.LocalDateTime;

public class FlightFactory implements OfferFactory {

    @Override
    public Offer getOffer(LocalDateTime from, LocalDateTime till, String destination, String packageType) {
        return new FlightTrip(from, till, destination, Offer.PackageType.valueOf(packageType));
    }

    @Override
    public Offer getOffer(Duration duration, String location, String packageType) {
        return new FlightAdventure(duration, location, Offer.PackageType.valueOf(packageType));
    }
}

