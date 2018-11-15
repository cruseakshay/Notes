import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

class ImpZonedDateTime {
    public static void main(String[] args) {
        /** From exam point of view: important method signatures.
         *  public static ZonedDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanos, ZoneId zone)
            public static ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone)
            public static ZonedDateTime of(LocalDateTime dateTime, ZoneId zone)
         */

        System.out.println(ZonedDateTime.now()); // get curr ZonedDateTime of sys.

        // For creating ZonedDateTime object, First we require desiered ZoneId
        ZoneId zone = ZoneId.of("US/Eastern");

        // now we can create ZonedDateTime object from ZoneId.
        ZonedDateTime zoned1 = ZonedDateTime.of(2014, 02, 24, 12, 10, 55, 20, zone);
        System.out.println(zoned1);

        ZonedDateTime zoned2 = ZonedDateTime.of(LocalDate.of(2015, Month.APRIL, 12), LocalTime.of(12, 12), zone);
        System.out.println(zoned2);

        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(2015, Month.APRIL, 12), LocalTime.of(12, 12));
        ZonedDateTime zoned3 = ZonedDateTime.of(localDateTime, zone);
        System.out.println(zoned3);
    }
}