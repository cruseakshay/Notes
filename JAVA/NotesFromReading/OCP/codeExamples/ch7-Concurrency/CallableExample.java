import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ClassableExample{
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result = service.submit(()-> 30+11);
            System.out.println(result.get()); // Notice: Callable has return type.
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
