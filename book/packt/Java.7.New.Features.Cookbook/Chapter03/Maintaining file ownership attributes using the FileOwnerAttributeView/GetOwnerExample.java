package packt;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

public class GetOwnerExample {

    public static void main(String[] args) {
        Path path = Paths.get("C:/home/docs/users.txt");
        try {
            FileOwnerAttributeView view = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
            UserPrincipal userPrincipal = view.getOwner();
            System.out.println(userPrincipal.getName());
           
            //There's More Example
//            UserPrincipalLookupService lookupService = FileSystems.getDefault().getUserPrincipalLookupService();
//            userPrincipal = lookupService.lookupPrincipalByName("users");
//            view.setOwner(userPrincipal);
//            System.out.println("UserPrincipal set: " + userPrincipal.getName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
