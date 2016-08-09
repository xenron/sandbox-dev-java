package packt;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class UnderstandingTheZipFileSystemProvider {

    public static void main(String[] args) {
        Map<String, String> attributes = new HashMap<>();
        attributes.put("create", "true");
        try {
            URI zipFile = URI.create("jar:file:/home.zip");
            try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
                Path path = zipFileSys.getPath("docs");
                Files.createDirectory(path);
                try (DirectoryStream<Path> directoryStream =
                                Files.newDirectoryStream(zipFileSys.getPath("/"));) {
                    for (Path file : directoryStream) {
                        System.out.println(file.getFileName());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
