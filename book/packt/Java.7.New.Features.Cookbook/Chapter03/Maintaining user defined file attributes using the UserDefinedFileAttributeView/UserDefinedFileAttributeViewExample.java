package packt;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class UserDefinedFileAttributeViewExample {

        public static void main(String[] args) {
        Path path = Paths.get("C:/home/docs/users.txt");
        try {
            UserDefinedFileAttributeView view = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
            view.write("publishable", Charset.defaultCharset().encode("true"));
            System.out.println("Publishable set");
            
            // There's more section
//            String name = "publishable";
//            ByteBuffer buffer = ByteBuffer.allocate(view.size(name));
//            view.read(name, buffer);
//            buffer.flip();
//            String value = Charset.defaultCharset().decode(buffer).toString();
//            System.out.println(value);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}