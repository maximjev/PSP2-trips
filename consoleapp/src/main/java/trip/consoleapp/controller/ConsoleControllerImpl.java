package trip.consoleapp.controller;

import mvc.ConsoleController;
import mvc.ConsoleModel;
import trip.domain.offer.entity.Offer;
import trip.facade.offer.FacadeOfferService;
import trip.facade.ticket.FacadeTicketService;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ConsoleControllerImpl implements ConsoleController {

    private FacadeOfferService offerService;

    private FacadeTicketService ticketService;

    private ConsoleModel model;

    public ConsoleControllerImpl(
            FacadeOfferService offerService,
            FacadeTicketService ticketService,
            ConsoleModel model) {
        this.ticketService = ticketService;
        this.offerService = offerService;
        this.model = model;
    }

    @Override
    public String execute(String command) {
        if (command.equals("offer list")) {
            model.put("offers", offerService.getAll());
            return "offerList";
        }

        if (command.startsWith("get offer")) {
            model.put("offer", resolveOffer(command));
            return "offerView";
        }

        if (command.startsWith("add adventure")) {
            addAdventure(command);
            return "offerList";
        }

        if (command.startsWith("add trip")) {
            addTrip(command);
            return "offerList";
        }

        if (command.startsWith("get price")) {
            model.put("offerPrice", getPrice(command));
            return "offerPrice";
        }

        if (command.startsWith("get tickets")) {
            Offer offer = resolveOffer(command);
            if (offer == null) {
                return "offerList";
            }
            model.put("offer", offer);
            model.put("tickets", ticketService.getAllByOfferId(offer.getId()));
            return "ticketList";
        }

        if(command.startsWith("add tickets")) {
            addTickets(command);
            return "offerList";
        }

        if(command.startsWith("buy tickets")) {
            buyTickets(command);
            return "offerList";
        }

        if(command.equals("exit")) {
            return "exit";
        }

        return "menu";
    }

    private Offer resolveOffer(String command) {
        String[] words = command.split(" ");
        if (words.length != 3) {
            return null;
        }
        String offerId = words[2];
        return offerService.getById(offerId);
    }

    private void addAdventure(String command) {
        String[] words = command.split(" ");
        if (words.length != 5) {
            return;
        }
        Duration duration = Duration.ofDays(Integer.parseInt(words[2]));
        String location = words[3];
        String packageType = words[4];

        offerService.createOffer(duration, location, packageType);
    }

    private void addTrip(String command) {
        String[] words = command.split(" ");
        if (words.length != 6) {
            return;
        }
        LocalDateTime from = LocalDate.parse(words[2]).atStartOfDay();
        LocalDateTime till = LocalDate.parse(words[3]).atStartOfDay();
        String destination = words[4];
        String packageType = words[5];

        offerService.createOffer(from, till, destination, packageType);
    }

    private Double getPrice(String command) {
        String[] words = command.split(" ");
        if (words.length != 5) {
            return null;
        }

        String offerId = words[2];
        int count = Integer.parseInt(words[3]);
        String packageType = words[4];

        return offerService.getPrice(offerId, count, packageType);
    }

    private void addTickets(String command) {
        String[] words = command.split(" ");
        if (words.length != 4) {
            return;
        }

        String offerId = words[2];
        int count = Integer.parseInt(words[3]);
        ticketService.save(offerId, count);
    }

    private void buyTickets(String command) {
        String[] words = command.split(" ");
        if (words.length != 6) {
            return;
        }

        String offerId = words[2];
        String packageType = words[3];
        int count = Integer.parseInt(words[4]);
        String contact = words[5];
        ticketService.buy(offerId, packageType, count, contact);
    }
}
