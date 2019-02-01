import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFileSample{
    public static void copy(File source, File destination) throws IOException{
        try(InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(destination)){
                int b;
                while ((b = in.read())!= -1) {
                    out.write(b);
                }
        }
    }

    public static void main(String[] args) throws IOException{
        File source = new File("Source_path");
        File destination = new File("dest_path");
        copy(source, destination);
    }
}