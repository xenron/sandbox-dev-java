package packt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingTheSimpleFileVisitorcClassToTraverseFileSystems {

    public static void main(String[] args) {
        try {
            Path path = Paths.get("/home");
            ListFiles listFiles = new ListFiles();
            Files.walkFileTree(path, listFiles);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


