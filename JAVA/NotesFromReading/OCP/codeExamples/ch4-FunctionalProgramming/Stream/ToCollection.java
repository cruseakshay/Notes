import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
    }
}