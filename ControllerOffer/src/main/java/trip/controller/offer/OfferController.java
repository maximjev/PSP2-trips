package trip.controller.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import trip.domain.offer.service.Adventure;
import trip.domain.offer.service.Offer;
import trip.domain.offer.Trip;
import trip.facade.offer.FacadeOfferService;

import java.time.Duration;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/offer")
public class OfferController {

    @Autowired
    private FacadeOfferService offerService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("offers", offerService.getAll());
        return "offerList";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable String id, Model model) {
        Offer offer = offerService.getById(id);
        model.addAttribute("offer", offer);
        if (offer instanceof Trip) {
            model.addAttribute("from", ((Trip) offer).getFrom());
            model.addAttribute("till", ((Trip) offer).getTill());
            model.addAttribute("destination", ((Trip) offer).getDestination());
        }
        if (offer instanceof Adventure) {
            model.addAttribute("location", ((Adventure) offer).getLocation());
        }
        return "offerView";
    }

    @PostMapping("/trip")
    public String create(
            @RequestParam(name = "from") String from,
            @RequestParam(name = "till") String till,
            @RequestParam(name = "destination") String destination,
            @RequestParam(name = "packageType") String packageType) {

        offerService.createOffer(LocalDateTime.parse(from), LocalDateTime.parse(till), destination, packageType);
        return "offerCreated";
    }

    @PostMapping("/adventure")
    public String create(
            @RequestParam(name = "duration") String duration,
            @RequestParam(name = "location") String location,
            @RequestParam(name = "packageType") String packageType) {

        offerService.createOffer(Duration.parse(duration), location, packageType);
        return "offerCreated";
    }

    @GetMapping("/{id}/price")
    public String getPrice(@PathVariable String id,
                           @RequestParam(name = "count") String count,
                           @RequestParam(name = "packageType") String packageType,
                           Model model) {

        model.addAttribute("price", offerService.getPrice(id, Integer.parseInt(count), packageType));
        return "offerPrice";
    }
}
