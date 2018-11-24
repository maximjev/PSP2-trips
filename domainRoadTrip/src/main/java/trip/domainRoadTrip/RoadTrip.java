package trip.domainRoadTrip;

import trip.domainTripAPI.Trip;

import java.time.LocalDate;

public class RoadTrip extends Trip {

    public RoadTrip(LocalDate from, LocalDate till, String destination, double price) {
        super(from, till, destination, price);
    }

    @Override
    public double getTransportExpenses() {
        return 60;
    }
}
