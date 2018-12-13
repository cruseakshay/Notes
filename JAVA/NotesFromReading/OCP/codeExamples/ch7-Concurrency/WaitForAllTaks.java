import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WaitForAllTaks{
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            // Assume List of tasks to run.
            service.submit(()->System.out.println(10));
            service.submit(()->System.out.println(11));
            service.submit(()->System.out.println(12));
            service.submit(()->System.out.println(13));

        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
        if (service != null) {
            service.awaitTermination(1, TimeUnit.MINUTES);
            // check if all tasks are finished.
            if (service.isShutdown()) {
                System.out.println("All tasks are finished !");
            } else {
                System.out.println("at least on of tasks is running !");
            }
        }
    }
}