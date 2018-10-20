import java.util.function.Predicate;

class ImpPredicate{
    public static void main(String[] args) {
        // implementing Predicate using method reference 
        Predicate<String> p1 = String::isEmpty; // Note: Predicate returns boolean not Boolean.

        // implementing Predicate using lambda
        Predicate<String> p2 = x -> x.isEmpty();

        System.out.println(p1.test("")); // true
        System.out.println(p2.test("")); // true
    }
}