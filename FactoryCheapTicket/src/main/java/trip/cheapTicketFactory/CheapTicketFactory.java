package trip.cheapTicketFactory;

import trip.cheapTicket.CheapTicket;
import trip.ticketAPI.Ticket;
import trip.ticketFactoryAPI.TicketFactory;

public class CheapTicketFactory implements TicketFactory {

    @Override
    public Ticket createTicket(String offerId) {
        return new CheapTicket(offerId);
    }
}
