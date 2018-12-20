package trip.domain.offer.entity.trip;


import trip.domain.offer.entity.Offer;

import java.time.LocalDateTime;

public class FlightTrip extends Trip {

    public FlightTrip(LocalDateTime from, LocalDateTime till, String destination, Offer.PackageType packageType) {
        super(from, till, destination, packageType);
    }

    @Override
    public double getAdditionalExpenses() {
        return 100;
    }
}

