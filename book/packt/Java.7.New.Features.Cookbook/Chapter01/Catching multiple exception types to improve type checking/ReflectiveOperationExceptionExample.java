package packt;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReflectiveOperationExceptionExample {

    public static void main(String[] args) {
        try {
            Files.delete(Paths.get(new URI("file:///tmp.txt")));
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
