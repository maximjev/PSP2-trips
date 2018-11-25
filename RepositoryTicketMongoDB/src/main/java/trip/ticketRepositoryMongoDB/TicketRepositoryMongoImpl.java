package trip.ticketRepositoryMongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import trip.ticketAPI.Ticket;
import trip.ticketRepositoryAPI.TicketRepository;

import java.util.List;

public class TicketRepositoryMongoImpl implements TicketRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Ticket getById(String id) {
        return mongoTemplate.findById(id, Ticket.class);
    }

    @Override
    public List<Ticket> getAllByOfferId(String offerId) {
        return mongoTemplate.find(new Query(Criteria.where("offerId").is(offerId)), Ticket.class);
    }

    @Override
    public void save(Ticket ticket) {
        mongoTemplate.save(ticket, "tickets");
    }
}
