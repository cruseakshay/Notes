import java.nio.file.Path;
import java.nio.file.Paths;

class SubPath{
    public static void main(String[] args) {
        Path path1 = Paths.get("F:\\whizlab\\java\\nio");
        System.out.println(path1.subpath(0, 3).toString());
    }
}