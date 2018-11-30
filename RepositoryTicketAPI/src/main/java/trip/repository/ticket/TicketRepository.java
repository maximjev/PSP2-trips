package trip.repository.ticket;


import trip.domain.ticket.Ticket;

import java.util.List;

public interface TicketRepository {

    Ticket getById(String id);

    List<Ticket> getAllByOfferId(String offerId);

    void save(Ticket ticket);
}
