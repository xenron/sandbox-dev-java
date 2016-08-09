package packt;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SymbolicLinkExample {

    public static void main(String[] args) {

        Path path1 = null;
        Path path2 = null;

        path1 = Paths.get("/home/docs/users.txt");
        path2 = Paths.get("/home/music/users.txt");

        System.out.println(Files.isSymbolicLink(path1));
        System.out.println(Files.isSymbolicLink(path2));

        try {
            Path path = Paths.get(new URI("C:/home/./music/users.txt");
            System.out.println("Normalized: " + path.normalize());
            System.out.println("Absolute path: " + path.toAbsolutePath());
            System.out.println("URI: " + path.toUri());
            System.out.println("toRealPath (Do not follow links): " + path.toRealPath(LinkOption.NOFOLLOW_LINKS));
            System.out.println("toRealPath: " + path.toRealPath());


            Path firstPath = Paths.get("/home/music/users.txt");
            Path secondPath = Paths.get("/docs/status.txt");
            System.out.println("From firstPath to secondPath: " + firstPath.relativize(secondPath));
            System.out.println("From secondPath to firstPath: " + secondPath.relativize(firstPath));
            System.out.println("exists (Do not follow links): " + Files.exists(firstPath, LinkOption.NOFOLLOW_LINKS));
            System.out.println("exists: " + Files.exists(firstPath));
            System.out.println("notExists (Do not follow links): " + Files.notExists(firstPath, LinkOption.NOFOLLOW_LINKS));
            System.out.println("notExists: " + Files.notExists(firstPath));

        } catch (IOException ex) {
            Logger.getLogger(SymbolicLinkExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidPathException ex) {
            System.out.println("Bad path: [" + ex.getInput() + "] at position " + ex.getIndex());
        }
    }
}
