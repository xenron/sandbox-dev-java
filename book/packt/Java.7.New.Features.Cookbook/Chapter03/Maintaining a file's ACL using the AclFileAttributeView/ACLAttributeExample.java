package packt;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryFlag;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;
import java.util.Set;

public class ACLAttributeExample {

    public static void main(String[] args) {
        Path path = Paths.get("C:/home/docs/users.txt");
        try {
            AclFileAttributeView view = Files.getFileAttributeView(path, AclFileAttributeView.class);
            List<AclEntry> aclEntryList = view.getAcl();
            for (AclEntry entry : aclEntryList) {
                System.out.println("User Principal Name: " + entry.principal().getName());
                System.out.println("ACL Entry Type: " + entry.type());
                displayEntryFlags(entry.flags());
                displayPermissions(entry.permissions());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //There's More Example
//        try {
//            UserPrincipalLookupService lookupService = FileSystems.getDefault().getUserPrincipalLookupService();
//            GroupPrincipal groupPrincipal = lookupService.lookupPrincipalByGroupName("Administrators");
//            UserPrincipal userPrincipal = lookupService.lookupPrincipalByName("Richard");
//            System.out.println(groupPrincipal.getName());
//            System.out.println(userPrincipal.getName());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private static void displayPermissions(Set<AclEntryPermission> permissionSet) {
        if (permissionSet.isEmpty()) {
            System.out.println("No Permissions present");
        } else {
            System.out.println("Permissions");
            for (AclEntryPermission permission : permissionSet) {
                System.out.print(permission.name() + " ");
            }
            System.out.println();
        }
    }

    private static void displayEntryFlags(Set<AclEntryFlag> flagSet) {
        if (flagSet.isEmpty()) {
            System.out.println("No ACL Entry Flags present");
        } else {
            System.out.println("ACL Entry Flags");
            for (AclEntryFlag flag : flagSet) {
                System.out.print(flag.name() + " ");
            }
            System.out.println();
        }
    }
}
