package trip.facadeOfferServiceAPI;

import trip.domainOfferAPI.Offer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public interface FacadeOfferService {

    Offer getById(String id);

    List<Offer> getAll();

    void createOffer(LocalDateTime from, LocalDateTime till, String destination, String packageType);

    void createOffer(Duration duration, String location, String packageType);
}
