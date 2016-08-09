package packt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ComparingPathsExample {

    public static void main(String[] args) {
        Path path1 = null;
        Path path2 = null;
        Path path3 = null;

        path1 = Paths.get("/home/docs/users.txt");
        path2 = Paths.get("/home/docs/users.txt");
        path3 = Paths.get("/home/music/Future Setting A.mp3");

        testEquals(path1, path2);
        testEquals(path1, path3);

        testCompareTo(path1, path2);
        testCompareTo(path1, path3);

        testSameFile(path1, path2);
        testSameFile(path1, path3);
    }

    private static void testEquals(Path path1, Path path2) {
        if (path1.equals(path2)) {
            System.out.printf("%s and %s are equal\n",
                    path1, path2);
        } else {
            System.out.printf("%s and %s are NOT equal\n",
                    path1, path2);
        }
    }

    private static void testCompareTo(Path path1, Path path2) {
        if (path1.compareTo(path2) == 0) {
            System.out.printf("%s and %s are identical\n",
                    path1, path2);
        } else {
            System.out.printf("%s and %s are NOT identical\n",
                    path1, path2);
        }
    }

    private static void testSameFile(Path path1, Path path2) {
        try {
            if (Files.isSameFile(path1, path2)) {
                System.out.printf("%s and %s are the same file\n",
                        path1, path2);
            } else {
                System.out.printf("%s and %s are NOT the same file\n",
                        path1, path2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
