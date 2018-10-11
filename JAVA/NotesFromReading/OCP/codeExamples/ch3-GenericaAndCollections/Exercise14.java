import java.util.Comparator;
import java.util.TreeSet;

class Exercise14 implements Comparable<Exercise14>, Comparator<Exercise14>{
    private int num;
    private String text;
    Exercise14(int n, String t){
        this.num = n;
        this.text = t;
    }
    @Override
    public String toString() {
        return ""+ num;
    }
    @Override
    public int compareTo(Exercise14 s) {
        return text.compareTo(s.text);
    }
    @Override
    public int compare(Exercise14 s1, Exercise14 s2) {
        return s1.num - s2.num;
    }

    public static void main(String[] args) {
        Exercise14 s1 = new Exercise14(88, "a");
        Exercise14 s2 = new Exercise14(55, "b");

        TreeSet<Exercise14> t1 = new TreeSet<Exercise14>();
        t1.add(s1);
        t1.add(s2);
        
        System.out.println(t1);
        
        TreeSet<Exercise14> t2 = new TreeSet<Exercise14>(s1);
        System.out.println("adding s1 again "+t2.add(s1));;
        t2.add(s2);

        System.out.println(t1 + " " + t2);
    }
}