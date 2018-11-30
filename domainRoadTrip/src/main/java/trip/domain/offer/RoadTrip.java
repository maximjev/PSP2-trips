package trip.domain.offer;


import java.time.LocalDateTime;

public class RoadTrip extends Trip {

    public RoadTrip(LocalDateTime from, LocalDateTime till, String destination, Offer.PackageType packageType) {
        super(from, till, destination, packageType);
    }

    @Override
    public double getAdditionalExpenses() {
        return 50;
    }
}
