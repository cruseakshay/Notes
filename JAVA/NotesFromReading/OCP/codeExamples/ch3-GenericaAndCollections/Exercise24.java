import java.util.HashSet;
import java.util.Set;

class Exercise24 {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        s.add("lion");
        s.add("tiger");
        s.add("bear");

        // which of the following colpiles and prints an entire set ?
        
        // s.forEach(() -> System.out.println(d));
        // s.forEach(d -> System.out.println(d));
        // s.forEach((d) -> System.out.println(d));
        // s.forEach(System.out.println(s));
        // s.forEach(System::out::println);
        // s.forEach(System::out.println);
    }
}