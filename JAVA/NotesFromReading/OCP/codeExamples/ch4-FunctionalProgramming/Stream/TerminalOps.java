import java.util.Optional;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
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

        // 5. forEach(): there is no return value.
        Stream.of(1,2,3,4).forEach(System.out::println);

        // 6. reduce()- combines a stream into an single object. has 3 varients.
        Stream<String> str = Stream.of("w","o", "l", "f");
        // 1st varient
        String word = str.reduce("", (a,b) -> a+b); // identity, accumulator: start with an initial value and keep merging it with the next one.
        System.out.println(word);

        // the identity isn't really necessary so java lets us omit it. so when we dont specify identity, an Optional is returned as there might be no data.
        BinaryOperator<Integer> ops = (q,w) -> q * w;
        Stream<Integer> emptyStream = Stream.empty();
        Stream<Integer> oneEleStream = Stream.of(3);
        Stream<Integer> multiEleStream = Stream.of(3,5,6);

        // 2nd varient: observe the output 
        emptyStream.reduce(ops).ifPresent(System.out::println); // if stream is empty, an empty Optional is returned.
        oneEleStream.reduce(ops).ifPresent(System.out::println); // if stream has one element it is returned.
        multiEleStream.reduce(ops).ifPresent(System.out::println); // if multiple ele then accumulator is applied to combine them.

        //3rd varient: used when processing collections in parallel.
        Stream<Integer> numStream = Stream.of(3,5,6);
        System.out.println(numStream.reduce(1, ops, ops));// identity, accumulator, combiner

        // 7. collect(): a mutable reduction-efficient. has 2 varients and very useful as it lets us get data out of streams and into another form.
        // 1st varient : used when we want to code specifically how the collecting should work.
        StringBuilder wordFormed = Stream.of("R","A","j","N","i","K","a","n","t").collect(StringBuilder::new, StringBuilder::append, StringBuilder::append); //supplier, BiConsumer-accumulator, BiConsumer-combiner. here logic is same in accumulator and combiner.
        System.out.println(wordFormed);

        // different logic in accumulator and combiner.
        TreeSet<String> aSet = Stream.of("R","A","j","N","i","K","a","n","t").collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(aSet);
    }
}