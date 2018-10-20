import java.util.function.BinaryOperator;

class ImpBinaryOperator{
    public static void main(String[] args) {
        BinaryOperator<String> bo1 = String::concat; // using method reference
        BinaryOperator<String> bo2 = (string, toConcat) -> string.concat(toConcat); // using lambdas.

        System.out.println(bo1.apply("Rajni", "Kant"));
        System.out.println(bo2.apply("Iron", "Man"));
    }
}