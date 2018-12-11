public class ThreadExample2 extends Thread{
    // Less common method to extend Thread class and Overridding the run() method.
    @Override
    public void run() {
        System.out.println("Printing from Thread Example !");
    }
    public static void main(String[] args) {
        (new ThreadExample2()).start();
    }
}