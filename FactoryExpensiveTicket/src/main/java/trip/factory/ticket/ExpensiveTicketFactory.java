package trip.factory.ticket;

import trip.domain.ticket.ExpensiveTicket;
import trip.domain.ticket.Ticket;

public class ExpensiveTicketFactory implements TicketFactory {

    @Override
    public Ticket createTicket(String offerId) {
        return new ExpensiveTicket(offerId);
    }
}
