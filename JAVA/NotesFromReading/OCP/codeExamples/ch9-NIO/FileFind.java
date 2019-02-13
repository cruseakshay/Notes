import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

class FileFind {
    public static void main(String[] args) {
        Path path = Paths.get("DIR_APTH");
        long dateFilter = 1420070400000l;

        try {
            // listing file ending with .java with Files.find(path, int, BiPredicate)
            
            // NIO.2 automatically loads the BasicFileAttributes object 
            Stream<Path> pathStream = Files.find(path, 3, (p, a) -> p.toString().endsWith(".java") && a.lastModifiedTime().toMillis() > dateFilter);

            pathStream.forEach(System.out::println);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}