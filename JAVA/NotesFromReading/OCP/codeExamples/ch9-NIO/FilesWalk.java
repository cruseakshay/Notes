import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class FilesWalk {
    public static void main(String[] args) {
        Path path = Paths.get("DIR_PATH");
        try {
            Files.walk(path).filter(p -> p.toString().endsWith(".java")).forEach(System.out::println);
        } catch (IOException e) {
            //TODO: handle exception
        }
    }
}