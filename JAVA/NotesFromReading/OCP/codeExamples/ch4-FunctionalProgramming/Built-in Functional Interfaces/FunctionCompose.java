import java.util.function.Function;

class FunctionCompose {
    public static void main(String[] args) {
        // First mul will exexute
        Function<Double, Double> mul = d -> d*2;
        // Then f
        Function<Double, Integer> f = d -> d.intValue();
        
        Function<Double, Integer> func = f.compose(mul);

        System.out.println(func.apply(12.6));
    }
}