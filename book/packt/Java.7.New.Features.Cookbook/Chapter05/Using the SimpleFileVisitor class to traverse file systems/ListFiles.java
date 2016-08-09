package packt;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class ListFiles extends SimpleFileVisitor<Path> {
    private final int indentionAmount = 3;
    private int indentionLevel;
    
    public ListFiles() {
        indentionLevel = 0;
    }
    
    private void indent() {
        for(int i=0 ; i<indentionLevel; i++) {
            System.out.print(' ');
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
        indent();
        System.out.println("Visiting file:" + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path directory, IOException e) throws IOException {
        indentionLevel -= indentionAmount;
        indent();
        System.out.println("Finished with the directory: " + directory.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path directory, BasicFileAttributes attributes) throws IOException {
        indent();
        System.out.println("About to traverse the directory: " + directory.getFileName());
        indentionLevel += indentionAmount;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("A file traversal error ocurred");
        return super.visitFileFailed(file, exc);
    }
}
