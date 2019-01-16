import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FilterList {
    public static void main(String[] args) {
        // Finding Elements in Collection Using Filter().
        
        // The filter() method expects a lambda expression that returns a boolean result.
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        
        // Functional Approach.
        final List<String> startsWithN = friends.stream().filter(name -> name.startsWith("N")).collect(Collectors.toList());
    }
}