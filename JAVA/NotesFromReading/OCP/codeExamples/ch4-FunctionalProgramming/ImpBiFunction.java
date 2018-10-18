import java.util.function.BiFunction;

class ImpBiFunction {
    public static void main(String[] args) {
        BiFunction<String, String, String> f1 = String::concat; // using method reference.

        BiFunction<String, String, String> f2 = (x, y) -> x.concat(y); // using lambda functions.

        // Using BiFunction functional interface
        System.out.println(f1.apply("hello ", "thalaiva !"));

        System.out.println(f2.apply("Rajni", "kant"));
    }
}