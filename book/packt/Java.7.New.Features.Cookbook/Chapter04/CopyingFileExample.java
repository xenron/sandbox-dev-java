package packt;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyingFileExample {

    public static void main(String[] args) {
          Path newFile = FileSystems.getDefault().getPath("C:/home/docs/newFile.txt");
        Path copiedFile = FileSystems.getDefault().getPath("C:/home/docs/copiedFile.txt");

           try {
//            Files.createFile(newFile);
//            System.out.println("File created successfully!");
//            Files.copy(newFile, copiedFile);
//            System.out.println("File copied successfully!");
             Files.copy(newFile, copiedFile, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File copied successfully!");
           } catch (IOException e) {
        System.out.println("IO Exception.");
         }

        //There's More: Copying Symbolic Links
//        Path originalLinkedFile = FileSystems.getDefault().getPath("C:/home/music/users.txt");
//        Path newLinkedFile = FileSystems.getDefault().getPath("C:/home/music/users2.txt");
//        try {
//            Files.copy(originalLinkedFile, newLinkedFile);
//            System.out.println("Symbolic link file copied successfully!");
//        } catch (IOException e) {
//            System.out.println("IO Exception.");
//        }
        //There's More: Copy Directory
//        Path originalDirectory = FileSystems.getDefault().getPath("C:/home/docs");
//        Path newDirectory = FileSystems.getDefault().getPath("C:/home/tmp");
//        try {
//            Files.copy(originalDirectory, newDirectory);
//            System.out.println("Directory copied successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //There's More: Copying from an Input Stream
//        Path newFile = FileSystems.getDefault().getPath("C:/home/docs/java7WebSite.html");
//        URI url = URI.create("http://jdk7.java.net/");
//        try (InputStream inputStream = url.toURL().openStream()) {
//            Files.copy(inputStream, newFile);
//            System.out.println("Site copied successfully!");
//        } catch (MalformedURLException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

        //There's More: Copying From and Output Stream
//        Path sourceFile = FileSystems.getDefault().getPath("C:/home/docs/users.txt");
//        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
//            Files.copy(sourceFile, outputStream);
//            byte arr[] = outputStream.toByteArray();
//            System.out.println("The contents of " + sourceFile.getFileName());
//            for (byte data : arr) {
//                System.out.print((char) data);
//            }
//            System.out.println();
//        } catch (MalformedURLException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }




    }
}
