package trip.domain.flightTrip;

import trip.domainTripAPI.Trip;

import java.time.LocalDateTime;

public class FlightTrip extends Trip {

    public FlightTrip(LocalDateTime from, LocalDateTime till, String destination, PackageType packageType) {
        super(from, till, destination, packageType);
    }

    @Override
    public double getBasePrice() {
        return 400;
    }

    @Override
    public double getAdditionalExpenses() {
        return 100;
    }
}

