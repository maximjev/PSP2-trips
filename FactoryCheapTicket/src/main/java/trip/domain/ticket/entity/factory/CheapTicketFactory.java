package trip.domain.ticket.entity.factory;

import trip.domain.ticket.entity.CheapTicket;
import trip.domain.ticket.entity.Ticket;

public class CheapTicketFactory implements TicketFactory {

    @Override
    public Ticket createTicket(String offerId) {
        return new CheapTicket(offerId);
    }
}
