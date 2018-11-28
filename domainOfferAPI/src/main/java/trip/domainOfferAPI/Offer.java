package trip.domainOfferAPI;

import java.time.Duration;

public interface Offer {

    enum PackageType {
        FAMILY, SENIOR, COUPLE
    }

    String getId();

    Duration getDuration();

    double getBasePrice();

    int getAvailableTickets();

    void addAvailableTickets(int count);

    void buyTickets(int count);

    PackageType getPackageType();

    double getAdditionalExpenses();
}
