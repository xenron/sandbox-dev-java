package packt;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Iterator;
import java.util.Set;

public class PosixFileAttributeViewExample {

    public static void main(String[] args) {
        Path path = Paths.get("home/docs/users.txt");
        listPermissions(path);
        removePermission(path, PosixFilePermission.OWNER_EXECUTE);
        setPermission(path, PosixFilePermission.OWNER_EXECUTE);
        listPermissions(path);
        setGroupPrincipal(path,"mary","mary");
    }

    private static void listPermissions(Path path) {
        try {

            System.out.println("Permission for " + path.getFileName());
            FileSystem fileSystem = path.getFileSystem();
            PosixFileAttributeView view = Files.getFileAttributeView(path, PosixFileAttributeView.class);

            PosixFileAttributes attributes = view.readAttributes();

            System.out.println("Group: " + attributes.group().getName());
            System.out.println("Owner: " + attributes.owner().getName());

            Set<PosixFilePermission> permissions = attributes.permissions();

            System.out.print("Permissions: ");
            for (PosixFilePermission permission : permissions) {
                System.out.print(permission.name() + " ");
            }
            System.out.println();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void setPermission(Path path, PosixFilePermission permission) {
        try {

            System.out.println("\nSetting permission for " + path.getFileName());
            FileSystem fileSystem = path.getFileSystem();
            PosixFileAttributeView view = Files.getFileAttributeView(path, PosixFileAttributeView.class);

            PosixFileAttributes attributes = view.readAttributes();

            Set<PosixFilePermission> permissions = attributes.permissions();
            permissions.add(permission);

            view.setPermissions(permissions);
            System.out.println();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void removePermission(Path path, PosixFilePermission permission) {
        try {
            System.out.println("\nRemoving permission for " + path.getFileName());
            FileSystem fileSystem = path.getFileSystem();
            PosixFileAttributeView view = Files.getFileAttributeView(path, PosixFileAttributeView.class);

            PosixFileAttributes attributes = view.readAttributes();

            Set<PosixFilePermission> permissions = attributes.permissions();
            permissions.remove(permission);

            view.setPermissions(permissions);
            System.out.println();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void setGroupPrincipal(Path path, String userName, String groupName) {
        try {
            System.out.println("Setting owner for " + path.getFileName());
            FileSystem fileSystem = path.getFileSystem();
            PosixFileAttributeView view = Files.getFileAttributeView(path, PosixFileAttributeView.class);

            PosixFileAttributes attributes = view.readAttributes();
            System.out.println("Old Group: " + attributes.group().getName());
            System.out.println("Old Owner: " + attributes.owner().getName());
            System.out.println();
            
            UserPrincipalLookupService lookupService = FileSystems.getDefault().getUserPrincipalLookupService();
            UserPrincipal userPrincipal = lookupService.lookupPrincipalByName(userName);
            GroupPrincipal groupPrincipal = lookupService.lookupPrincipalByGroupName(groupName);
            view.setGroup(groupPrincipal);
            view.setOwner(userPrincipal);

            attributes = view.readAttributes();
            System.out.println("New Group: " + attributes.group().getName());
            System.out.println("New Owner: " + attributes.owner().getName());
            System.out.println();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}