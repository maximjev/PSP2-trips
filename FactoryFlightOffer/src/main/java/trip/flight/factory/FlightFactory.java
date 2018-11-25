package trip.flight.factory;

import trip.domain.flightTrip.FlightTrip;
import trip.domainFlightAdventure.FlightAdventure;
import trip.domainOfferAPI.Offer;
import trip.offerFactory.OfferFactory;

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

