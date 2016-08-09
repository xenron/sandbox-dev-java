package packt;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingFileExample {

    public static void main(String[] args) {

        Path newPath = FileSystems.getDefault().getPath("C:\\home\\docs\\");
        try {
            Path myDirectory = Files.createDirectory(newPath);
            System.out.println("Directory created successfully!");
        } catch (FileAlreadyExistsException a) {
            System.out.println("Directory already exists!");
        } catch (IOException e) {
            System.out.println("IO Exception.");
        }
        Path newFile = FileSystems.getDefault().getPath("C:\\home\\docs\\users.txt");
        try {
            Files.createFile(newFile);
            System.out.println("File created successfully!");
        } catch (FileAlreadyExistsException a) {
            System.out.println("File already exists!");
        } catch (IOException e) {
            System.out.println("IO Exception.");
        }
        try {
            Files.delete(newFile);
            System.out.println("File deleted successfully!");
        } catch (IOException e) {
            System.out.println("IO Exception.");
        }
        try {
            Files.delete(newPath);
            System.out.println("Directory deleted successfully!");
        } catch (IOException e) {
            System.out.println("IO Exception.");
        }
        //There's More:
//        Path directoriesPath = Paths.get("C:/home/test/subtest/subsubtest");
//        try {
//            Path testDirectory = Files.createDirectories(directoriesPath);
//            System.out.println("Directory sequence created successfully!");
//        } catch (IOException e) {
//            System.out.println("IO Exception.");
//        }


    }
}
