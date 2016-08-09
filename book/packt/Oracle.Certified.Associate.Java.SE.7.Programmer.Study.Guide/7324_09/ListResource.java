package packt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListResourceBundle;

public class ListResource extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return resources;
    }
    
    static Object[][] resources = {
        {"FILE_NOT_FOUND", "The file could not be found"},
        {"FILE_EXISTS", "The file already exists"},
        {"UNKNOWN", "Unknown problem with application"},
        {"PREFIXES",new ArrayList(Arrays.asList("Mr.","Ms.","Dr."))}
            
    };
}
