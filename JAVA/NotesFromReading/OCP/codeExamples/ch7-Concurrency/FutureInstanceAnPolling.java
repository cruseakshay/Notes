import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class FutureInstanceAnPolling {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
          service = Executors.newSingleThreadExecutor();  
          // Use of Future<v> for result
          Future<?> result = service.submit(()->{
              for (int i = 0; i < 500; i++) {
                  FutureInstanceAnPolling.counter++;
              }
          });
          result.get(10, TimeUnit.SECONDS); // Note: use of TimeUnit.
          System.out.println("Reached !");
        } catch (TimeoutException e) {
            System.out.println("Not reached in Time");
        } finally{
            if (service != null) {
                service.shutdown();
            }
        }

    }
}