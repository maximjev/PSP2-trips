package trip.consoleapp.view;

import mvc.ConsoleController;
import mvc.ConsoleModel;
import mvc.ConsoleView;
import trip.domain.offer.entity.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class ConsoleOfferListView implements ConsoleView {

    @Override
    public void render(ConsoleModel model) {
        List<Offer> offers = (ArrayList<Offer>) model.get("offerList");

        StringBuilder builder = new StringBuilder();
        offers.forEach(offer -> {
            builder.append("ID: ").append(offer.getId()).append("\n");
            builder.append("Package type: ").append(offer.getPackageType()).append("\n");
            builder.append("Available tickets: ").append(offer.getAvailableTickets()).append("\n");
            builder.append("Duration: ").append(offer.getDuration()).append("\n");
            builder.append("Additional expenses: ").append(offer.getAdditionalExpenses()).append("\n");
        });

        System.out.println(builder.toString());
    }
}
