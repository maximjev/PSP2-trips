package trip.familyPackageDiscount;

import trip.domainOfferAPI.Offer;
import trip.packageDiscountAPI.PackageDiscount;

public class FamilyPackageDiscount implements PackageDiscount {

    @Override
    public double calculateDiscount(Offer.PackageType type, double price) {
        if(type.equals(Offer.PackageType.FAMILY)) {
            return price * 0.65;
        }
        return price;
    }
}
