import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class ClosureRefactoered {
    // Initial version of Closure
    public static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        System.out.println(friends.stream().filter(checkIfStartsWith("N"))); // return: 2

        // Rectoered to Reduce Scope of static function.
        final Function<String, Predicate<String>> startsWithLetter = (String letter) -> {
            Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
            return checkStarts;
        };

        System.out.println(friends.stream().filter(startsWithLetter.apply("N"))); // returns: 2

        // More Compact version with Functional Approach.
        final Function<String, Predicate<String>> startsWithLetterComp = letter -> name -> name.startsWith(letter);

        System.out.println(friends.stream().filter(startsWithLetterComp.apply("N"))); // returns: 2
    }
}