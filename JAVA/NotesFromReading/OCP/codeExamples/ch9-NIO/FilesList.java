import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class FilesList{
    // Files.list() searches one level deep and is analogous to java.io.File.listFiles(), except that it relies on streams.
    public static void main(String[] args) {
        Path path = Paths.get("DIR_PATH");
        try {
            // iterate over a directory, outputting the full path of the files that it contains.
            Files.list(path)
             .filter(p -> !Files.isDirectory(path))
             .map(p-> p.toAbsolutePath())
             .forEach(System.out::println);
        } catch (IOException e) {
            //TODO: handle exception
        }
    }
}