package packt;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RemovingRedundanciesExample {

    public static void main(String[] args) {
        Path path = Paths.get("/home/docs/../music/Space Machine A.mp3");
        System.out.println("Absolute path: " + path.toAbsolutePath());
        System.out.println("URI: " + path.toUri());
        System.out.println("Normalized Path: " + path.normalize());
        System.out.println("Normalized URI: " + path.normalize().toUri());
        System.out.println();

        path = Paths.get("/home/./music/ Robot Brain A.mp3");
        System.out.println("Absolute path: " + path.toAbsolutePath());
        System.out.println("URI: " + path.toUri());
        System.out.println("Normalized Path: " + path.normalize());
        System.out.println("Normalized URI: " + path.normalize().toUri());

        //There's More: No Such File Exception Example
//        try {
//            Path path = Paths.get("/home/docs/../music/NonExistentFile.mp3");
//            System.out.println("Absolute path: " + path.toAbsolutePath());
//            System.out.println("Real path: " + path.toRealPath());
//            
//            } catch (IOException ex) {
//            System.out.println("The file does not exist!");
//        }

    }
}
