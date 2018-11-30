package trip.factory.offer;


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
