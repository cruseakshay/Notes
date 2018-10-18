import java.util.function.Function;

class ImpFunction {
    public static void main(String[] args) {
        Function<String, Integer> f1 = String::length; // using method reference.

        Function<String, Integer> f2 = x -> x.length();  // using lambdas

        // using Function Interface 
        System.out.println(f1.apply("Akshay"));

        System.out.println(f2.apply("Java Functional Prgramming"));
    }
}