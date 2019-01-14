import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class IteratingList{
    public static void main(String[] args) {
      /**
       * All styles of enumerating a List. 
       * 
       */  
      final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

      // Method 1: Old for loop
      for (int i = 0; i < friends.size(); i++) {
          System.out.println(friends.get(i));
      }

      //Method 2: Enhanced For loop.
      for (String name : friends) {
          System.out.println(name);
      }

      // Method 3: Using JAVA 8 FunctionalInterface 
      friends.forEach(new Consumer<String>() {
          @Override
          public void accept(final String name) {
              System.out.println(name);
          }
      });

      //Method 4: Using lambda expressions.
      friends.forEach((final String name) -> System.out.println(name));
    }
}