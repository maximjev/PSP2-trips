package trip.repository.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import trip.domain.offer.entity.Offer;
import trip.domain.offer.repository.OfferRepository;

import java.util.List;

public class OfferRepositoryMongoImpl implements OfferRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Offer getById(String id) {
        return mongoTemplate.findById(id, Offer.class, "offers");
    }

    @Override
    public List<Offer> getAll() {
        return mongoTemplate.findAll(Offer.class, "offers");
    }

    @Override
    public void save(Offer offer) {
        mongoTemplate.save(offer, "offers");
    }
}
