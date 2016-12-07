package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by stefanangelov on 8/24/16.
 */
public class NIO {
    public static void main(String[] args) throws IOException {
        Path currentRelativePath = Paths.get("");
        Path path = Paths.get(currentRelativePath.toAbsolutePath().toString()+"/src/files/source.txt");
        Path dest = Paths.get(currentRelativePath.toAbsolutePath().toString()+"/src/files/dest.txt");
        boolean exists = Files.exists(path);
        Files.copy(path,dest);
        System.out.print(exists);
    }
}
