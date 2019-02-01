import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CopyTextFileSample{
    public static List<String> readFile(File source) throws IOException {
        List<String> data = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(source))){
            String s;
            // we stop reading the file when readLine() returns null
            while ((s = reader.readLine()) != null) {
                data.add(s);
            }
        }
        return data;
    }

    public static void writeFile(List<String> data, File destination) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(destination))){
            for (String s : data) {
                writer.write(s);
                writer.newLine();
            }
        }
    }
    public static void main(String[] args) throws IOException{
        File source = new File("SOURCE_PATH");
        File destination = new File("DEST_PATH");

        List<String> data = readFile(source);
        // Print data
        for (String s : data) {
            System.out.println(s);
        }
        writeFile(data, destination);
    }
}