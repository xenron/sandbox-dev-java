package packt;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ManagingSimpleFiles {

    public static void main(String[] args) throws IOException {
            Path path = Paths.get("/home/docs/users.txt");
            byte[] contents = Files.readAllBytes(path);

            for (byte b : contents) {
                System.out.print((char)b);
            }

            // Writing to a simple file
            Path newPath = Paths.get("/home/docs/newUsers.txt");
            byte[] newContents = "Christopher".getBytes();

//            Files.write(newPath, contents, StandardOpenOption.CREATE);
//            Files.write(newPath, newContents, StandardOpenOption.APPEND);
            
            // Reading all of the lines of a file returned as a list
//            Path path = Paths.get("/home/docs/users.txt");
//            List<String> contents = Files.readAllLines(path, Charset.defaultCharset());
//            for (String b : contents) {
//                System.out.println(b);
//            }
           
    }
}
