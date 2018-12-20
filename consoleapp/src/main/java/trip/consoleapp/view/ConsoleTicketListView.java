package trip.consoleapp.view;

import mvc.ConsoleModel;
import mvc.ConsoleView;
import trip.domain.offer.entity.Offer;
import trip.domain.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("unchecked")
public class ConsoleTicketListView implements ConsoleView {

    @Override
    public void render(ConsoleModel model) {
        Offer offer = (Offer) model.get("offer");
        List<Ticket> tickets = (ArrayList<Ticket>) model.get("tickets");

        StringBuilder builder = new StringBuilder();

        builder.append("ID: ").append(offer.getId()).append("\n")
                .append("Package type: ").append(offer.getPackageType()).append("\n")
                .append("Available tickets: ").append(offer.getAvailableTickets()).append("\n")
                .append("Duration: ").append(offer.getDuration()).append("\n")
                .append("Additional expenses: ").append(offer.getAdditionalExpenses()).append("\n");

        tickets.forEach(ticket -> {
            builder.append("ID: ").append(ticket.getId()).append("\n");
            builder.append("Price: ").append(ticket.getPrice()).append("\n");
            builder.append("Code: ").append(ticket.getTicketCode()).append("\n");
        });

        System.out.println(builder.toString());
    }
}
