package trip.application1.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import trip.domainServiceOffer.DomainOfferService;
import trip.domainServiceOfferImpl.DomainOfferServiceImpl;
import trip.facadeOfferServiceAPI.FacadeOfferService;
import trip.facadeOfferServiceImpl.FacadeOfferServiceImpl;
import trip.familyPackageDiscount.FamilyPackageDiscount;
import trip.flight.factory.FlightFactory;
import trip.offerFactory.OfferFactory;
import trip.offerRepositoryAPI.OfferRepository;
import trip.offerRepositoryMongoDB.OfferRepositoryMongo;
import trip.offerRepositoryMongoDB.OfferRepositoryMongoImpl;
import trip.packageDiscountAPI.PackageDiscount;

@Configuration
public class AppConfig {

    @Bean
    public OfferFactory offerFactory() {
        return new FlightFactory();
    }

    @Bean
    public OfferRepository offerRepository() {
        return new OfferRepositoryMongoImpl();
    }

    @Bean
    public DomainOfferService domainOfferService(PackageDiscount packageDiscount) {
        return new DomainOfferServiceImpl(packageDiscount);
    }

    @Bean
    public PackageDiscount packageDiscount() {
        return new FamilyPackageDiscount();
    }

    @Bean
    public FacadeOfferService facadeOfferService(OfferRepository offerRepository, OfferFactory offerFactory) {
        return new FacadeOfferServiceImpl(offerRepository, offerFactory);
    }

}
