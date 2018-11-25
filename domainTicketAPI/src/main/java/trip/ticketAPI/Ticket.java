package trip.ticketAPI;

import java.io.Serializable;
import java.util.UUID;

public abstract class Ticket implements Serializable {

    private String id;

    private String offerId;

    public Ticket(String offerId) {
        this.offerId = offerId;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getOfferId() {
        return offerId;
    }

    public abstract double getPrice();
}
