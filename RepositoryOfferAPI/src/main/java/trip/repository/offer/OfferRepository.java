package trip.repository.offer;


import trip.domain.offer.Offer;

import java.util.List;

public interface OfferRepository {
    Offer getById(String id);

    List<Offer> getAll();

    void save(Offer offer);
}
