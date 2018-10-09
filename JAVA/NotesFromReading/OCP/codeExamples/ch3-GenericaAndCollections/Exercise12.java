import java.io.FileNotFoundException;

class Exercise12 {
    public static <U extends Exception> void printException(U u){
        System.out.println(u.getMessage());
    }
    public static void main(String[] args) {
        // Find which of the following lines wont compile and why ?
        Exercise12.printException(new FileNotFoundException("A"));
        Exercise12.printException(new Exception("B"));
        Exercise12.<Throwable>printException(new Exception("C"));
        Exercise12.<NullPointerException>printException(new NullPointerException("D"));
        Exercise12.printException(new Throwable("E"));
    }
}