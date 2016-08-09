package packt;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritingYourOwnDirectoryFilter {

    public static void main(String[] args) {
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {

            public boolean accept(Path file) throws IOException {
                return (Files.isHidden(file));
            }
        };

        Path directory = Paths.get("C:/Windows");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory, filter)) {
            for (Path file : directoryStream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException ex) {
            ex.printStackTrace();
        }

    }
}
