package trip.consoleapp.view;

import mvc.ConsoleModel;
import mvc.ConsoleView;
import trip.domain.offer.entity.Offer;
import trip.domain.offer.entity.adventure.Adventure;

public class ConsoleOfferView implements ConsoleView {

    @Override
    public void render(ConsoleModel model) {
        Offer offer = (Offer) model.get("offer");

        StringBuilder builder = new StringBuilder();

        builder.append("ID: ").append(offer.getId()).append("\n")
                .append("Package type: ").append(offer.getPackageType()).append("\n")
                .append("Available tickets: ").append(offer.getAvailableTickets()).append("\n")
                .append("Duration: ").append(offer.getDuration()).append("\n")
                .append("Additional expenses: ").append(offer.getAdditionalExpenses()).append("\n");

        System.out.println(builder.toString());
    }
}
