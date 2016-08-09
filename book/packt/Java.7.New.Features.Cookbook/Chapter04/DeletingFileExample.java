package packt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeletingFileExample {

    public static void main(String[] args) {
        try {
            Path sourceFile = Paths.get("C:/home/docs/users.txt");
            Files.delete(sourceFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
