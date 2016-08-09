package packt;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class FilteringADirectoryUsingGlobbing {

    public static void main(String[] args) {
        Path directory = Paths.get("C:/Program Files/Java/jdk1.7.0/bin"); 
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory,"java*.exe")) {
            for (Path file : directoryStream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException ex) {
            ex.printStackTrace();
        }
        
        // Using the PathMatcher interface to filter a directory
//        Path directory = Paths.get("C:/Program Files/Java/jdk1.7.0/bin"); 
//        PathMatcher  pathMatcher = FileSystems.getDefault().getPathMatcher("glob:java?.exe");
//        try (DirectoryStream<Path> directoryStream = 
//                Files.newDirectoryStream(directory,"java*.exe")) {
//            for (Path file : directoryStream) {
//                if(pathMatcher.matches(file.getFileName())) {
//                    System.out.println(file.getFileName());
//                }
//            }
//        } catch (IOException | DirectoryIteratorException ex) {
//            ex.printStackTrace();
//        }
        
    }    
}
