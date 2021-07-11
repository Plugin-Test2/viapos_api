package viapos.helper;

import viapos.model.Subscription;
import viapos.model.Transaction;

import java.time.LocalDate;

public class SubscriptionHelper {

    private static String yearly = "YEARLY";
    private static String monthly = "MONTHLY";
    private static String daily = "DAILY";
    private static long one = 1;

    public static Transaction convertToTransaction(Subscription subscription) {
        return new Transaction();
    }

    public static LocalDate getDueDate(LocalDate localDate, String occurrence) {
        LocalDate newDate = LocalDate.now();
        if (yearly.equalsIgnoreCase(occurrence)) {
            newDate = localDate.minusYears(one);
        } else if (monthly.equalsIgnoreCase(occurrence)) {
            newDate = localDate.minusMonths(1);
        } else if (daily.equalsIgnoreCase(occurrence)) {
            newDate = localDate.minusDays(1);
        }
        return newDate;
    }
}
