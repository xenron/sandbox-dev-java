package packt;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class SupportedFileAttributeViews {

    public static void main(String[] args) {
        Path path = Paths.get("C:/home/docs/users.txt");
        FileSystem fileSystem = path.getFileSystem();
        Set<String> supportedViews = fileSystem.supportedFileAttributeViews();

        for (String view : supportedViews) {
            System.out.println(view);
        }
    }
}


        //There's More Example 1
//        try {
//        FileStore fileStore = Files.getFileStore(path);
//            System.out.println("FileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    FileAttributeView.class));
//            System.out.println("BasicFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    BasicFileAttributeView.class));
//            System.out.println("FileOwnerAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    FileOwnerAttributeView.class));
//            System.out.println("AclFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    AclFileAttributeView.class));
//            System.out.println("PosixFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    PosixFileAttributeView.class));
//            System.out.println("UserDefinedFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    UserDefinedFileAttributeView.class));
//            System.out.println("DosFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    DosFileAttributeView.class));
//        } catch (IOException ex) {
//            System.out.println("Attribute view not supported");
//        }

        //There's More Example 2
//        try {
//            FileStore fileStore = Files.getFileStore(path);
//            System.out.println("FileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    "file"));
//            System.out.println("BasicFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    "basic"));
//            System.out.println("FileOwnerAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    "owner"));
//            System.out.println("AclFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    "acl"));
//            System.out.println("PosixFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    "posix"));
//            System.out.println("UserDefinedFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    "user"));
//            System.out.println("DosFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    "dos"));
//        } catch (IOException ex) {
//            System.out.println("Attribute view not supported");
//        }
    }
}
