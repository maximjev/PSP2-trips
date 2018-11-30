package trip.facade.offer;


import trip.domain.offer.DomainOfferService;
import trip.domain.offer.Offer;
import trip.factory.offer.OfferFactory;
import trip.repository.offer.OfferRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class FacadeOfferServiceImpl implements FacadeOfferService {

    private OfferRepository offerRepository;

    private OfferFactory offerFactory;

    private DomainOfferService offerService;

    public FacadeOfferServiceImpl(OfferRepository offerRepository,
                                  OfferFactory offerFactory,
                                  DomainOfferService offerService) {
        this.offerRepository = offerRepository;
        this.offerFactory = offerFactory;
        this.offerService = offerService;
    }

    @Override
    public Offer getById(String id) {
        return offerRepository.getById(id);
    }

    @Override
    public List<Offer> getAll() {
        return offerRepository.getAll();
    }

    @Override
    public void createOffer(LocalDateTime from, LocalDateTime till, String destination, String packageType) {
        offerRepository.save(offerFactory.getOffer(from, till, destination, packageType));
    }

    @Override
    public void createOffer(Duration duration, String location, String packageType) {
        offerRepository.save(offerFactory.getOffer(duration, location, packageType));
    }

    @Override
    public double getPrice(String offerId, int ticketCount, String packageType) {
        return offerService.calculatePrice(
                offerRepository.getById(offerId),
                ticketCount,
                Offer.PackageType.valueOf(packageType));
    }
}

