package trip.domainFlightTrip;

import trip.domainTripAPI.Trip;

import java.time.LocalDate;

public class FlightTrip extends Trip {

    public FlightTrip(LocalDate from, LocalDate till, String destination, double price) {
        super(from, till, destination, price);
    }

    @Override
    public double getTransportExpenses() {
        return 120;
    }
}
