import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class ImpChronoUnit {
    public static void main(String[] args) {
        // using ChronoUnit to determine how far apart two Temporal values are.
        // Temporal includes LocalDate, LocalTime, and so on.

        LocalTime t1 = LocalTime.of(5, 15);
        LocalTime t2 = LocalTime.of(6, 30);

        LocalDate d1 = LocalDate.of(2016, 1, 12);

        System.out.println(ChronoUnit.HOURS.between(t1, t2));
        System.out.println(ChronoUnit.MINUTES.between(t1, t2));

        System.out.println(ChronoUnit.HOURS.between(d1, t1)); // DateTimeException {Note: Do not mix Date obj and Time obj}
    }
}