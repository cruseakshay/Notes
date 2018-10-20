import java.util.HashMap;
import java.util.function.Consumer;

class ImpConsumer {
    public static void main(String[] args) {
        // Consumer using method reference
        Consumer<String> c1 = System.out::println;
        
        // Consumer using lambda
        Consumer<String> c2 = x -> System.out.println(x);

        c1.accept("ola");
        c2.accept("yanna Consumer !");
    }
}