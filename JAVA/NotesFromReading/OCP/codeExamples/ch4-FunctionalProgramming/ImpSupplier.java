import java.time.LocalDate;
import java.util.function.Supplier;

class ImpSupplier {
    public static void main(String[] args) {
        // Supplier using LocalDate
        Supplier<LocalDate> s1 = LocalDate::now; // implementaion one
        Supplier<LocalDate> s2 = () -> LocalDate.now(); // implementaion two

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println(d1);
        System.out.println(d2);

        // Supplier using StringBuilder
        Supplier<StringBuilder> s3 = StringBuilder::new; // using method reference
        Supplier<StringBuilder> s4 = () -> new StringBuilder(); // using lambda 

        System.out.println(s3.get());
        System.out.println(s4.get());
    }
}