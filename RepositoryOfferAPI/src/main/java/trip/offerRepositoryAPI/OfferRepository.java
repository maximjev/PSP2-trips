package trip.offerRepositoryAPI;

import trip.domainOfferAPI.Offer;

import java.util.List;

public interface OfferRepository {
    Offer getById(String id);

    List<Offer> getAll();

    void save(Offer offer);
}
