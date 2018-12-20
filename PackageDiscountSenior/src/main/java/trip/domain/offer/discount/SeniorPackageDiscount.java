package trip.domain.offer.discount;


import trip.domain.offer.entity.Offer;

public class SeniorPackageDiscount implements PackageDiscount {

    @Override
    public double calculateDiscount(Offer.PackageType type, double price) {
        if (type.equals(Offer.PackageType.SENIOR)) {
            return price * 0.5;
        }
        return price;
    }
}
