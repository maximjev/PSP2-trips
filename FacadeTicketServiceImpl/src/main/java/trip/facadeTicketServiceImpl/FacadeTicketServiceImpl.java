package trip.facadeTicketServiceImpl;

import trip.facadeTicketServiceAPI.FacadeTicketService;
import trip.ticketAPI.Ticket;
import trip.ticketFactoryAPI.TicketFactory;
import trip.ticketRepositoryAPI.TicketRepository;

import java.util.List;

public class FacadeTicketServiceImpl implements FacadeTicketService {

    private TicketRepository ticketRepository;

    private TicketFactory ticketFactory;

    public FacadeTicketServiceImpl(TicketRepository ticketRepository, TicketFactory ticketFactory) {
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
    public void save(String offerId) {
        ticketRepository.save(ticketFactory.createTicket(offerId));
    }
}
