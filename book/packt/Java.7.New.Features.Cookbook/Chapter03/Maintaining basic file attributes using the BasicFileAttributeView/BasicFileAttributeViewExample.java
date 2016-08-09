package packt;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

public class BasicFileAttributeViewExample {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("/home/docs/users.txt");
        try {
//            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
            BasicFileAttributes attributes = view.readAttributes();

            System.out.println("Creation Time: " + attributes.creationTime());
            System.out.println("Last Accessed Time: " + attributes.lastAccessTime());
            System.out.println("Last Modified Time: " + attributes.lastModifiedTime());
            System.out.println("File Key: " + attributes.fileKey());
            System.out.println("Directory: " + attributes.isDirectory());
            System.out.println("Other Type of File: " + attributes.isOther());
            System.out.println("Regular File: " + attributes.isRegularFile());
            System.out.println("Symbolic File: " + attributes.isSymbolicLink());
            System.out.println("Size: " + attributes.size());
        } catch (IOException ex) {
            System.out.println("Attribute error");
        }
    }
}