import java.util.Arrays;
import java.util.List;

class JoinOnStream{
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        // Problem Statement: concatenating a collection

        // Traditional Style.
        for (String name : friends) {
            System.out.print(name + ", "); // Dangling comma at the end
        }
        System.out.println();

        // Using StringJoiner class for printing.
        System.out.println(String.join(", ", friends));
    }
}