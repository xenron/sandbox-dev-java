package packt;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathResolutionExample {

    public static void main(String[] args) {
        Path rootPath = Paths.get("/home/docs");
        Path partialPath = Paths.get("users.txt");
        Path resolvedPath = rootPath.resolve(partialPath);

        //There's More: alternate examples
        //Path resolvedPath = rootPath.resolve("backup/users.txt");
        //Path resolvedPath = rootPath.resolve("users.txt");

        //There's More: Improper Use examples
        //Path resolvedPath = partialPath.resolve(rootPath);
        //Path resolvedPath = partialPath.resolve(partialPath);
        //Path resolvedPath = rootPath.resolve(rootPath);

        System.out.println("rootPath: " + rootPath);
        System.out.println("partialPath: " + partialPath);
        System.out.println("resolvedPath: " + resolvedPath);
        System.out.println("Resolved absolute path: " + resolvedPath.toAbsolutePath());

        //There's More: Resolved Siblings
//        Path rootPath = Paths.get("/home/music/");
//        Path resolvedPath = rootPath.resolve(partialPath);
//        resolvedPath = rootPath.resolve("tmp/Robot Brain A.mp3");
//        System.out.println("rootPath: " + rootPath);
//        System.out.println("resolvedPath: " + resolvedPath);
//        System.out.println();
//
//        resolvedPath = rootPath.resolveSibling("tmp/Robot Brain A.mp3");
//        System.out.println("rootPath: " + rootPath);
//        System.out.println("resolvedPath: " + resolvedPath);

    }
}
