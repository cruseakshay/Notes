import java.util.LinkedList;
import java.util.List;

class Examples{
    // This is dedicate to LinkedList
    public static void main(String[] args) {
        List<String> list = new LinkedList<>(); // trying shor hand syntax here

        list.add("A");
        list.add("B");
        list.add("C");
    
        // list.addLast("D"); // if i use reference var of type List to refer LinkedList i can't access this method
        ((LinkedList)list).addFirst("D"); // but casting it makes it possible to access, but this unsafe and unchecked operation
    
        // list.addFirst("Z"); // doesn't compile

        System.out.println(list);       
    }
}