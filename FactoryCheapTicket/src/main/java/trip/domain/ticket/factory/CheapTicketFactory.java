package trip.domain.ticket.factory;

import trip.domain.ticket.CheapTicket;
import trip.domain.ticket.Ticket;

public class CheapTicketFactory implements TicketFactory {

    @Override
    public Ticket createTicket(String offerId) {
        return new CheapTicket(offerId);
    }
}
