import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

class ImpDateTimeFormatter{
    public static void main(String[] args) {
        // Formatting Dates and Times
        LocalDate date = LocalDate.of(2018, Month.DECEMBER, 2);
        LocalTime time = LocalTime.of(11, 52);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        // Using methods from object.
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // Note Formatter used.

        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME)); // Note Formatter used.

        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // Note Formatter used.

        // Static methods.
        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT); // Note methods used and FormatStyle.

        System.out.println(shortDateTime.format(dateTime));
        System.out.println(shortDateTime.format(date));
        System.out.println(shortDateTime.format(time)); // UnsupportedTemporalTypeException: as Time cannot be formatted as Date.
    }
}