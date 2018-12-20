package trip.domain.ticket.entity;

public class ExpensiveTicket extends Ticket {

    public ExpensiveTicket(String offerId) {
        super(offerId);
    }

    @Override
    public double getPrice() {
        return 10;
    }
}
