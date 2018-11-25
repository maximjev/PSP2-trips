package trip.ticketController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import trip.facadeTicketServiceAPI.FacadeTicketService;

@Controller
public class TicketController {

    @Autowired
    private FacadeTicketService ticketService;

    @GetMapping("/offer/{offerId}/ticket")
    public String getAll(@PathVariable String offerId, Model model) {
        model.addAttribute("tickets", ticketService.getAllByOfferId(offerId));
        return "ticketList";
    }

    @GetMapping("/ticket/{ticketId}")
    public String get(@PathVariable String ticketId, Model model) {
        model.addAttribute("ticket", ticketService.getById(ticketId));
        return "ticketView";
    }

    @PostMapping("/ticket")
    public String create(@PathVariable String offerId) {
        ticketService.save(offerId);
        return "ticketCreated";
    }
}
