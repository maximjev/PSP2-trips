package trip.ticketRepositoryMongoDB;

import org.springframework.data.mongodb.repository.MongoRepository;
import trip.ticketAPI.Ticket;

public interface TicketRepositoryMongo extends MongoRepository<Ticket, String> {
}
