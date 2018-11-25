package trip.domainRoadAdventure;

import trip.domainAdventureAPI.Adventure;

import java.time.Duration;
import java.time.LocalDateTime;

public class RoadAdventure extends Adventure {

    public RoadAdventure(Duration duration, String location, PackageType packageType) {
        super(duration, location, packageType);
    }

    @Override
    public double getBasePrice() {
        return 15;
    }

    @Override
    public double getAdditionalExpenses() {
        return 5;
    }
}
