package trip.domainServiceOfferImpl;

import trip.domainOfferAPI.Offer;
import trip.domainServiceOffer.DomainOfferService;
import trip.packageDiscountAPI.PackageDiscount;

public class DomainOfferServiceImpl implements DomainOfferService {

    private PackageDiscount packageDiscount;

    public DomainOfferServiceImpl(PackageDiscount packageDiscount) {
        this.packageDiscount = packageDiscount;
    }

    @Override
    public double calculatePrice(Offer offer) {
        return packageDiscount.calculateDiscount(offer.getPackageType(),
                offer.getBasePrice() + offer.getAdditionalExpenses());
    }
}
