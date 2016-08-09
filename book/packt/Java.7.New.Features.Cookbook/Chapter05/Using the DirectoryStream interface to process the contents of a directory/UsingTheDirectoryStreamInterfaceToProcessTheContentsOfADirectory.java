package packt;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingTheDirectoryStreamInterfaceToProcessTheContentsOfADirectory {
    
    public static void main(String[] args) {     
        Path directory = Paths.get("/home");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
            for (Path file : directoryStream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException ex) {
            ex.printStackTrace();
        }
    }
}
