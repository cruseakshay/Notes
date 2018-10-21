import java.util.stream.Stream;

class TerminalOps {
    // Common terminal methods::
    // allMatch(), anyMatch(), noneMatch(), collect(), count(), findAny(), findFirst(), forEach(), min(), max(), reduce()
    public static void main(String[] args) {
        // 1. count(): returns long :- Number of elements in a finite stream. For infinite stream it Hangs.
        Stream<String> animals = Stream.of("monkey", "gorilla","bonobo");
        System.out.println(animals.count());
    }
}