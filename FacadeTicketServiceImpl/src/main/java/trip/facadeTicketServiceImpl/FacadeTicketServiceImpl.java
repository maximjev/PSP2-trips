package trip.facadeTicketServiceImpl;

import trip.domainOfferAPI.Offer;
import trip.domainServiceOffer.DomainOfferService;
import trip.facadeTicketServiceAPI.FacadeTicketService;
import trip.ticketAPI.Ticket;
import trip.ticketFactoryAPI.TicketFactory;
import trip.ticketRepositoryAPI.TicketRepository;

import java.util.List;

public class FacadeTicketServiceImpl implements FacadeTicketService {

    private TicketRepository ticketRepository;

    private TicketFactory ticketFactory;

    private DomainOfferService offerService;

    public FacadeTicketServiceImpl(TicketRepository ticketRepository,
                                   TicketFactory ticketFactory,
                                   DomainOfferService offerService) {
        this.offerService = offerService;
        this.ticketRepository = ticketRepository;
        this.ticketFactory = ticketFactory;
    }

    @Override
    public Ticket getById(String id) {
        return ticketRepository.getById(id);
    }

    @Override
    public List<Ticket> getAllByOfferId(String offerId) {
        return ticketRepository.getAllByOfferId(offerId);
    }

    @Override
    public void save(String offerId, int count) {
        for (int i = 0; i < count; i++) {
            offerService.addTickets(offerId, count);
            ticketRepository.save(ticketFactory.createTicket(offerId));
        }
    }

    @Override
    public void buy(String offerId, String packageType, int count, String contact) {
        offerService.buy(offerId, count, Offer.PackageType.valueOf(packageType), contact);
    }
}
