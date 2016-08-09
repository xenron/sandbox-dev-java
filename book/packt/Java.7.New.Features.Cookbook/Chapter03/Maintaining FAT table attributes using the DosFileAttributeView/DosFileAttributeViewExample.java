package packt;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributeViewExample {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("/home/docs/users.txt");
        try {
            DosFileAttributeView view = Files.getFileAttributeView(path, DosFileAttributeView.class);
            DosFileAttributes attributes = view.readAttributes();

            System.out.println("isArchive: " + attributes.isArchive());
            System.out.println("isHidden: " + attributes.isHidden());
            System.out.println("isReadOnly: " + attributes.isReadOnly());
            System.out.println("isSystem: " + attributes.isSystem());
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
