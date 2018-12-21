package trip.domain.ticket.entity.factory;

import trip.domain.ticket.entity.ExpensiveTicket;
import trip.domain.ticket.entity.Ticket;

public class ExpensiveTicketFactory implements TicketFactory {

    @Override
    public Ticket createTicket(String offerId) {
        return new ExpensiveTicket(offerId);
    }
}
