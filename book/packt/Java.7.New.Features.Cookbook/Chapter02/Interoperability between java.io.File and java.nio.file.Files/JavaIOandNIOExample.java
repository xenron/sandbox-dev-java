package packt;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaIOandNIOExample {

    public static void main(String[] args) {
        try {
            Path path =
                    Paths.get(new URI("file:///C:/home/docs/users.txt"));
            File file = new File("C:\\home\\docs\\users.txt");
            Path toPath = file.toPath();
            System.out.println(toPath.equals(path));
        } catch (URISyntaxException e) {
            System.out.println("Bad URI");
        }

    }
}

