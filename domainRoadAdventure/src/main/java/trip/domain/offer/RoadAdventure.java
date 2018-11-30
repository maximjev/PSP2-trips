package trip.domain.offer;

import java.time.Duration;

public class RoadAdventure extends Adventure {

    public RoadAdventure(Duration duration, String location, PackageType packageType) {
        super(duration, location, packageType);
    }

    @Override
    public double getAdditionalExpenses() {
        return 5;
    }
}
