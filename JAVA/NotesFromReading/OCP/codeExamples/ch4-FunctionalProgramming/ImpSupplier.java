import java.time.LocalDate;
import java.util.function.Supplier;

class ImpSupplier {
    public static void main(String[] args) {
        Supplier<LocalDate> s1 = LocalDate::now; // implementaion one
        Supplier<LocalDate> s2 = () -> LocalDate.now(); // implementaion two

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println(d1);
        System.out.println(d2);
    }
}