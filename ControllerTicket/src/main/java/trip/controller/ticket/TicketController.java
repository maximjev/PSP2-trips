package trip.controller.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import trip.facade.offer.FacadeOfferService;
import trip.facade.ticket.FacadeTicketService;

@Controller
public class TicketController {

    @Autowired
    private FacadeTicketService ticketService;

    @Autowired
    private FacadeOfferService offerService;

    @GetMapping("/offer/{offerId}/ticket")
    public String getAll(@PathVariable String offerId, Model model) {
        model.addAttribute("offer", offerService.getById(offerId));
        model.addAttribute("tickets", ticketService.getAllByOfferId(offerId));
        return "ticketList";
    }

    @GetMapping("/offer/{offerId}/ticket/create")
    public String getTicket(@PathVariable String offerId, Model model) {
        model.addAttribute("offerId", offerId);
        return "ticketCreate";
    }

    @PostMapping("/offer/{offerId}/ticket")
    public String create(@PathVariable String offerId, @RequestParam String count) {
        ticketService.save(offerId, Integer.parseInt(count));
        return "ticketList";
    }

    @PostMapping("/offer/{offerId}/ticket/buy")
    public String buy(@PathVariable String offerId,
                      @RequestParam String packageType,
                      @RequestParam String count,
                      @RequestParam String contact) {

        ticketService.buy(offerId, packageType, Integer.parseInt(count), contact);
        return "ticketList";
    }
}
