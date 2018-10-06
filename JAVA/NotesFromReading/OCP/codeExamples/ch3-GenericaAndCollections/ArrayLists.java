import java.util.*;

public class ArrayLists{
    public static void main(String[] args) {
        String[] array = {"akshay", "ajay"};
        List<String> list = Arrays.asList(array);
        System.out.println(list);
        list.set(1, "ajaykumar");
        System.out.println("after modification using List reference: " + list);
        array[0] = "akshaykumar";
        System.out.println("after modification using array itself: " + list); // means both are manupulating same object.
        String[] array2 = (String [])list.toArray(); // conv back to array
        System.out.println(array2); // prints hashcode as no toString override is present.

        list.remove(1); 
        // doen't work as its just an array under the hood which does not resize.
    }
}