package packt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeletingADirectoryUsingTheSimpleFileVisitorClass {
 
    public static void main(String[] args) {
        try {
            Files.walkFileTree(Paths.get("/home"), new DeleteDirectory());  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    
}
