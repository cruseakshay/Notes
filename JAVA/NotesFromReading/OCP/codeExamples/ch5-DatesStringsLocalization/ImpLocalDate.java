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
    }
}