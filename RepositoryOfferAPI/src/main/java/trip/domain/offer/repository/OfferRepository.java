package trip.domain.offer.repository;


import trip.domain.offer.Offer;

import java.util.List;

public interface OfferRepository {
    Offer getById(String id);

    List<Offer> getAll();

    void save(Offer offer);
}
