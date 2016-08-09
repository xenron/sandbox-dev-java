package packt;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class MonitoringFileEeventsUsingWatchEvents {

    public static void main(String[] args) {
        try {
            FileSystem fileSystem = FileSystems.getDefault();
            WatchService watchService = fileSystem.newWatchService();
            Path directory = Paths.get("/home/docs");
            WatchEvent.Kind<?>[] events = {
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY};
            directory.register(watchService, events);
            while (true) {
                System.out.println("Waiting for a watch event");
                WatchKey watchKey = watchService.take();

                System.out.println("Path being watched: " + watchKey.watchable());
                System.out.println();

                if (watchKey.isValid()) {
                    for (WatchEvent<?> event : watchKey.pollEvents()) {
                        System.out.println("Kind: " + event.kind());
                        System.out.println("Context: " + event.context());
                        System.out.println("Count: " + event.count());
                        System.out.println();
                    }

                    boolean valid = watchKey.reset();
                    if (!valid) {
                        // The watchKey is not longer registered
                    }
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
