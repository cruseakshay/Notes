import java.util.*;
class Test{
    public static void main(String[] args) {
        // Dedicated to ArrayList methods
        List<Integer> list = new ArrayList<Integer>(); // List is an Interface.

        //Put some ele in it
        for (int i = 0; i < 10; i++) {
            list.add(i); // i is primitive data type here, autoboxing is used to insert it in Intger ArrayList.
        }

        // print the List using enhanced for loop
        for (int var : list) { // uses unboxing for Integer -> int conversion.
            System.out.print(var + " ");
        }

        // void add(int index, Object element): This method is used to insert a specific element at a specific position index in a list.
        list.add(1, 888);
        System.out.println("\nList after:");
        for (int var : list) { // uses unboxing for Integer -> int conversion.
            System.out.print(var + " ");
        }
        System.out.println("\n");

        // add duplicate ele in list
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                list.add(i);
            }
        }

        for (int var : list) { // uses unboxing for Integer -> int conversion.
            System.out.print(var + " ");
        }
        System.out.println("\n");

        //int indexOf(Object O): The index the first occurrence of a specific element is either returned, or -1 in case the element is not in the list.
        System.out.println("Location of first 2 : "+ list.indexOf(2));; // when multiple same ele are present in list.

        System.out.println("Location of first 10 : " + list.indexOf(10));; // when ele is not present.

        // int lastIndexOf(Object O): The index the last occurrence of a specific element is either returned, or -1 in case the element is not in the list.
        System.out.println("Location of Last 2 : "+ list.lastIndexOf(2));; // when multiple same ele are present in list.

        System.out.println("Location of Last 10 : " + list.lastIndexOf(10));; // when ele is not present.

        // void clear(): This method is used to remove all the elements from any list.
        list.clear(); // removes all ele from list.

        System.out.println(list); // list is empty
    }
}