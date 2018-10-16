import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

class ImpBiConsumer {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        // Biconsumer implementation using method reference
        BiConsumer<String, Integer> bc1 = map::put; // NOTE: this is instance method

        // Biconsumer implementation using lambda
        BiConsumer<String, Integer> bc2 = (k, v) -> map.put(k, v);

        bc1.accept("A", 7); // put some ele in map
        bc2.accept("B", 8); // put some ele in map

        System.out.println(map);
        System.out.println(map);
    }
}