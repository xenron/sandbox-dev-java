package packt;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class ContentTypeExample {

    public static void main(String[] args) throws Exception {
        displayContentType("/home/docs/users.txt");
        displayContentType("/home/docs/Chapter 2.doc");
        displayContentType("/home/docs/java.exe");
    }

    static void displayContentType(String pathText) throws Exception {
        Path path = Paths.get(pathText);
        String type = Files.probeContentType(path);
        System.out.println(type);
    }

}
