package trip.offerRepositoryMongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import trip.domainOfferAPI.Offer;
import trip.offerRepositoryAPI.OfferRepository;

import java.util.List;

public class OfferRepositoryMongoImpl implements OfferRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Offer getById(String id) {
        return mongoTemplate.findById(id, Offer.class);
    }

    @Override
    public List<Offer> getAll() {
        return mongoTemplate.findAll(Offer.class);
    }

    @Override
    public void save(Offer offer) {
        mongoTemplate.save(offer, "offers");
    }
}
