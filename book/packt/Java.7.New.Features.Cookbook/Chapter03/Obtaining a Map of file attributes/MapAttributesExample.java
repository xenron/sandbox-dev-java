package packt;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;

public class MapAttributesExample {

public static void main(String[] args) throws Exception {
        Path path = Paths.getPath("/home/docs/users.txt");
        try {
            Map<String, Object> attrsMap = Files.readAttributes(path, "*");
            Set<String> keys = map.keySet();
            
            for(String attribute : keys) {
                out.println(attribute + ": "
                        + Files.getAttribute(path, attribute));                
            }        
         } 
    }

}