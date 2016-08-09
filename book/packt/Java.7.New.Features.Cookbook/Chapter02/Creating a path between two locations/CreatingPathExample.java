package packt;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingPathExample {

    public static void main(String[] args) {
        Path firstPath;
        Path secondPath;
        firstPath = Paths.get("music/Future Setting A.mp3");
        secondPath = Paths.get("docs");

        System.out.println("From firstPath to secondPath: " + firstPath.relativize(secondPath));
        System.out.println("From secondPath to firstPath: " + secondPath.relativize(firstPath));
        System.out.println();

        firstPath = Paths.get("music/Future Setting A.mp3");
        secondPath = Paths.get("music");
        System.out.println("From firstPath to secondPath: " + firstPath.relativize(secondPath));
        System.out.println("From secondPath to firstPath: " + secondPath.relativize(firstPath));
        System.out.println();

        firstPath = Paths.get("music/Future Setting A.mp3");
        secondPath = Paths.get("docs/users.txt");
        System.out.println("From firstPath to secondPath: " + firstPath.relativize(secondPath));
        System.out.println("From secondPath to firstPath: " + secondPath.relativize(firstPath));
        System.out.println();

//        How It Works example
//        firstPath = Paths.get("music/Future Setting A.mp3");
//        secondPath = Paths.get("docs/tmp/users.txt");
//        System.out.println("From firstPath to secondPath: " + firstPath.relativize(secondPath));
//        System.out.println("From secondPath to firstPath: " + secondPath.relativize(firstPath));

        //There's More: Paths are equal
//        firstPath = Paths.get("music/Future Setting A.mp3");
//        secondPath = Paths.get("music/Future Setting A.mp3");
//        System.out.println("From firstPath to secondPath: " + firstPath.relativize(secondPath));
//        System.out.println("From secondPath to firstPath: " + secondPath.relativize(firstPath));
//        System.out.println();

        //There's More: One path contains a root
//        firstPath = Paths.get("c:/music/Future Setting A.mp3");
//        secondPath = Paths.get("docs/users.txt");
//        System.out.println("From firstPath to secondPath: " + firstPath.relativize(secondPath));
//        System.out.println("From secondPath to firstPath: " + secondPath.relativize(firstPath));
//        System.out.println();

        //There's More: Both paths contain a root
//        firstPath = Paths.get("c:/music/Future Setting A.mp3");
//        secondPath = Paths.get("c:/docs/users.txt");
//        System.out.println("From firstPath to secondPath: " + firstPath.relativize(secondPath));
//        System.out.println("From secondPath to firstPath: " + secondPath.relativize(firstPath));
//        System.out.println();


    }
}
