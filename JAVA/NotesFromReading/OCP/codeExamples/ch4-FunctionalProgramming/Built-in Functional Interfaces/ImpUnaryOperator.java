import java.util.function.UnaryOperator;

class ImpUnaryOperator{
    public static void main(String[] args) {
        UnaryOperator<String> u1 = String::toUpperCase; // using method reference.
        UnaryOperator<String> u2 = x->x.toUpperCase(); // using lambda.

        // using UnaryOperator Functional Interface.
        System.out.println(u1.apply("rajnikant"));
        System.out.println(u2.apply("@ java"));

    }
}