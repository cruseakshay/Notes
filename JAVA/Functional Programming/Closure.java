import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Closure {
    // Return Functions -> Higher Order Function in Java
    public static Predicate<String> checkIfStartsWith(final String letter) {
        
        /*
        * Lexical scoping is a powerful technique that lets us cache values provided in one context for use later in another context. 
        * Since this lambda expression closes over the scope of its definition, it's also referred to as a closure.
        */

        return name -> name.startsWith(letter); // Behaviour as result.
    }
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        
        // Closure in action: follows  DRY: Don't Repeat Yourself Principle.
        System.out.println(friends.stream().filter(checkIfStartsWith("N")).count()); // Prints 2
        System.out.println(friends.stream().filter(checkIfStartsWith("R")).count()); // Prints 1
    }
}