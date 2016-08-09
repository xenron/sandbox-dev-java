package packt;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;


public class TempFileExample {

    public static void main(String[] args) {

        Path rootDirectory = FileSystems.getDefault().getPath("C:/home/docs");        
        
        try {
            Path tempDirectory = Files.createTempDirectory(rootDirectory, "");
            System.out.println("Temporary directory created successfully!");
            String dirPath = tempDirectory.toString();
            System.out.println(dirPath);
            Path tempFile = Files.createTempFile(tempDirectory,"", "");
            System.out.println("Temporary file created successfully!");
            String filePath = tempFile.toString();
            System.out.println(filePath);
        } catch (IOException e) {
            System.out.println("IO Exception.");
        }
    }
}
