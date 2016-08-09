package packt;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

public class CopyingADirectoryUsingTheSimpleFileVisitorClass {

    public static void main(String[] args) {
        try {
            Path source = Paths.get("/home");
            Path target = Paths.get("/backup");
            Files.walkFileTree(source,
                    EnumSet.of(FileVisitOption.FOLLOW_LINKS),
                    Integer.MAX_VALUE,
                    new CopyDirectory(source, target));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
