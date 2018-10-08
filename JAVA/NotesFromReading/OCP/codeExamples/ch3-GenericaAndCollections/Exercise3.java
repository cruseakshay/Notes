import java.util.*;

class Excercise3 {
    // from excercise to predict output
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add(1);
        for (String var : list) { // line will compile or not ??
            System.out.print(var);
        }
    }
}