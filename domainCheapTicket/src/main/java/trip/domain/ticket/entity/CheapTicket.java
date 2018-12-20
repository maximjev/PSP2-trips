package trip.domain.ticket.entity;

public class CheapTicket extends Ticket {

    public CheapTicket(String offerId) {
        super(offerId);
    }

    @Override
    public double getPrice() {
        return 5;
    }
}
