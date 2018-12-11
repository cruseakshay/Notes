public class ThreadExample1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Record:: " + i);
        }
    }

    // Creating Thread using Runnable instance.
    public static void main(String[] args) {
        (new Thread(new ThreadExample1())).start();
    }
}