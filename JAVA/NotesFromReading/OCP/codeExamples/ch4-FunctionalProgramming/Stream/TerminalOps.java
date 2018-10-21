import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

class TerminalOps {
    // Common terminal methods::
    // allMatch(), anyMatch(), noneMatch(), collect(), count(), findAny(), findFirst(), forEach(), min(), max(), reduce()
    public static void main(String[] args) {
        // 1. count(): returns long :- Number of elements in a finite stream. For infinite stream it Hangs.
        Stream<String> animals = Stream.of("monkey", "gorilla","bonobo");
        System.out.println(animals.count());

        // 2. min() and max(): returns Optional<T>. For infinite stream it Hangs. allows to pass a custom comparator.
        Stream<String> s = Stream.of("monkey", "ape","bonobo");
        Optional<String> opt = s.min((s1, s2) -> s1.length() - s2.length());
        opt.ifPresent(System.out::println);

        Stream.of("dog", "cat","lizard").min((s1, s2) -> s1.length() - s2.length()).ifPresent(System.out::println); // method chaining and lambda showing Functional programming power.

        // 3. findAny() and findFirst(): return an element of the stream, returns empty Optional if stream is empty.
        Stream.of("dog", "cat","lizard").findAny().ifPresent(System.out::println);

        Stream.of("cat","lizard", "dog").findFirst().ifPresent(System.out::println);
        
        // 4. allMatch(), anyMatch() and noneMatch(): return boolean
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(Stream.of("dog","lizard", "1dog").anyMatch(pred)); // as the fn returns boolean
        System.out.println(Stream.of("dog","lizard", "1dog").allMatch(pred));
        System.out.println(Stream.of("dog","lizard", "1dog").noneMatch(pred));

        // 5. 
    }
}