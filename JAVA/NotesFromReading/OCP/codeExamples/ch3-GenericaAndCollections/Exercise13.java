import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

class Exercise13 {
    public void showSize(List<?> list) {
        System.out.println(list.size());
    }
    public static void main(String[] args) {
        Exercise13 card = new Exercise13();
        // which of the following line will compile and why ? 

        // ArrayDeque<?> list = new ArrayDeque<String>();
        // ArrayList<? super Date> list = new ArrayList<Date>();
        // List<?> list = new ArrayList<?>();
        // List<Exception> list = new LinkedList<IOException>();
        Vector<? extends Number> list = new Vector<Integer>();
        card.showSize(list);
        
    }
}