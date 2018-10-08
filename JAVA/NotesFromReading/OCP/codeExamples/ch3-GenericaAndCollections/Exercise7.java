import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Exercise7 {
    public static void main(String[] args) {
        Set<Number> numbers = new HashSet<>();
        // add ele to the set: doesn't allow duplicates, IMP: does not preserve insertion order.
        numbers.add(new Integer(86));
        numbers.add(75);
        numbers.add(new Integer(86));
        numbers.add(null); // important : null gets inserted
        numbers.add(309L); // pay attension: this also gets inserted
        Iterator iter = numbers.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }

    }
}