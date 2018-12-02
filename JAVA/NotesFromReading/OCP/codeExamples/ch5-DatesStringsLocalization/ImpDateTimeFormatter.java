import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

class ImpDateTimeFormatter{
    public static void main(String[] args) {
        // Formatting Dates and Times
        LocalDate date = LocalDate.of(2018, Month.DECEMBER, 2);
        LocalTime time = LocalTime.of(11, 52);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        // Using methods from object.
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // Note Formatter used.
    }
}