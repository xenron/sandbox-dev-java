package packt;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.text.NumberFormat;

public class GettingFileStoreInformation {

    static final long kiloByte = 1024;

    public static void main(String[] args) {
        String format = "%-16s %-20s %-8s %-8s %12s %12s %12s\n";
        System.out.printf(format, "Name", "Filesystem", "Type",
                "Readonly", "Size(KB)", "Used(KB)", "Available(KB)");
        FileSystem fileSystem = FileSystems.getDefault();
        
        for (FileStore fileStore : fileSystem.getFileStores()) {
            try {
                long totalSpace = fileStore.getTotalSpace() / kiloByte;
                long usedSpace = (fileStore.getTotalSpace()
                        - fileStore.getUnallocatedSpace()) / kiloByte;
                long usableSpace = fileStore.getUsableSpace() / kiloByte;
                String name = fileStore.name();
                String type = fileStore.type();
                boolean readOnly = fileStore.isReadOnly();

                NumberFormat numberFormat = NumberFormat.getInstance();
                System.out.printf(format,
                        name, fileStore, type, readOnly,
                        numberFormat.format(totalSpace),
                        numberFormat.format(usedSpace),
                        numberFormat.format(usableSpace));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
