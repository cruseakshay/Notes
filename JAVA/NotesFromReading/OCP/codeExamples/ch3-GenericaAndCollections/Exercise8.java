import java.util.TreeSet;

class Exercise8 {
    public static void main(String[] args) {
        TreeSet<String> tree = new TreeSet<String>();
        tree.add("one");
        tree.add("One");
        tree.add("ONE");

        System.out.println(tree.ceiling("On")); // what will be the output ? and why ?
    }
}