package trip.consoleapp.view;

import mvc.ConsoleModel;
import mvc.ConsoleView;

public class ConsoleOfferPriceView implements ConsoleView {

    @Override
    public void render(ConsoleModel model) {
        Double price = (Double) model.get("price");

        System.out.println("The price is: " + price);
    }
}
