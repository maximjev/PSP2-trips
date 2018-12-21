package trip.application2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import trip.domain.offer.service.DomainOfferService;
import trip.domain.offer.service.DomainOfferServiceImpl;
import trip.domain.offer.service.DomainOfferServiceNoDiscountImpl;
import trip.integration.sending.EmailSendingService;
import trip.domain.ticket.entity.factory.ExpensiveTicketFactory;
import trip.facade.offer.FacadeOfferService;
import trip.facade.offer.FacadeOfferServiceImpl;
import trip.facade.ticket.FacadeTicketService;
import trip.facade.ticket.FacadeTicketServiceImpl;
import trip.domain.offer.entity.factory.OfferFactory;
import trip.domain.offer.repository.OfferRepository;
import trip.integration.sending.SMSSendingService;
import trip.repository.offer.OfferRepositoryMongoImpl;
import trip.domain.offer.discount.PackageDiscount;
import trip.domain.offer.discount.SeniorPackageDiscount;
import trip.domain.offer.entity.factory.RoadFactory;
import trip.domain.integration.sending.SendingService;
import trip.domain.ticket.entity.factory.TicketFactory;
import trip.domain.ticket.repository.TicketRepository;
import trip.repository.ticket.TicketRepositoryMongoImpl;

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

    // 2 ir 3 reikalavimai
    @Bean
    public DomainOfferService domainOfferService(
            PackageDiscount packageDiscount,
            OfferRepository offerRepository,
            TicketRepository ticketRepository,
            SendingService smsSendingService) {
        return new DomainOfferServiceImpl(packageDiscount, offerRepository, ticketRepository, smsSendingService);
    }

    @Bean
    public DomainOfferService domainOfferServiceNoDiscount(
            OfferRepository offerRepository,
            TicketRepository ticketRepository,
            SendingService mailSendingService) {
        return new DomainOfferServiceNoDiscountImpl(offerRepository, ticketRepository, mailSendingService);
    }

    @Bean
    public SendingService mailSendingService(JavaMailSender mailSender) {
        return new EmailSendingService(mailSender);
    }

    @Bean
    public SendingService smsSendingService() {
        return new SMSSendingService();
    }

    @Bean
    public PackageDiscount packageDiscount() {
        return new SeniorPackageDiscount();
    }

    @Bean
    public FacadeOfferService facadeOfferService(
            OfferRepository offerRepository,
            OfferFactory offerFactory,
            DomainOfferService domainOfferService) {
        return new FacadeOfferServiceImpl(offerRepository, offerFactory, domainOfferService);
    }

    @Bean
    public FacadeTicketService facadeTicketService(
            TicketRepository ticketRepository,
            TicketFactory ticketFactory,
            DomainOfferService domainOfferServiceNoDiscount) {
        return new FacadeTicketServiceImpl(ticketRepository, ticketFactory, domainOfferServiceNoDiscount);
    }

    @Bean
    public TicketRepository ticketRepository() {
        return new TicketRepositoryMongoImpl();
    }

    @Bean
    public TicketFactory ticketFactory() {
        return new ExpensiveTicketFactory();
    }
}
