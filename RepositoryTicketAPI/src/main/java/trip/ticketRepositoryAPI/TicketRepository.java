package trip.ticketRepositoryAPI;

import trip.ticketAPI.Ticket;

import java.util.List;

public interface TicketRepository {

    Ticket getById(String id);

    List<Ticket> getAllByOfferId(String offerId);

    void save(Ticket ticket);
}
