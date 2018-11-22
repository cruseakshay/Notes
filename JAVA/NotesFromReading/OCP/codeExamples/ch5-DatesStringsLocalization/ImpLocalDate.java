import java.time.LocalDate;
import java.time.Month;

class ImpLocalDate{
    public static void main(String[] args) {
        // static methods
        // 1. getting systems current date.
        System.out.println(LocalDate.now());

        // 2.a creating specific dates
        System.out.println(LocalDate.of(2015, 1, 20)); // year, month, date
        
        // 2.b creating specific dates
        System.out.println(LocalDate.of(2015, Month.JANUARY, 20)); // year, Month, date. here Month is enum.
        
        System.out.println(LocalDate.of(2015, 1, 12)); // year, Month, date. here Month is int.


        // Manipulating Dates : The date and time classes are immutable.
        //Methods for foreward movement: plusDays(), plusWeeks(), plusMonths(), plusYears().
        LocalDate date = LocalDate.of(2018, Month.FEBRUARY, 24);

        System.out.println("Next Date " + date.plusDays(1));

        System.out.println("Next week " + date.plusWeeks(1));

        System.out.println("Next month " + date.plusMonths(1));

        System.out.println("Next Year " + date.plusYears(1));

        //Methods for backward movement: minusDays(), minusWeeks(), minusMonths(), minusYears().
        System.out.println("Prev Date " + date.minusDays(1));
        
        System.out.println("Prev week " + date.minusWeeks(1));
        
        System.out.println("Prev month " + date.minusMonths(1));

        System.out.println("Prev Year " + date.minusYears(1));
    }
}