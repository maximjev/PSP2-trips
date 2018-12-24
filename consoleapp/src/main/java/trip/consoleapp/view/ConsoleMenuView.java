package trip.consoleapp.view;

import mvc.ConsoleModel;
import mvc.ConsoleView;

public class ConsoleMenuView implements ConsoleView {

    @Override
    public void render(ConsoleModel model) {
        System.out.println("To view menu, press enter");
        System.out.println("To get offer list, type 'offer list'");
        System.out.println("To get offer view, type 'get offer $id'");
        System.out.println("To get add an adventure, type 'add adventure $duration $location $packageType'");
        System.out.println("To get add a trip, type 'add trip $from $till $destination $packageType'");
        System.out.println("To get get offer price, type 'get price $offerId $count $packageType'");
        System.out.println("To get get tickets, type 'get tickets $offerId'");
        System.out.println("To get add tickets, type 'add $offerId $count'");
        System.out.println("To get buy tickets, type 'buy tickets $offerId $packageType $count $contact'");
    }
}
