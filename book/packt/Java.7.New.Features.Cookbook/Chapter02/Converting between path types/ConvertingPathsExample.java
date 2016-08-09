package packt;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConvertingPathsExample {

    public static void main(String[] args) {
        try {
            Path path;
            path = Paths.get("users.txt");
            
            //There's More
//            path = Paths.get("invalidFileName.txt");
//            if (path.toFile().exists()) {
//                System.out.println("Real path: " + path.toRealPath(LinkOption.NOFOLLOW_LINKS));
//            } else {
//                System.out.println("The file does not exist");
//            }

            System.out.println("URI path: " + path.toUri());
            System.out.println("Absolute path: " + path.toAbsolutePath());
            System.out.println("Real path: " + path.toRealPath(LinkOption.NOFOLLOW_LINKS));
        } catch (IOException ex) {
            Logger.getLogger(ConvertingPathsExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
