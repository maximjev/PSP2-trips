package trip.offerRepositoryMongoDB;

import org.springframework.data.mongodb.repository.MongoRepository;
import trip.domainOfferAPI.Offer;
import trip.offerRepositoryAPI.OfferRepository;

public interface OfferRepositoryMongo extends MongoRepository<Offer, String> {
}
