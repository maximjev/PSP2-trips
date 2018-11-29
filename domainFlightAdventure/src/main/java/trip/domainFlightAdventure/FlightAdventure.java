package trip.domainFlightAdventure;

import trip.domainAdventureAPI.Adventure;

import java.time.Duration;
import java.time.LocalDateTime;

public class FlightAdventure extends Adventure {

    public FlightAdventure(Duration duration, String location, PackageType packageType) {
        super(duration, location, packageType);
    }

    @Override
    public double getAdditionalExpenses() {
        return 10;
    }

}
