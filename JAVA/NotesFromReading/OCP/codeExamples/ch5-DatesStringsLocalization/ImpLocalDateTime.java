import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

class ImpLocalDateTime{
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now()); // curr date time of the sys.

        // creating datetime object using date and time 
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 15);
        LocalTime time1 = LocalTime.of(5, 50);

        LocalDateTime dateAnTime = LocalDateTime.of(date1, time1);

        //
    }
}