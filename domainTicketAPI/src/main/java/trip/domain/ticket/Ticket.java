package trip.domain.ticket;

import java.io.Serializable;
import java.util.UUID;

public abstract class Ticket implements Serializable {

    private String id;

    private String offerId;

    private String ticketCode;

    private boolean isAvailable;

    public Ticket(String offerId) {
        this.offerId = offerId;
        this.id = UUID.randomUUID().toString();
        this.isAvailable = true;
        this.ticketCode = Double.toString(Math.random() * 1000000);
    }

    public String getId() {
        return id;
    }

    public String getOfferId() {
        return offerId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public abstract double getPrice();
}
