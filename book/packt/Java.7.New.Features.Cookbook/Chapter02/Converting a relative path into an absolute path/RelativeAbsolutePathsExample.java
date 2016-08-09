
package packt;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativeAbsolutePathsExample {

    public static void main(String[] args) {
        String separator;
        separator = FileSystems.getDefault().getSeparator();
        System.out.println("The separator is " + separator);
        try {
            Path path = Paths.get(new URI("file:///C:/home/docs/users.txt"));
            System.out.println("subpath: " + path.subpath(0, 3));
            path = Paths.get("/home", "docs", "users.txt");
            System.out.println("Absolute path: " + path.toAbsolutePath());
            System.out.println("URI: " + path.toUri());

            //There's More: Bogus File example
//            Path path = Paths.get(new URI("file:///C:/home/docs/bogusfile.txt"));
//		 System.out.println("File exists: " + Files.exists(path));
//            path = Paths.get("/home", "docs", "bogusfile.txt");
		  System.out.println("File exists: " + Files.exists(path));
//            System.out.println("subpath: " + path.subpath(0, 3));  
//            System.out.println("Absolute path: " + path.toAbsolutePath());
//            System.out.println("URI: " + path.toUri());

        } catch (URISyntaxException ex) {
            System.out.println("Bad URI");
        } catch (InvalidPathException ex) {
            System.out.println("Bad path: [" + ex.getInput() + "] at position " + ex.getIndex());
        }
    }
}
