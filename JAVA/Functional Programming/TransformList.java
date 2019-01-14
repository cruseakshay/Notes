import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TransformList{
    public static void main(String[] args) {
        // convert a list of names to all capital letters.
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        // Method 1: Imperative Style using enhanced loop.
        final List<String> upperCaseName = new ArrayList<>();
        for (String name : friends) {
            upperCaseName.add(name.toUpperCase());
        }
        System.out.println(upperCaseName);
        
        //empty the List for reuse.
        upperCaseName.clear();

        // Method 2: Using forEach and Lambda exp.
        upperCaseName.forEach((name) -> upperCaseName.add(name.toUpperCase()));
        System.out.println(upperCaseName);

        //empty the List for reuse.
        upperCaseName.clear();

        // Method 3: Using Stream API and Lambda exp.
        /*
        * The Stream's map() method can map or transform a sequence of input to a sequence of output.
        * The method stream() is available on all collections in JDK 8 and it wraps the collection into an instance of Stream.
        */
        friends.stream().map((name) -> name.toUpperCase()).forEach((name) -> System.out.println(name + " "));

        // Method 4: Using method reference.
        friends.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}