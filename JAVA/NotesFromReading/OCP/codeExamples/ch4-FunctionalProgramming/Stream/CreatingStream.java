import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class CreatingStream {
    // Stream interface is in java.util.stream package
    public static void main(String[] args) {
        // ways to create streams.

        // 1. Empty Stream
        Stream<String> empty = Stream.empty();

        //2. Stream with single element.
        Stream<Integer> singleEle = Stream.of(1);

        //3. Stream from an array.
        Stream<Integer> fromArray = Stream.of(1, 2, 3, 4);
        String[] arr = new String[]{"a", "b", "c"};
          // using full array
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        // using partial array
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

        //4. Converting from list to stream.
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream(); // process ele in parallel.

        //5. Creating infinite stream
        Stream<Double> randoms = Stream.generate(Math::random); // generate stream of random numbers.
        Stream<Integer> oddNUmbers = Stream.iterate(1, n -> n+2); // generate stream of odd numbers. Here 1 is seed/starting value.
        // lambda expression gets the previous value and generates the next one.
        
    }
}