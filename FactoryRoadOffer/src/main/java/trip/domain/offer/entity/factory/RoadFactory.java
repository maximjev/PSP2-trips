package trip.domain.offer.entity.factory;


import trip.domain.offer.entity.Offer;
import trip.domain.offer.entity.adventure.RoadAdventure;
import trip.domain.offer.entity.trip.RoadTrip;

import java.time.Duration;
import java.time.LocalDateTime;

public class RoadFactory implements OfferFactory {

    @Override
    public Offer getOffer(LocalDateTime from, LocalDateTime till, String destination, String packageType) {
        return new RoadTrip(from, till, destination, Offer.PackageType.valueOf(packageType));
    }

    @Override
    public Offer getOffer(Duration duration, String location, String packageType) {
        return new RoadAdventure(duration, location, Offer.PackageType.valueOf(packageType));
    }
}
