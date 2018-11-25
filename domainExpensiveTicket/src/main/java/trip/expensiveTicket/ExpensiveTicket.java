package trip.expensiveTicket;

import trip.ticketAPI.Ticket;

public class ExpensiveTicket extends Ticket {

    public ExpensiveTicket(String offerId) {
        super(offerId);
    }

    @Override
    public double getPrice() {
        return 10;
    }
}
