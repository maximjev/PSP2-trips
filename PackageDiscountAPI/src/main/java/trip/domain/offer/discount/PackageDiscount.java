package trip.domain.offer.discount;


import trip.domain.offer.entity.Offer;

public interface PackageDiscount {

    double calculateDiscount(Offer.PackageType type, double price);
}
