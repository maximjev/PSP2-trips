package trip.expensiveTicketFactory;

import trip.expensiveTicket.ExpensiveTicket;
import trip.ticketAPI.Ticket;
import trip.ticketFactoryAPI.TicketFactory;

public class ExpensiveTicketFactory implements TicketFactory {

    @Override
    public Ticket createTicket(String offerId) {
        return new ExpensiveTicket(offerId);
    }
}
