package trip.application2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import trip.domain.offer.DomainOfferService;
import trip.domain.offer.DomainOfferServiceImpl;
import trip.integration.sending.EmailSendingService;
import trip.factory.ticket.ExpensiveTicketFactory;
import trip.facade.offer.FacadeOfferService;
import trip.facade.offer.FacadeOfferServiceImpl;
import trip.facade.ticket.FacadeTicketService;
import trip.facade.ticket.FacadeTicketServiceImpl;
import trip.factory.offer.OfferFactory;
import trip.domain.offer.repository.OfferRepository;
import trip.domain.offer.repository.OfferRepositoryMongoImpl;
import trip.domain.offer.discount.PackageDiscount;
import trip.domain.offer.discount.SeniorPackageDiscount;
import trip.factory.offer.RoadFactory;
import trip.integration.sending.SendingService;
import trip.factory.ticket.TicketFactory;
import trip.domain.ticket.repository.TicketRepository;
import trip.domain.ticket.repository.TicketRepositoryMongoImpl;

@Configuration
public class AppConfig {

    @Bean
    public OfferFactory offerFactory() {
        return new RoadFactory();
    }

    @Bean
    public OfferRepository offerRepository() {
        return new OfferRepositoryMongoImpl();
    }

    @Bean
    public DomainOfferService domainOfferService(
            PackageDiscount packageDiscount,
            OfferRepository offerRepository,
            TicketRepository ticketRepository,
            SendingService sendingService) {
        return new DomainOfferServiceImpl(packageDiscount, offerRepository, ticketRepository, sendingService);
    }

    @Bean
    public PackageDiscount packageDiscount() {
        return new SeniorPackageDiscount();
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
        return new ExpensiveTicketFactory();
    }

    @Bean
    public SendingService sendingService(JavaMailSender mailSender) {
        return new EmailSendingService(mailSender);
    }

}
