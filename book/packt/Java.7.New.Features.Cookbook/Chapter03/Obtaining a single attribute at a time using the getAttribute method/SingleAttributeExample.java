package packt;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class SingleAttributeExample {

    public static void main(String[] args) {
        try {
            Path path = FileSystems.getDefault().getPath("/home/docs/users.txt");
            System.out.println(Files.getAttribute(path, "size"));
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }
}
