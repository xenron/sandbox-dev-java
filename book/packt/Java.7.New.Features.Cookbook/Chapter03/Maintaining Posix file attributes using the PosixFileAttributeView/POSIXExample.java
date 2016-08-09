package packt;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class POSIXExample {

    public static void main(String[] args) throws Exception {
            Path path = Paths.get("home/docs/users.txt");
            FileSystem fileSystem = path.getFileSystem();
            PosixFileAttributeView view = Files.getFileAttributeView(path, PosixFileAttributeView.class);

            PosixFileAttributes attributes = view.readAttributes();
            System.out.println("Group: " + attributes.group());
            System.out.println("Owner: " + attributes.owner().getName());
            
            Set<PosixFilePermission> permissions = attributes.permissions();
            for(PosixFilePermission permission : permissions) {
                System.out.print(permission.name() + " ");
            }

}
