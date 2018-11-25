package trip.offerFactory;


import trip.domainOfferAPI.Offer;

import java.time.Duration;
import java.time.LocalDateTime;

public interface OfferFactory {

    Offer getOffer(LocalDateTime from, LocalDateTime till, String destination, String packageType);

    Offer getOffer(Duration duration, String location, String packageType);
}