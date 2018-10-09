import java.util.HashMap;
import java.util.Map;

class Exercise11 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= 10; i++) {
            map.put(i, i*i);
        }

        System.out.println(map.get(4)); // what will be the output ?
    }
}