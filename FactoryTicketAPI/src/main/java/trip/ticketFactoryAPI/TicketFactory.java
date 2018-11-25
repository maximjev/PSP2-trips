package trip.ticketFactoryAPI;

import trip.ticketAPI.Ticket;

public interface TicketFactory {

    Ticket createTicket(String offerId);
}
