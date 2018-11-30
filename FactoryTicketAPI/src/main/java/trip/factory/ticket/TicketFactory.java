package trip.factory.ticket;


import trip.domain.ticket.Ticket;

public interface TicketFactory {

    Ticket createTicket(String offerId);
}
