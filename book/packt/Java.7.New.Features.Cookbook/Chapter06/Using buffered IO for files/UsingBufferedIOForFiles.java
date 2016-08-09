package packt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UsingBufferedIOForFiles {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/docs/users.txt");
        Charset charset = Charset.forName("ISO-8859-1");
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } 
        
        // Writing to a file using the BufferedWriter class
//        String newName = "Vivian";
//        Path file = Paths.get("/home/docs/users.txt");
//        try (BufferedWriter writer = Files.newBufferedWriter(file, Charset.defaultCharset(), StandardOpenOption.APPEND)) {
//            writer.newLine();
//            writer.write(newName, 0, newName.length());
//        }
        
        // Un-buffered IO support in the Files class
//        Path file = Paths.get("/home/docs/users.txt");
//        Path newFile = Paths.get("/home/docs/newUsers.txt");
//        try (InputStream in = Files.newInputStream(file); 
//             OutputStream out = Files.newOutputStream(newFile,StandardOpenOption.CREATE, 
//                     StandardOpenOption.APPEND)) {
//            int data = in.read();
//            while (data != -1){
//                out.write(data);
//                data = in.read();
//            }
//        }        
    }
    
}
