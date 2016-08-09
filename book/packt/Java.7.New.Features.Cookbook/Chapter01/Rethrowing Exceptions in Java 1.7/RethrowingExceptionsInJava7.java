package packt;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RethrowingExceptionsInJava7 {

    public static void main(String[] args) {
        try {
            deleteFile(Paths.get(new URI("file:///tmp.txt")));
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private static void deleteFile(Path path) throws NoSuchFileException, DirectoryNotEmptyException {
        try {
            Files.delete(path);
        } catch (IOException ex) {
            if (path.toFile().isDirectory()) {
                throw new DirectoryNotEmptyException(null);
            } else {
                throw new NoSuchFileException(null);
            }
        }
    }
}
