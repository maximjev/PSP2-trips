package trip.domainServiceOffer;

import trip.domainOfferAPI.Offer;

public interface DomainOfferService {
    double calculatePrice(Offer offer, int ticketCount, Offer.PackageType packageType);

    void addTickets(String offerId, int count);

    void buy(String offerId, int count, Offer.PackageType packageType, String contact);
}
