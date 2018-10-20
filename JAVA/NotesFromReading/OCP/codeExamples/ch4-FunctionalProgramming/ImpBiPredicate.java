import java.util.function.BiPredicate;

class ImpBiPredicate {
    public static void main(String[] args) {
        BiPredicate<String, String> b1 = String::startsWith; // using method reference.
        BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix); // using lambdas.

        System.out.println(b1.test("Rajnikant", "Rajni")); // returns boolean not Boolean.
        System.out.println(b2.test("Iron Man", "Iron"));
    }
}