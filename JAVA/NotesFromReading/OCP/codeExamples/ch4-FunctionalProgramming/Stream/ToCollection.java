import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class ToCollection{
    public static void main(String[] args) {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

        // cant assume any particular List implementation with this method
        List<String> listAsResult = givenList.stream().collect(Collectors.toList());
        
        // cant assume any particular Set implementation with this method
        Set<String> setAsResult = givenList.stream.collect(Collectors.toSet());

        // To get back custom implementation of desiered collection
            // LinkedList as result
        List<String> listAsResult2 = givenList.stream().collect(Collectors.toCollection(LinkedList::new));

        // collect elements into a Map that stores strings as keys and their lengths as values.
        Map<String, Integer> mapAsResult = givenList.stream().collect(Collectors.toMap(Function.identity(), String::length));

        // What happens if collection contains duplicate elements?
            // Note that toMap doesn’t even evaluate whether the values are also equal. If it sees duplicate keys, it immediately throws an IllegalStateException.
            // cases with key collision, use Collectors.toMap(keyMapper, valueMapper, mergeFunction)
            
            Map<String, Integer> mapAsResult2 = Arrays.asList("a", "bb", "c", "d", "bb") // Contains duplicates for Map:Key
                                                    .stream().collect(Collectors.toMap(Function.identity(), String::length, 
                                                    // BiFunction to help decide in case of collison.
                                                    (item, identicalItem)-> item));
        

        
        {
            // CollectingAndThen is a special collector that allows performing another action on a result straight after collecting ends.
            List<String> result = givenList.stream().collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));
        }
        {
            // Joining collector can be used for joining Stream<String> elements.
            String result = givenList.stream.collect(Collectors.joining());
            System.out.println(result);
        }
        {
            // Joining collector: custom separators, prefixes, postfixes.
            String result = givenList.stream().collect(Collectors.joining(" "));
            System.out.println(result);
        }
        {
            String result = givenList.stream().collect(joining(" ", "PRE-", "-POST"));
            System.out.println(result);
        }
        {
            // Collectors.counting(): Counting is a simple collector that allows simply counting of all Stream elements.
            Long result = givenList.stream().collect(Collectors.counting());
            System.out.println(result);
        }
        {
            // Collectors.summarizingDouble/Long/Int(): returns a special class containing statistical information about numerical data 
            // in a Stream of extracted elements.
            DoubleSummaryStatistics result = givenList.stream().collect(Collectors.summarizingDouble(String::length));
            // Info available in summary.
            System.out.println(result.getCount());
            System.out.println(result.getMin());
            System.out.println(result.getMax());
            System.out.println(result.getSum());
            System.out.println(result.getAverage());
        }
    }
}