import java.io.File;

public class ReadFileInformation{
    public static void main(String[] args) {
        File file = new File("D:\\Akshay"); // NOTE: escaspe char '\'
        System.out.println("File exists: " + file.exists());
        if (file.exists()) {
            System.out.println("Absolute Path: "+ file.getAbsolutePath());
            System.out.println("Is Directory: "+ file.isDirectory());
            System.out.println("Parent Path: "+ file.getParent());
            if (file.isFile()) {
                System.out.println("File size: "+ file.length());
                System.out.println("Last Modified: "+ file.lastModified());
            } else {
                for (File subfile : file.listFiles()) {
                    System.out.println(subfile.getName());
                }
            }
        }
    }
}