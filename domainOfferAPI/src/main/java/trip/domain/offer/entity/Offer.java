package trip.domain.offer.entity;

import java.time.Duration;

public interface Offer {

    enum PackageType {
        FAMILY, SENIOR, COUPLE
    }

    String getId();

    String getDuration();

    int getAvailableTickets();

    void addAvailableTickets(int count);

    void buyTickets(int count);

    PackageType getPackageType();

    double getAdditionalExpenses();
}
