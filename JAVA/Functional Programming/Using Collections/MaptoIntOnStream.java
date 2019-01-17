import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class MaptoIntOnStream {
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        // Reduction Problem Statement.
        // read over the values in the friends collection of names and determine the total number of characters.
        System.out.println(
            friends.stream().mapToInt(name -> name.length()).sum()
        );

        // mapToInt(): creates type-specialized stream i.e. IntStream.

        // Problem Statement: Read over the given collection of names and display the longest one.
        // If there is more than one name with the same longest length, display the first one found.

        final Optional<String> aLongName = friends.stream().reduce(
            // strategy pattern in action: concern is seperated from reduction
            (name1, name2) -> name1.length() >= name2.length()? name1 : name2
        );

        aLongName.ifPresent(System.out::println);
        // If we want to set a default or a base value, we can pass that value as an extra parameter to an overloaded variation of the reduce() method.

        //This version of reduce() does not return an Optional.
        final String steveOrLonger = friends.stream().reduce("Steve",
            // If any name was longer than the given base, it would get picked up; otherwise the function would return the base value
            (name1, name2) -> name1.length() >= name2.length()? name1 : name2
        );
        System.out.println(steveOrLonger);
    }
}
