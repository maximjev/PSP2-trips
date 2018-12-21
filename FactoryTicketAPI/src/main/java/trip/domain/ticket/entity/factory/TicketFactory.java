package trip.domain.ticket.entity.factory;


import trip.domain.ticket.entity.Ticket;

public interface TicketFactory {

    Ticket createTicket(String offerId);
}
