import java.util.Arrays;

public class ArraySortingBasic {
    public static void main(String[] args) {
        int[] intArray = {7, 4, 9, 4, 3};
        System.out.println("Before sorting: ");
        // using enhanced for loop
        for (int var : intArray) {
            System.out.print(var + " ");
        }
        System.out.println("\n");
        Arrays.sort(intArray); // one of the overloaded methods
        
        //Arrays.sort(intArray, 1, intArray.length-1); // second overriden method
        System.out.println("After sorting: ");
        
        // using enhanced for loop
        for (int var : intArray) {
            System.out.print(var + " ");
        }
        System.out.println("\n");
        
        // array needs to be sorted for appropriate result from Searching.
        System.out.println("9 is present @ "+Arrays.binarySearch(intArray, 9));
    }    
}