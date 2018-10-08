import java.util.Arrays;
import java.util.Comparator;
// Notice use generic type in class declaration
class Exercise9 implements Comparator<String>{
    @Override
    public int compare(String a, String b) {
        return b.toLowerCase().compareTo(a.toLowerCase()); // IMP: use of method delegation.
    }
    public static void main(String[] args) {
        String[] values = {"123", "Abb", "aab"};
        Arrays.sort(values, new Exercise9()); // here Exercise9 is Comparator Instance.

        for (String var : values) {
            System.out.print(var + " "); // what will be the output ?
        }
    }
}