import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.omg.CORBA_2_3.portable.InputStream;

public class CopyBufferFileSample {
    public static void copy(File source, File destination) throws IOException{
        try(InputStream in = new BufferedInputStream(new FileInputStream(source));
            OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))){
                // define buffer size to use.
                byte[] buffer = new byte[1024];
                int lengthRead; // Important
                while ((lengthRead = in.read(buffer)) > 0) {
                    out.write(buffer, 0, lengthRead);
                    out.flush();
                }
        }
    }

    public static void main(String[] args) {
        File source = new File("SOURCE_PATH");
        File destination = new File("DEST_PATH");
        copy(source, destination);
    }
}