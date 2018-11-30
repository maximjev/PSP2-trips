package trip.domain.offer;

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
