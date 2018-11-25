package trip.domainOfferAPI;

import java.time.Duration;

public interface Offer {

    enum PackageType {
        FAMILY, SENIOR, COUPLE
    }

    String getId();

    Duration getDuration();

    double getBasePrice();

    PackageType getPackageType();

    double getAdditionalExpenses();
}
