import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class FindFirstOnStream {
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        /**
         *  The Optional class is useful whenever the result may be absent. It protects us
         *  from getting a NullPointerException by accident and makes it quite explicit to the
         *  reader that 'no result found' is a possible outcome.
         */
        
        // isPresent(): to check if value is returned.
        // get(): to get the value.
        // orElse(): to get a Substitue if value is not present.
        // ifPresent(): to run a block of code or a lambda expression only if a value is present.
        final Optional<String> foundName = friends.stream().filter(name -> name.startsWith("N")).findFirst();
        System.out.println(foundName.isPresent());
        System.out.println(foundName.get());
        System.out.println(foundName.orElse("Not Presnt"));

        foundName.ifPresent(name -> System.out.println(name));
        foundName.ifPresent(System.out::println); // ifPresent() expects a Consumer<>
    }
}