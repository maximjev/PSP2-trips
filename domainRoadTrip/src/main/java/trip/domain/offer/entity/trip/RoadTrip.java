package trip.domain.offer.entity.trip;


import java.time.LocalDateTime;

public class RoadTrip extends Trip {

    public RoadTrip(LocalDateTime from, LocalDateTime till, String destination, PackageType packageType) {
        super(from, till, destination, packageType);
    }

    @Override
    public double getAdditionalExpenses() {
        return 50;
    }
}
