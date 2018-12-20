package trip.domain.offer.entity.adventure;

import java.time.Duration;

public class FlightAdventure extends Adventure {

    public FlightAdventure(Duration duration, String location, PackageType packageType) {
        super(duration, location, packageType);
    }

    @Override
    public double getAdditionalExpenses() {
        return 10;
    }

}
