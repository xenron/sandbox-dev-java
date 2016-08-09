package packt;

import java.nio.file.FileSystems;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UnderstandingPaths {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("/home/docs/status.txt");
        System.out.println();
        System.out.printf("toString: %s\n", path.toString());
        System.out.printf("getFileName: %s\n", path.getFileName());
        System.out.printf("getRoot: %s\n", path.getRoot());
        System.out.printf("getNameCount: %d\n", path.getNameCount());
        for (int index = 0; index < path.getNameCount(); index++) {
            System.out.printf("getName(%d): %s\n", index, path.getName(index));
        }

        }
        System.out.printf("subpath(0,2): %s\n", path.subpath(0, 2));
        System.out.printf("getParent: %s\n", path.getParent());
        System.out.println(path.isAbsolute());

        
        //There's More: Using the get method
//        path = Paths.get("/home", "docs", "users.txt");
//        System.out.println("Absolute path: " + path.toAbsolutePath());
//        path = Paths.get("home", "docs", "users.txt");
//        System.out.println("Absolute path: " + path.toAbsolutePath());
//        try {
//            path = Paths.get("/home\0", "docs", "users.txt");
//            System.out.println("Absolute path: " + path.toAbsolutePath());
//        } catch (InvalidPathException ex) {
//            System.out.println("Bad path: [" + ex.getInput() + "] at position " + ex.getIndex());
//        }


    }
}
