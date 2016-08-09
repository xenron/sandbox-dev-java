package packt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MovingFileExample {

    public static void main(String[] args) {
        try {
            Path sourceFile = Paths.get("C:/home/docs/users.txt");
            Path destinationFile = Paths.get("C:/home/music/users.txt");
            Files.move(sourceFile, destinationFile);

//            //There's More: Atomic Move
//            Path sourceFile = Paths.get("C:/home/docs/users.txt");
//            Path destinationFile = Paths.get("C:/home/music/users.txt");
//            Files.move(sourceFile, destinationFile, StandardCopyOption.ATOMIC_MOVE);

//            //There's More: resolveSibling
//            Path sourceFile = Paths.get("C:/home/docs/users.txt");
//            Files.move(sourceFile, sourceFile.resolveSibling(sourceFile.getFileName() + ".bak"));

//            //Or...
//            Files.move(sourceFile, sourceFile.resolveSibling("users.bak"));
//            
//            //Or...
//            Path sourceFile = Paths.get("C:/home/docs/users.txt");
//            String newFileName = sourceFile.getFileName().toString();
//            newFileName = newFileName.substring(0, newFileName.indexOf('.')) + ".bak";
//            Files.move(sourceFile, sourceFile.resolveSibling(newFileName));

//            //There's More: Moving a directory
//            Path sourceFile = Paths.get("C:/home/docs");
//            Path destinationFile = Paths.get("C:/home/music/docs");
//            Files.move(sourceFile, destinationFile);

//            //Or...
//            Path sourceFile = Paths.get("C:/home/docs");
//            Path destinationFile = Paths.get("E:/home/music/docs");
//            Files.move(sourceFile, destinationFile);


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
