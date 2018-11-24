package trip.domainOfferAPI;

import java.time.Duration;

public interface Offer {

    String getId();

    Duration getDuration();

    double getPrice();
}
