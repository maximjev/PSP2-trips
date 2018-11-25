package trip.offerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import trip.facadeOfferServiceAPI.FacadeOfferService;

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
        model.addAttribute("offer", offerService.getById(id));
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
}
