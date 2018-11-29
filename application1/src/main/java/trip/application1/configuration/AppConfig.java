package trip.application1.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import trip.cheapTicketFactory.CheapTicketFactory;
import trip.domainServiceOffer.DomainOfferService;
import trip.domainServiceOfferImpl.DomainOfferServiceImpl;
import trip.facadeOfferServiceAPI.FacadeOfferService;
import trip.facadeOfferServiceImpl.FacadeOfferServiceImpl;
import trip.facadeTicketServiceAPI.FacadeTicketService;
import trip.facadeTicketServiceImpl.FacadeTicketServiceImpl;
import trip.familyPackageDiscount.FamilyPackageDiscount;
import trip.flight.factory.FlightFactory;
import trip.offerFactory.OfferFactory;
import trip.offerRepositoryAPI.OfferRepository;
import trip.offerRepositoryMongoDB.OfferRepositoryMongo;
import trip.offerRepositoryMongoDB.OfferRepositoryMongoImpl;
import trip.packageDiscountAPI.PackageDiscount;
import trip.sendingServiceAPI.SendingService;
import trip.smsSendingService.SMSSendingService;
import trip.ticketFactoryAPI.TicketFactory;
import trip.ticketRepositoryAPI.TicketRepository;
import trip.ticketRepositoryMongoDB.TicketRepositoryMongo;
import trip.ticketRepositoryMongoDB.TicketRepositoryMongoImpl;

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
    public DomainOfferService domainOfferService(PackageDiscount packageDiscount,
                                                 OfferRepository offerRepository,
                                                 TicketRepository ticketRepository,
                                                 SendingService sendingService) {
        return new DomainOfferServiceImpl(packageDiscount, offerRepository, ticketRepository, sendingService);
    }

    @Bean
    public PackageDiscount packageDiscount() {
        return new FamilyPackageDiscount();
    }

    @Bean
    public FacadeOfferService facadeOfferService(
            OfferRepository offerRepository,
            OfferFactory offerFactory,
            DomainOfferService offerService) {
        return new FacadeOfferServiceImpl(offerRepository, offerFactory, offerService);
    }

    @Bean
    public FacadeTicketService facadeTicketService(
            TicketRepository ticketRepository,
            TicketFactory ticketFactory,
            DomainOfferService offerService) {
        return new FacadeTicketServiceImpl(ticketRepository, ticketFactory, offerService);
    }

    @Bean
    public TicketRepository ticketRepository() {
        return new TicketRepositoryMongoImpl();
    }

    @Bean
    public TicketFactory ticketFactory() {
        return new CheapTicketFactory();
    }

    @Bean
    public SendingService sendingService() {
        return new SMSSendingService();
    }
}
