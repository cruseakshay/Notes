import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            // With single thread executor results are guranteed to be executed in order they are added to executor service.
            System.out.println("begin");
            service.execute(() -> {
                System.out.println("Printing inventory !");
            });

            service.execute(() -> {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Record :" + i);
                }
            });

            service.execute(() -> {
                System.out.println("Printing inventory !!");
            });
            service.execute(()->{
                System.out.println("end");
            });
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}