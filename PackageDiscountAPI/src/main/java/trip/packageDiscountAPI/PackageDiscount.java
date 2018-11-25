package trip.packageDiscountAPI;

import trip.domainOfferAPI.Offer;

public interface PackageDiscount {

    double calculateDiscount(Offer.PackageType type, double price);
}
